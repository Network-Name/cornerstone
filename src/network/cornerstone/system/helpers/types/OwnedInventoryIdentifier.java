package network.cornerstone.system.helpers.types;

import network.cornerstone.system.helpers.UnifiedUUID;
import network.cornerstone.system.opener.InventoryModifier;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class OwnedInventoryIdentifier implements InventoryHolder {
    InventoryModifier modifier;

    public OwnedInventoryIdentifier(InventoryModifier modifier) {
        this.modifier = modifier;
    }

    public void setModifier(InventoryModifier modifier) {
        this.modifier = modifier;
    }

    public InventoryModifier getModifier() {
        return modifier;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }
}
