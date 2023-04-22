package network.cornerstone.system.factory;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

public class EndUser {
    public final Player player;
    public ArrayList<LinkedHashMap<String, String>> placeholderMaps = new ArrayList<>();

    public EndUser(Player player) {
        this.player = player;
        LinkedHashMap<String, String> newRef = new LinkedHashMap<>();
        newRef.put("player_name", player.getName());
        newRef.put("player_uuid", String.valueOf(player.getUniqueId()));
        newRef.put("player_entity_id", String.valueOf(player.getEntityId()));
        newRef.put("player_locale", player.getLocale());
        newRef.put("player_ip", Objects.requireNonNull(player.getAddress()).toString());
        newRef.put("player_played_before", String.valueOf(player.hasPlayedBefore()));
        placeholderMaps.add(newRef);
    }

    public boolean permissionCheck(String permission) {
        return player.hasPermission(permission);
    }

    public boolean nameCheck(String name) {
        return player.getName().equalsIgnoreCase(name);
    }

    public boolean uuidCheck(String uuid) {
        return player.getUniqueId().toString().replaceAll("-", "").equalsIgnoreCase(uuid.replaceAll("-", ""));
    }
}