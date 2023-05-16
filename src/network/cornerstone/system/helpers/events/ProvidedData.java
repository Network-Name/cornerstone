package network.cornerstone.system.helpers.events;

import network.cornerstone.system.factory.EndUser;
import network.cornerstone.system.opener.InventoryModifier;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.plugin.java.JavaPlugin;

public class ProvidedData {
    public JavaPlugin plugin;
    public EndUser user;
    public InventoryModifier modifier;
    public ClickType clickType;
    public InventoryAction action;

    public ProvidedData(JavaPlugin plugin, EndUser user, InventoryModifier modifier, ClickType clickType, InventoryAction action) {
        this.plugin = plugin;
        this.user = user;
        this.modifier = modifier;
        this.clickType = clickType;
        this.action = action;
    }
}
