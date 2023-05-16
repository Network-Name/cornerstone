package network.cornerstone.api.building;

import network.cornerstone.system.factory.EndUser;
import network.cornerstone.system.opener.CornerstoneInventory;
import network.cornerstone.system.opener.InventoryModifier;
import org.bukkit.plugin.java.JavaPlugin;

public class InstanceBuilder {
    public static InstanceBuilder with(JavaPlugin plugin, InventoryBuilder builder) {
        return with(plugin, builder.prototype);
    }
    public static InstanceBuilder with(JavaPlugin plugin, CornerstoneInventory inventory) {
        return new InstanceBuilder(plugin, inventory);
    }

    protected static InventoryModifier modifier;

    private InstanceBuilder(JavaPlugin plugin, CornerstoneInventory prototype) {
        modifier = new InventoryModifier(plugin, prototype);
    }

    private InstanceBuilder(JavaPlugin plugin, InventoryBuilder builder) {
        this(plugin, builder.prototype);
    }

    public InstanceBuilder apply(CornerstoneInventory prototype) {
        modifier.applySetting(prototype);
        return this;
    }

    public InstanceBuilder apply(InventoryBuilder builder) {
        return apply(builder.prototype);
    }

    public InstanceBuilder open(EndUser endUser) {
        modifier.open(endUser);
        return this;
    }

    public InstanceBuilder open(PlayerBuilder builder) {
        return open(builder.endUser);
    }

    public InventoryModifier getLegacy() {
        return modifier;
    }
}
