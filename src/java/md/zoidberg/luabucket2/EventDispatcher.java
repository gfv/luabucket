package md.zoidberg.luabucket2;

import md.zoidberg.luabucket2.listeners.ListenerLuaProxy;
import md.zoidberg.luabucket2.util.LuaExportedClosure;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * some day I will put some licence text here, but not now. //apiocera
 */
public class EventDispatcher {
    private static EventDispatcher ourInstance = new EventDispatcher();

    private Map<String, ArrayList<LuaExportedClosure>> event_callbacks = new HashMap<String, ArrayList<LuaExportedClosure>>();
    private Map<String, LuaExportedClosure> command_callbacks = new HashMap<String, LuaExportedClosure>();
    private Map<String, ArrayList<Integer>> scheduled_tasks = new HashMap<String, ArrayList<Integer>>();

    //private ArrayList<Integer> scheduled_tasks = new ArrayList<Integer>();

    private Plugin thisPlugin = null;
    private PluginManager pluginManager;
    private ListenerLuaProxy listenerLuaProxy;

    public static EventDispatcher getInstance() {
        return ourInstance;
    }

    private EventDispatcher() {
        listenerLuaProxy = new ListenerLuaProxy(this);

    }


    // *************** Lua API ********************
    public boolean registerListener(String snip, String ev, LuaFunction callback) {
        if (!(callback instanceof LuaFunction) && !(callback instanceof LuaClosure)) {
            System.out.println("Not a LuaFunction or a LuaClosure.");
            return false;
        }

        if (!event_callbacks.containsKey(ev)) {
            ArrayList<LuaExportedClosure> new_callbacks = new ArrayList<LuaExportedClosure>();
            new_callbacks.add(new LuaExportedClosure(callback, snip));
            event_callbacks.put(ev, new_callbacks);
        } else {
            event_callbacks.get(ev).add(new LuaExportedClosure(callback, snip));
        }
        return true;
    }

    public boolean registerCommand(String snip, String command, LuaFunction callback) {
        log(Level.INFO, snip + " is registering " + command);
        if (!(callback instanceof LuaFunction) && !(callback instanceof LuaClosure)) {
            System.out.println("Not a LuaFunction or a LuaClosure.");
            return false;
        }

        if (command_callbacks.containsKey(command)) {
            return false;
        }
        command_callbacks.put(command, new LuaExportedClosure(callback, snip));
        return true;
    }

    public Server getServer() {
        return thisPlugin.getServer();
    }

    public int scheduleDelayedTask(final String snip, final LuaFunction lf, int delay, int async) {
        Runnable tsk = new Runnable() {
            public void run() {
                try {
                    lf.call();
                } catch (LuaError le) {
                    traceLuaError(snip, le);
                }
            }
        };

        Integer tId;
        if (async == 0) {
            tId = thisPlugin.getServer().getScheduler().scheduleSyncDelayedTask(thisPlugin, tsk, delay);
        } else {
            tId = thisPlugin.getServer().getScheduler().scheduleAsyncDelayedTask(thisPlugin, tsk, delay);
        }

        if (!scheduled_tasks.containsKey(snip)) {
            ArrayList<Integer> sta = new ArrayList<Integer>();
            sta.add(tId);
            scheduled_tasks.put(snip, sta);
        } else {
            scheduled_tasks.get(snip).add(tId);
        }
        return tId;
    }

    // **************** Callbacks for Bukkit ****************
    public void raiseEvent(Event ev) {
        if (event_callbacks.get(ev.getEventName()) == null) return;
        for (LuaExportedClosure fun : event_callbacks.get(ev.getEventName())) {
            try {
                fun.getClosure().call(CoerceJavaToLua.coerce(ev));
            } catch (LuaError le) {
                traceLuaError(fun.getSnip(), le);
            }
        }
    }

    public LuaExportedClosure matchCommand(String command) {
        // todo: rewrite this as a human, not as an Indian guy
        for (Map.Entry<String, LuaExportedClosure> commandListener : command_callbacks.entrySet()) {
            if (command.equals(commandListener.getKey()) || command.startsWith(commandListener.getKey() + " ")) {
                return commandListener.getValue();
            }
        }
        return null;
    }

    public void applyCommand(LuaExportedClosure receiver, CommandSender sender, String command) {
        try {
            receiver.getClosure().call(CoerceJavaToLua.coerce(sender), CoerceJavaToLua.coerce(command));
        } catch (LuaError e) {
            traceLuaError(receiver.getSnip(), e);
        }
    }

    // **************** Not-so-interesting code *************
    private void traceLuaError(String snip, LuaError e) {
        log(Level.SEVERE, snip + " encountered an error: " + e.getMessage());
        e.printStackTrace();
    }

    public void reset() {
        for (ArrayList<Integer> tasks : scheduled_tasks.values()) {
            for (Integer tId : tasks) {
                thisPlugin.getServer().getScheduler().cancelTask(tId);
            }
        }

        scheduled_tasks.clear();
        event_callbacks.clear();
        command_callbacks.clear();
    }

    public void setPlugin(Plugin thisPlugin) {
        this.thisPlugin = thisPlugin;
        this.pluginManager = thisPlugin.getServer().getPluginManager();
        this.pluginManager.registerEvents(listenerLuaProxy, this.thisPlugin);
    }

    private void log(Level level, String message) {
        Logger lg = Logger.getLogger("minecraft");
        lg.log(level, "[LuaBucket]: " + message);
    }
}
