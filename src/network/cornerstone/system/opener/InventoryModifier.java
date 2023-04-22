package network.cornerstone.system.opener;

import network.cornerstone.system.factory.EndUser;
import network.cornerstone.system.helpers.UnifiedUUID;
import network.cornerstone.system.helpers.types.OwnedInventoryIdentifier;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.UUID;

public class InventoryModifier {
    public UnifiedUUID id = UnifiedUUID.from(UUID.randomUUID());
    public EndUser owner;
    public Inventory actuality;
    public CornerstoneInventory prototype;

    public InventoryModifier(CornerstoneInventory prototype) {
        this.prototype = prototype;
    }

    public void changeOutput(Inventory inventory) {
        actuality = inventory;
        setup();
        reopen();
    }

    public void setup() {
        if(owner == null) throw new RuntimeException("No user for inventory!");
        if(actuality == null) actuality = Bukkit.createInventory(new OwnedInventoryIdentifier(this), prototype.rows*9, prototype.titleFor(owner));
        prototype.templates.forEach((slot, template) -> {
            if(slot >= prototype.rows*9) throw new RuntimeException("Slot is out of range for inventory.");
            if(template.check(owner)) {
                actuality.setItem(slot, template.calculate(owner));
            } else if(actuality.getItem(slot) != null) actuality.clear(slot);
        });
    }

    public void applySetting(CornerstoneInventory changeTo) {
        if(owner != null) {
            actuality.clear();
            prototype = changeTo;
            setup();
            return;
        }
        ArrayList<Integer> clearSlots = new ArrayList<>(prototype.templates.keySet());
        prototype = changeTo;
        clearSlots.removeAll(prototype.templates.keySet());
        for (Integer slot : clearSlots) {
            actuality.clear(slot);
        }
        setup();
    }

    public void open(EndUser user) {
        owner = user;
        setup();
        owner.player.openInventory(actuality);
    }

    public void reopen() {
        if(!owner.player.getOpenInventory().getTopInventory().equals(actuality)) {
            owner.player.closeInventory();
            owner.player.openInventory(actuality);
        }
    }
}
