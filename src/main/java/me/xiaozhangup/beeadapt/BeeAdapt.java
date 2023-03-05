package me.xiaozhangup.beeadapt;

import me.xiaozhangup.beeadapt.parts.KeepInv;
import me.xiaozhangup.beeadapt.parts.KillDisplay;
import org.bukkit.plugin.Plugin;

public class BeeAdapt {

    public static Plugin plugin;

    public static void onEnable() {
        plugin = BeeAdaptCore.getPlugin();

        var config = plugin.getConfig();

        if (config.getBoolean("keepinv", true)) {
            new KeepInv();
        }
        if (config.getBoolean("showkilled", false)) {
            new KillDisplay();
        }
    }

}
