package network.cornerstone.system.factory;

import java.util.function.Function;

public class Criteria {
    public enum CriteriaType {
        NONE("none"), PERMISSION("permission"), NAME("name"), UUID("uuid"), CUSTOM("custom");

        final String value;

        CriteriaType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public final CriteriaType type;
    public String standardArgument;
    private final boolean custom;
    public Function<EndUser, Boolean> customArgument;

    public Criteria(CriteriaType type, String argument) {
        custom = false;
        this.type = type;
        standardArgument = argument;
    }

    public Criteria(Function<EndUser, Boolean> function) {
        custom = true;
        type = CriteriaType.CUSTOM;
        customArgument = function;
    }

    public boolean match(EndUser user) {
        if(custom) {
            return customArgument.apply(user);
        } else {
            switch(type) {
                case PERMISSION:
                    return user.permissionCheck(standardArgument);
                case NAME:
                    return user.nameCheck(standardArgument);
                case UUID:
                    return user.uuidCheck(standardArgument);
                default:
                    return true;
            }
        }
    }
}
