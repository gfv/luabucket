package md.zoidberg.luabucket2.util;

/**
 * some day I will put some licence text here, but not now. //apiocera
 */

import org.bukkit.entity.Player;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LuaAssistant {
    public static boolean isPlayer(Object obj) {
        return (obj instanceof Player);
    }

    public static int arrayLength(Object[] o) {
        return o.length;
    }

    public static Object arrayIndex(Object[] o, int index) {
        return o[index];
    }

    public static void log(String s) {
        Logger.getLogger("minecraft").log(Level.INFO, "[LuaBucket]: " + s);
    }
}