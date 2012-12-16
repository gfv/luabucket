package md.zoidberg.luabucket2;

import md.zoidberg.luabucket2.listeners.LuaCommandPreprocessListener;
import md.zoidberg.luabucket2.util.LuaAssistant;
import md.zoidberg.luabucket2.util.SnipLoader;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.luaj.vm2.*;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.*;
import java.util.logging.Logger;

/**
 * some day I will put some licence text here, but not now. //apiocera
 */
public class LuaBucketPlugin extends JavaPlugin {
    private static String logPrefix = "[LuaBucket]: ";
    private static Logger log = Logger.getLogger("Minecraft");

    private String external_init;

    LuaCommandPreprocessListener luaCommandPreprocessListener;

    private EventDispatcher dispatcher = EventDispatcher.getInstance();

    private File dataFolder;

    public void onEnable() {
        // default shit
        PluginDescriptionFile pdfFile = this.getDescription();
        logPrefix = "[" + pdfFile.getName() + "]: ";
        log.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " running " + Lua._VERSION);

        // creating a configuration directory if it doesn't exist yet
        dataFolder = new File(getDataFolder().getAbsolutePath());
        if (!dataFolder.exists()) {
            if (!dataFolder.mkdir()) {
                log.severe(logPrefix + "config directory not present and is unable to be made. No operations follow.");
                return;
            }
        }

        luaCommandPreprocessListener = new LuaCommandPreprocessListener();
        this.getServer().getPluginManager().registerEvents(luaCommandPreprocessListener, this);
        FileConfiguration config = getConfig();

        external_init = config.getString("external-init", null);
        dispatcher.setPlugin(this);
        runLua();
    }

    public void onDisable() {
        log.info(logPrefix + "is disabled!");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("luareload")) {
            if (!sender.isOp()) {
                sender.sendMessage("You have to be an op to restart Lua.");
            } else {
                runLua();
            }
            return true;
        } else if (cmd.getName().equalsIgnoreCase("luazerocommand")) {
            return true;
        }
        return false;
    }


    private void runLua() {
        dispatcher.reset();
        SnipLoader ldr;
        InputStream init;
        LuaTable globals = getGlobalsTable();

        try {
            init = ((external_init == null) ? getClass().getResourceAsStream("/lua/init.lua") : new FileInputStream(external_init));
        } catch (FileNotFoundException e) {
            Logger.getLogger("minecraft").warning("[LuaBucket]: could not find external init file " + external_init + "; falling back to internal.\n" +
                    "Tip: external init file path is relative to CraftBukkit directory, this may be the problem");

            init = getClass().getResourceAsStream("/lua/init.lua");
        }
        try {
            LuaFunction lf = LoadState.load(init, "init", globals);
            ldr = new SnipLoader((LuaFunction) lf.call());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (LuaError e) {
            Logger.getLogger("minecraft").severe("[LuaBucket]: error uncaught by loader, probably an error in it: " + e.getMessage());
        } finally {
            try {
                init.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private LuaTable getGlobalsTable() {
        LuaTable globals = JsePlatform.standardGlobals();
        globals.set("dispatcher", CoerceJavaToLua.coerce(dispatcher));
        globals.set("assistant", CoerceJavaToLua.coerce(new LuaAssistant()));
        globals.set("logger", CoerceJavaToLua.coerce(Logger.getLogger("minecraft")));
        globals.set("serhver", CoerceJavaToLua.coerce(this.getServer()));
        globals.set("sniplist", getSnipList());
        globals.set("mc", LuaBukkitEnumBridge.getMCEnums());
        return globals;
    }

    private void stopLua() {
        dispatcher.reset();
    }

    private LuaTable getSnipList() {
        LuaTable snips = new LuaTable();
        File[] children = dataFolder.listFiles();
        if (children != null) {
            for (File f : children) {
                if (f.getName().endsWith(".lua")) {
                    LuaTable snip = new LuaTable();
                    snip.set("name", f.getName());
                    snip.set("path", CoerceJavaToLua.coerce(f.getAbsolutePath()));
                    snips.insert(0, snip);
                }
            }
        }
        return snips;
    }
}
