package md.zoidberg.luabucket2.listeners;

import md.zoidberg.luabucket2.EventDispatcher;
import md.zoidberg.luabucket2.util.LuaExportedClosure;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

/**
 * some day I will put some licence text here, but not now. //apiocera
 */
public class LuaCommandPreprocessListener implements Listener {
    private EventDispatcher dispatcher;

    public LuaCommandPreprocessListener() {
        dispatcher = EventDispatcher.getInstance();
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent ev) {
        LuaExportedClosure receiver = dispatcher.matchCommand(ev.getMessage().substring(1));
        if (receiver != null) {
            dispatcher.applyCommand(receiver, ev.getPlayer(), ev.getMessage());
            ev.setCancelled(true);
        }
    }

    @EventHandler
    public void onServerCommand(ServerCommandEvent ev) {
        LuaExportedClosure receiver = dispatcher.matchCommand(ev.getCommand());
        if (receiver != null) {
            dispatcher.applyCommand(receiver, ev.getSender(), ev.getCommand());
            ev.setCommand("luazerocommand");
        }
    }
}