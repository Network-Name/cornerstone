package network.cornerstone.api.building;

import network.cornerstone.system.factory.ItemTemplate;
import network.cornerstone.system.opener.CornerstoneInventory;
import org.bukkit.event.inventory.InventoryType;

public class InventoryBuilder {
    public static InventoryBuilder type(InventoryType type) {
        return new InventoryBuilder(type);
    }

    protected CornerstoneInventory prototype;

    private InventoryBuilder(InventoryType type) {
        prototype = new CornerstoneInventory(type);
    }

    public InventoryBuilder title(String string) {
        prototype.rawTitle = string;
        return this;
    }

    public InventoryBuilder rows(int rows) {
        prototype.rows = rows;
        return this;
    }

    public InventoryBuilder place(int slot, ItemTemplate template) {
        prototype.templates.put(slot, template);
        return this;
    }

    public InventoryBuilder place(int slot, ItemBuilder builder) {
        return place(slot, builder.template);
    }
}
