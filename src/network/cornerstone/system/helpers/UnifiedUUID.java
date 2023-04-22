package network.cornerstone.system.helpers;

import java.util.ArrayList;
import java.util.UUID;

public class UnifiedUUID {
    public static ArrayList<UnifiedUUID> array = new ArrayList<>();

    public static UnifiedUUID from(UUID uuid) {
        for(UnifiedUUID trying : array) {
            if(trying.string.equalsIgnoreCase(uuid.toString())) return trying;
        }
        return new UnifiedUUID(uuid.toString());
    }

    public final String string;

    public UnifiedUUID(String string) {
        this.string = string;
        array.add(this);
    }
    @Override
    public String toString() {
        return string;
    }
}