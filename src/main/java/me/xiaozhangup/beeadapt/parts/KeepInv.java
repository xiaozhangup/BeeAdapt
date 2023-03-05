package me.xiaozhangup.beeadapt.parts;

import me.xiaozhangup.beeadapt.BeeAdaptCore;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.plugin.Plugin;

public class KeepInv implements Listener {

    public KeepInv() {
        BeeAdaptCore.getListenerManager().addListener(this);
        Bukkit.getWorlds().forEach(world -> {
            world.setGameRule(GameRule.KEEP_INVENTORY, true);
        });
    }

    @EventHandler
    public void on(WorldLoadEvent e) {
        e.getWorld().setGameRule(GameRule.KEEP_INVENTORY, true);
    }

}
