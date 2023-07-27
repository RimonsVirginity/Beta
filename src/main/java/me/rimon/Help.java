package me.rimon;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("Bruh you really need help");
            Bukkit.broadcastMessage("Guys " + player.getDisplayName() + " needs help. LMAO ");
            return true;
        }





        return false;
    }
}
