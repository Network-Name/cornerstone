package network.cornerstone.api.building;

import network.cornerstone.system.factory.ItemTemplate;
import org.bukkit.Material;

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
}
