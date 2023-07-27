package me.rimon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (sender instanceof Player){

            Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please enter a player's name");
                player.sendMessage(ChatColor.YELLOW + "To teleport yourself: /Btp <PlayerName>");
                player.sendMessage(ChatColor.YELLOW + "To teleport players: /Btp <PlayerName> <OtherPlayer>");
            }else if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                player.teleport(target.getLocation());
            }else if(args.length == 2){
                //first player
                Player playerToSend = Bukkit.getPlayer(args[0]);
                Player target = Bukkit.getPlayer(args[1]);
                playerToSend.teleport(target.getLocation());

            }
        }

        return true;
    }
}
