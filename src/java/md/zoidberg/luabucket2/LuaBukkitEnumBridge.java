package md.zoidberg.luabucket2;

import org.bukkit.*;
import org.bukkit.event.block.Action;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

/**
 * some day I will put some licence text here, but not now. //apiocera
 */
public class LuaBukkitEnumBridge {
    private static LuaTable coerceEnum(Object[] anEnum) {
        LuaTable rv = new LuaTable();
        for (int i = 0; i < anEnum.length; i++) {
            rv.set(anEnum[i].toString(), CoerceJavaToLua.coerce(anEnum[i]));
        }
        return rv;
    }

    public static LuaTable getMCEnums() { // hand made
        LuaTable mc = new LuaTable();
        mc.set("achievement", coerceEnum(Achievement.values()));
        mc.set("art", coerceEnum(Art.values()));
        mc.set("chatcolor", coerceEnum(ChatColor.values()));
        mc.set("coaltype", coerceEnum(CoalType.values()));
        mc.set("cropstate", coerceEnum(CropState.values()));
        mc.set("difficulty", coerceEnum(Difficulty.values()));
        mc.set("dyecolor", coerceEnum(DyeColor.values()));
        mc.set("effect", coerceEnum(Effect.values()));
        mc.set("gamemode", coerceEnum(GameMode.values()));
        mc.set("grassspecies", coerceEnum(GrassSpecies.values()));
        mc.set("instrument", coerceEnum(Instrument.values()));
        mc.set("material", coerceEnum(Material.values()));
        mc.set("statistic", coerceEnum(Statistic.values()));
        mc.set("treespecies", coerceEnum(TreeSpecies.values()));
        mc.set("treetype", coerceEnum(TreeType.values()));
        mc.set("action", coerceEnum(Action.values()));
        return mc;
    }
}
