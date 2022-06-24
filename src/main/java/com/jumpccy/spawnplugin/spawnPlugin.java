package com.jumpccy.spawnplugin;

import com.jumpccy.spawnplugin.commands.spawnCommand;
import com.jumpccy.spawnplugin.listeners.spawnListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class spawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
    getConfig().options().copyDefaults();
    saveConfig();

    getCommand("setspawn").setExecutor(new spawnCommand(this));
    getCommand("spawn").setExecutor(new spawnCommand(this));
    getServer().getPluginManager().registerEvents(new spawnListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
