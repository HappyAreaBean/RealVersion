package cc.happyareabean.realversion;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RealVersion extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();

        if (canUsePaperListener()) {
            pm.registerEvents(new PaperServerPingListener(), this);
        } else if (pm.isPluginEnabled("ProtocolLib")) {
            new ServerPingPacketListener(this);
        }
    }

    private boolean canUsePaperListener() {
        try {
            Class.forName("com.destroystokyo.paper.event.server.PaperServerListPingEvent");
            return true;
        } catch (final ClassNotFoundException e) {
            return false;
        }
    }

}