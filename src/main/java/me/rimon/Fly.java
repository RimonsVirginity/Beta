package me.rimon;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
         Player player = (Player) sender;
        if (player.hasPermission("B.fly")) {
        if (player.isFlying()) {
         player.setAllowFlight(false);
         player.sendMessage(ChatColor.AQUA + " You have " + ChatColor.RED + "disabled " + ChatColor.AQUA + "flight ");
        } else {
         player.setAllowFlight(true);
         player.sendMessage(ChatColor.AQUA + " You have " + ChatColor.GREEN + "enabled " + ChatColor.AQUA + "flight ");
        } return true;
        }
        } return false;
        }
        }
