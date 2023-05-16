package network.cornerstone.system.helpers.types;

import network.cornerstone.system.factory.EndUser;
import network.cornerstone.system.opener.InventoryModifier;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class OwnedInventoryIdentifier implements InventoryHolder {
    InventoryModifier modifier;
    EndUser endUser;

    public OwnedInventoryIdentifier(InventoryModifier modifier, EndUser user) {
        this.modifier = modifier;
        endUser = user;
    }

    public void setModifier(InventoryModifier modifier) {
        this.modifier = modifier;
    }

    public InventoryModifier getModifier() {
        return modifier;
    }

    @Override
    public Inventory getInventory() {
        return modifier.actuality;
    }

    public EndUser getEndUser() {
        return endUser;
    }
}
