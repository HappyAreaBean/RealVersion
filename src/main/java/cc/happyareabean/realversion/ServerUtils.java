package cc.happyareabean.realversion;

import org.bukkit.Bukkit;

public class ServerUtils {

    public static String getVersion() {
        return Bukkit.getBukkitVersion().split("-")[0];
    }

}
