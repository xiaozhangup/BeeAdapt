package me.xiaozhangup.beeadapt;

import me.xiaozhangup.beeadapt.parts.KeepInv;
import me.xiaozhangup.beeadapt.parts.KillDisplay;
import org.bukkit.plugin.Plugin;
import me.xiaozhangup.beeadapt.utils.manager.ListenerManager;

public class BeeAdapt {

    public static Plugin plugin;

    public static void onEnable() {
        plugin = BeeAdaptCore.getPlugin();

        var config = plugin.getConfig();

        if (config.getBoolean("keepinv", true)) {
            new KeepInv(plugin);
        }
        if (config.getBoolean("showkilled", false)) {
            new KillDisplay(plugin);
        }
    }

}
