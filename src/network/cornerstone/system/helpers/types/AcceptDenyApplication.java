package network.cornerstone.system.helpers.types;

import network.cornerstone.system.factory.Criteria;
import network.cornerstone.system.factory.EndUser;

import java.util.ArrayList;

public class AcceptDenyApplication {
    public final ArrayList<Criteria> accept = new ArrayList<>();
    public final ArrayList<Criteria> deny = new ArrayList<>();

    public boolean check(EndUser user) {
        for(Criteria criteria : deny) {
            if(criteria.match(user)) return false;
        }
        for(Criteria criteria : accept) {
            if(!criteria.match(user)) return false;
        }
        return true;
    }
}
