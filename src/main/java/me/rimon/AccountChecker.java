package me.rimon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class AccountChecker implements CommandExecutor {


    private CommandSender sender;
    private Command command;
    private String label;
    private String[] args;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.getUniqueId() != uuid) {
                String ipAddress = onlinePlayer.getAddress().getAddress().getHostAddress();
                if (ipAddress.equals(player.getAddress().getAddress().getHostAddress())) {
                    player.sendMessage(ChatColor.RED + "You have been detected as having an alt account!");
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
        if (command.getName().equalsIgnoreCase("altCheck")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "This command can only be used by players!");
                return true;
            }
            Player player = (Player) sender;
            onPlayerJoin(new PlayerJoinEvent(player, ""));
            return true;
        }
        return false;
    }




}
