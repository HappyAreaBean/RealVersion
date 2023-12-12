package cc.happyareabean.realversion;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PaperServerPingListener implements Listener {

    @EventHandler
    public void onPing(PaperServerListPingEvent event) {
        event.setVersion(ServerUtils.getVersion());
    }

}
