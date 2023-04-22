package network.cornerstone.api.building;

import network.cornerstone.system.factory.EndUser;
import org.bukkit.entity.Player;

import java.util.LinkedHashMap;

public class PlayerBuilder {
    public static PlayerBuilder from(Player player) {
        return new PlayerBuilder(player);
    }

    protected final EndUser endUser;

    private PlayerBuilder(Player player) {
        endUser = new EndUser(player);
    }

    public PlayerBuilder connectVariables(LinkedHashMap<String, String> map) {
        endUser.placeholderMaps.add(map);
        return this;
    }

    public PlayerBuilder variable(String key, String value) {
        endUser.placeholderMaps.get(0).put(key, value);
        return this;
    }
}
