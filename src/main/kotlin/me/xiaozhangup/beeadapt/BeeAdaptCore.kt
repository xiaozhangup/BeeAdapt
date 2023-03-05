package me.xiaozhangup.beeadapt

import taboolib.common.platform.Plugin
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration
import me.xiaozhangup.beeadapt.utils.manager.ListenerManager
import taboolib.platform.BukkitPlugin

object BeeAdaptCore : Plugin() {
    @JvmStatic
    val plugin: BukkitPlugin by lazy { BukkitPlugin.getInstance() }

    @JvmStatic
    @Config
    lateinit var config: Configuration
        private set

    @JvmStatic
    val listenerManager: ListenerManager = ListenerManager()

    override fun onEnable() {
        plugin.saveDefaultConfig()
        plugin.reloadConfig()

        BeeAdapt.onEnable()

        listenerManager.register()
    }

    override fun onDisable() {
    }

}