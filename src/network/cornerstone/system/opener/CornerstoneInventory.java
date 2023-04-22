package network.cornerstone.system.opener;

import network.cornerstone.system.factory.EndUser;
import network.cornerstone.system.factory.ItemTemplate;
import network.cornerstone.system.helpers.Placeholders;
import network.cornerstone.system.helpers.Translator;
import network.cornerstone.system.helpers.types.AcceptDenyApplication;
import org.bukkit.event.inventory.InventoryType;

import java.util.LinkedHashMap;

public class CornerstoneInventory extends AcceptDenyApplication {
    public InventoryType type;
    public String rawTitle = "Cornerstone Plugin: No Title Provided";
    public int rows = 3;

    public CornerstoneInventory(InventoryType archetype) {
        type = archetype;
    }

    public CornerstoneInventory(InventoryType archetype, String title, int rowCount) {
        this(archetype);
        rawTitle = title;
        rows = rowCount;
    }

    public LinkedHashMap<Integer, ItemTemplate> templates = new LinkedHashMap<>();

    public String titleFor(EndUser user) {
        return Translator.evaluate(user, Placeholders.evaluate(user, rawTitle));
    }
}
