package me.xiaozhangup.beeadapt.parts;

import ink.ptms.adyeshach.core.Adyeshach;
import ink.ptms.adyeshach.core.entity.EntityTypes;
import ink.ptms.adyeshach.core.entity.manager.Manager;
import ink.ptms.adyeshach.core.entity.manager.ManagerType;
import ink.ptms.adyeshach.core.entity.type.AdyArmorStand;
import me.xiaozhangup.beeadapt.BeeAdaptCore;
import me.xiaozhangup.beeadapt.utils.tools.IString;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class KillDisplay implements Listener {

    public static final Manager manager = Adyeshach.INSTANCE.api().getPublicEntityManager(ManagerType.TEMPORARY);
    private static final Random RANDOM = new Random();

    public KillDisplay() {
        BeeAdaptCore.getListenerManager().addListener(this);
    }

    @EventHandler
    public void on(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player player && e.getEntity() instanceof LivingEntity livingEntity) {
            Location location = e.getEntity().getLocation().clone();
            AdyArmorStand text = (AdyArmorStand) manager.create(EntityTypes.ARMOR_STAND, location.add(0, e.getEntity().getHeight() - 1.5, 0));

            Bukkit.getScheduler().runTaskLater(BeeAdaptCore.getPlugin(), text::remove, 15L);

            text.addViewer(player);
            text.setSmall(true);
            text.setInvisible(true);
            text.setMarker(false);
            text.setCustomNameVisible(true);

            BigDecimal bd = BigDecimal.valueOf(e.getFinalDamage());
            bd = bd.setScale(2, RoundingMode.FLOOR);
            if (livingEntity.getHealth() <= e.getFinalDamage()) {
                text.setCustomName(IString.addColor("&x&c&6&d&0&f&5☠ " + bd));
            } else {
                if (e.isCritical()) {
                    text.setCustomName(IString.addColor("&x&e&6&4&5&5&3🗡 " + bd));
                } else {
                    text.setCustomName(IString.addColor("&x&e&e&b&e&b&e🗡 " + bd));
                }
            }

            text.setVelocity(new Vector(0, 0.45, 0));
        }
    }

}
