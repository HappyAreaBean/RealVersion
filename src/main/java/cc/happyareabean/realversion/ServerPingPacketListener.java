package cc.happyareabean.realversion;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedServerPing;
import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class ServerPingPacketListener extends PacketAdapter {

    public ServerPingPacketListener(Plugin plugin) {
        super(plugin, PacketType.Status.Server.SERVER_INFO);
        ProtocolLibrary.getProtocolManager().addPacketListener(this);
    }

    @Override
    public void onPacketSending(final PacketEvent event) {

        final WrappedServerPing ping = event.getPacket().getServerPings().read(0);
        ping.setVersionName(ServerUtils.getVersion());
    }

}
