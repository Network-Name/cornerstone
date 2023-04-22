package network.cornerstone.system.factory;

import network.cornerstone.system.helpers.types.AcceptDenyApplication;
import network.cornerstone.system.helpers.LoreTool;
import network.cornerstone.system.helpers.Placeholders;
import network.cornerstone.system.helpers.Translator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemTemplate extends AcceptDenyApplication {
    public Material material;
    public String rawName = "";
    public String rawLore = "";

    public ItemTemplate(Material material) {
        this.material = material;
    }

    public ItemTemplate(Material material, String rawName, String rawLore) {
        this.material = material;
        this.rawName = rawName;
        this.rawLore = rawLore;
    }

    public ItemStack calculate(EndUser user) {
        ItemStack generated = new ItemStack(material);
        String displayName = ChatColor.GRAY + Translator.evaluate(user, Placeholders.evaluate(user, rawName));
        List<String> lore = new ArrayList<>();
        if(!rawLore.equals("")) lore = LoreTool.checker(Translator.evaluate(user, Placeholders.evaluate(user, rawLore)));
        ItemMeta meta = generated.getItemMeta();
        assert meta != null;
        meta.setDisplayName(displayName);
        meta.setLore(lore);
        generated.setItemMeta(meta);
        return generated;
    }
}
