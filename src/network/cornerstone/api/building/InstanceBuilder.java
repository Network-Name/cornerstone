package network.cornerstone.api.building;

import network.cornerstone.system.factory.EndUser;
import network.cornerstone.system.opener.CornerstoneInventory;
import network.cornerstone.system.opener.InventoryModifier;

public class InstanceBuilder {
    public static InstanceBuilder with(InventoryBuilder builder) {
        return with(builder.prototype);
    }
    public static InstanceBuilder with(CornerstoneInventory inventory) {
        return new InstanceBuilder(inventory);
    }

    protected static InventoryModifier modifier;

    private InstanceBuilder(CornerstoneInventory prototype) {
        modifier = new InventoryModifier(prototype);
    }

    private InstanceBuilder(InventoryBuilder builder) {
        this(builder.prototype);
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
}
