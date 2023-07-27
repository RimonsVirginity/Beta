package me.rimon;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;


public class STFU implements Listener {
    @EventHandler
    public void onChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        player.sendTitle(ChatColor.DARK_RED + "FOR THE LOVE OF GOD", ChatColor.RED + "SHUT THE FUCK UP", 1, 50, 1);

    }
}
