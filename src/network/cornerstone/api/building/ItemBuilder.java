package network.cornerstone.api.building;

import network.cornerstone.system.factory.ItemTemplate;
import network.cornerstone.system.helpers.events.ExpectedResponse;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;

import java.util.LinkedHashMap;

public class ItemBuilder {
    public static ItemBuilder material(Material material) {
        return new ItemBuilder(material);
    }

    protected final ItemTemplate template;

    private ItemBuilder(Material material) {
        template = new ItemTemplate(material);
    }

    public ItemBuilder name(String string) {
        template.rawName = string;
        return this;
    }

    public ItemBuilder lore(String string) {
        template.rawLore = string;
        return this;
    }

    public ItemBuilder onlyAction(ExpectedResponse response) {
        LinkedHashMap<ClickType, ExpectedResponse> clickTypes = new LinkedHashMap();
        clickTypes.put(ClickType.LEFT, response);
        clickTypes.put(ClickType.RIGHT, response);
        clickTypes.put(ClickType.SHIFT_LEFT, response);
        clickTypes.put(ClickType.SHIFT_RIGHT, response);
        clickTypes.put(ClickType.MIDDLE, response);
        clickTypes.put(ClickType.DROP, response);
        clickTypes.put(ClickType.CONTROL_DROP, response);
        clickTypes.put(ClickType.SWAP_OFFHAND, response);
        clickTypes.put(ClickType.DOUBLE_CLICK, response);
        clickTypes.put(ClickType.CREATIVE, response);
        clickTypes.put(ClickType.UNKNOWN, response);
        template.actions = clickTypes;
        return this;
    }

    public ItemBuilder action(ClickType click, ExpectedResponse response) {
        template.actions.put(click, response);
        return this;
    }

    public ItemTemplate getLegacy() {
        return template;
    }
}
