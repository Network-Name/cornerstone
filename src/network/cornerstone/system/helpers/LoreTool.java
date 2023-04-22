package network.cornerstone.system.helpers;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoreTool {
    public static int MAX_CHAR_PER_LINE = 38;

    public static List<String> checker(String string) {
        ArrayList<String> generated = new ArrayList<>();
        ChatColor curColor = ChatColor.GRAY;
        StringBuilder builder = new StringBuilder(String.valueOf(curColor));
        String[] str2 = string.split(" ");
        int t = 0;
        for(int i = 0; i < str2.length; i++) {
            String that = str2[i];
            String that2 = "";
            if(str2.length>=i+2) that2 = str2[i+1];
            builder.append(that).append(" ");
            t += that.length() + 1;
            if(t+that2.length() >= MAX_CHAR_PER_LINE) {
                t = 0;
                while(builder.toString().length()<MAX_CHAR_PER_LINE) builder.append(" ");
                generated.add(builder.toString());
                curColor = latestColor(builder.toString());
                builder = new StringBuilder();
                builder.append(curColor.toString());
            }
        }
        if(builder.toString().length() > 0) {
            while(builder.toString().length()<MAX_CHAR_PER_LINE) builder.append(" ");
            generated.add(builder.toString());
        }
        return Arrays.asList(generated.toArray(new String[0]));
    }

    public static ChatColor latestColor(String string) {
        for(int i = string.length()-2; i >= 0; i--) {
            if(string.charAt(i) == '§') return ChatColor.getByChar(string.charAt(i+1));
        }
        return ChatColor.GRAY;
    }
}
