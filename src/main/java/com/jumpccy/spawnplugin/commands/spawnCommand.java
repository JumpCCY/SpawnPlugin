package com.jumpccy.spawnplugin.commands;

import com.jumpccy.spawnplugin.spawnPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCommand implements CommandExecutor {


    private final spawnPlugin plugin;

    public spawnCommand(spawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (command.getName().equalsIgnoreCase("setspawn")) {
             if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation();

            plugin.getConfig().set("spawnPos", location);
            plugin.saveConfig();
            player.sendMessage("Set!");
             }
        }
    else if (command.getName().equalsIgnoreCase("spawn")) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Location location = (Location) plugin.getConfig().get("spawnPos");
           if (location != null){
               player.teleport(location);
           }
        }

    }

        return true;
    }
}
