package me.rimon;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomTelePort implements CommandExecutor {

    public Balls plugin;

    public RandomTelePort(Balls plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("B.rtp")) {


                player.teleport(TeleportUtils.generateLocation(player, plugin));

            }
        }
        return true;
    }
}
