package network.cornerstone.system.helpers.events;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import network.cornerstone.system.opener.CornerstoneInventory;
import network.cornerstone.system.opener.InventoryModifier;

import java.util.function.Function;

public class ExpectedResponse {
    public static ExpectedResponse DEFAULT = new ExpectedResponse(ResponseType.NONE);

    public enum ResponseType {
        NONE("none", null), CLOSE("close", null), TRANSITION("transition", CornerstoneInventory.class), DIFFERENT("different", InventoryModifier.class), COMMAND("command", String.class), SERVER("server", String.class), FUNNEL_QUEUE("funnel_queue", String.class), FUNCTION("function", Function.class);

        final String data;
        final Class expectedDataType;

        ResponseType(String data, Class<?> expectedDataType) {
            this.data = data;
            this.expectedDataType = expectedDataType;
        }

        public String getData() {
            return data;
        }

        public Class<?> getExpectedDataType() {
            return expectedDataType;
        }
    }

    public ResponseType type;
    public Object referenceObject;
    public Function<ProvidedData, Boolean> customReference;

    public ExpectedResponse(ResponseType type) {
        this.type = type;
    }

    public ExpectedResponse(CornerstoneInventory template) {
        type = ResponseType.TRANSITION;
        referenceObject = template;
    }

    public ExpectedResponse(InventoryModifier modifier) {
        type = ResponseType.DIFFERENT;
        referenceObject = modifier;
    }

    public ExpectedResponse(Function<ProvidedData, Boolean> function) {
        type = ResponseType.FUNCTION;
        customReference = function;
    }

    public ExpectedResponse(ResponseType type, String reference) {
        this.type = type;
        referenceObject = reference;
    }

    public void run(ProvidedData data) {
        if(type == ResponseType.NONE || type == null || referenceObject == null) return;
        switch(type) {
            case CLOSE:
                data.modifier.close();
                break;
            case TRANSITION:
                data.modifier.applySetting((CornerstoneInventory) referenceObject);
                break;
            case DIFFERENT:
                data.modifier.close();
                ((InventoryModifier) referenceObject).open(data.user);
                break;
            case COMMAND:
                data.user.player.performCommand((String) referenceObject);
                break;
            case FUNCTION:
                if(customReference != null) customReference.apply(data);
                break;
            case SERVER:
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("Connect");
                out.writeUTF((String) referenceObject);
                data.user.player.sendPluginMessage(data.plugin, "BungeeCord", out.toByteArray());
                break;
            case FUNNEL_QUEUE:
                ByteArrayDataOutput out2 = ByteStreams.newDataOutput();
                out2.writeUTF("Funnel.Queue");
                out2.writeUTF((String) referenceObject);
                data.user.player.sendPluginMessage(data.plugin, "BungeeCord", out2.toByteArray());
                break;
        }
    }
}
