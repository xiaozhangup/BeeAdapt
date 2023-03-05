package me.xiaozhangup.beeadapt;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import me.xiaozhangup.beeadapt.utils.manager.ListenerManager;

public class BeeAdapt extends JavaPlugin {

    public static Plugin plugin;
    public static ListenerManager listenerManager = new ListenerManager();

    @Override
    public void onEnable() {
        plugin = this;

//        listenerManager.addListeners(
//                /*Your event*/
//        );
//        listenerManager.register();

//        Command.register("example", (commandSender, command, s, inside) -> {
//            /*your way*/
//            return false;
//        });



    }

}
