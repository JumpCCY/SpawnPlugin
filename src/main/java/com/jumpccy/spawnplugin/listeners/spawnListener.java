package com.jumpccy.spawnplugin.listeners;

import com.jumpccy.spawnplugin.spawnPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class spawnListener implements Listener {

    private final spawnPlugin plugin;

    public spawnListener(spawnPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();
        Location location = (Location) plugin.getConfig().get("spawnPos");
        if (location != null){
            player.teleport(location);
        }

    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        Player player = e.getPlayer();
        Location location = (Location) plugin.getConfig().get("spawnPos");
        if (location != null){
            e.setRespawnLocation(location);
        }
    }
}
