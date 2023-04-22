package network.cornerstone.api;

import network.cornerstone.api.building.InstanceBuilder;
import network.cornerstone.api.conversion.ConversionOutput;
import org.bukkit.entity.Player;
import org.json.JSONObject;

public class Cornerstone {
    private static InstanceBuilder __INSTANCE_BUILDER;
    public ConversionOutput runParser(String data, Player player) {
        return runParser(new JSONObject(data), player);
    }

    public ConversionOutput runParser(JSONObject data, Player player) {
//        return new ConversionOutput();
        return null;
    }
}
