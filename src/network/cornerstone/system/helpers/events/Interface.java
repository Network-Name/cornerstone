package network.cornerstone.system.helpers.events;

import network.cornerstone.system.helpers.types.OwnedInventoryIdentifier;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Interface implements Listener {
    public JavaPlugin plugin;

    public Interface(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent iie) {
        if(iie.getInventory().getHolder() instanceof OwnedInventoryIdentifier) {
            iie.setCancelled(true);
            OwnedInventoryIdentifier p = (OwnedInventoryIdentifier) iie.getInventory().getHolder();
            p.getModifier().sendClicked(iie, p, plugin);
        }
    }

    @EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent iie) {
        if(iie.getInventory().getHolder() instanceof OwnedInventoryIdentifier) {
            OwnedInventoryIdentifier p = (OwnedInventoryIdentifier) iie.getInventory().getHolder();
            p.getModifier().sendClosed();
        }
    }
}
