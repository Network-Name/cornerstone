package network.cornerstone.system.helpers;

import network.cornerstone.system.factory.EndUser;

import java.util.LinkedHashMap;

public class Placeholders {
    public static String evaluate(EndUser user, String string) {
        if(!string.contains("%")) return string;
        for(LinkedHashMap<String, String> map : user.placeholderMaps) {
            for (String pKey : map.keySet()) {
                string = string.replaceAll("%" + pKey + "%", map.get(pKey));
            }
        }
        return string;
    }
}
