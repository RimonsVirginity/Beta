package me.rimon;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Info implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String ip = player.getAddress().getHostName();
            String health = String.valueOf(player.getHealth());
            String nick = player.getDisplayName();
            String gamemode = player.getGameMode().getDeclaringClass().getName();
            String uuid = player.getUniqueId().getClass().getName();
            String playtime = String.valueOf(player.getPlayerTime());
            String speed = String.valueOf(player.getFlySpeed());
            String loc = String.valueOf(player.getLocation());

            player.sendMessage(ip);
            player.sendMessage(health);
            player.sendMessage(nick);
            player.sendMessage(gamemode);
            player.sendMessage(uuid);
            player.sendMessage(playtime);
            player.sendMessage(speed);
            player.sendMessage(loc);


        }
        return false;
    }
}
