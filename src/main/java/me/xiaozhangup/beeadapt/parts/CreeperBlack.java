package me.xiaozhangup.beeadapt.parts;

import me.xiaozhangup.beeadapt.BeeAdaptCore;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreeperBlack implements Listener {

    public static Set<Material> materials = new HashSet<>();

    public CreeperBlack(List<String> blocks) {
        BeeAdaptCore.getListenerManager().addListener(this);

        blocks.forEach(type -> {
            materials.add(Material.getMaterial(type));
        });
    }

    @EventHandler
    public void on(EntityExplodeEvent e) {
        if (e.getEntity().getType() == EntityType.CREEPER) {
            e.blockList().removeIf(block -> materials.contains(block.getType()));
        }
    }

}
