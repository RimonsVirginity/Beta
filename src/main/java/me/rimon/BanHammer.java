package me.rimon;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;


public class BanHammer implements Listener {

    private final Balls plugin;

    public BanHammer(Balls plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_AXE)) { return; }
        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("BanHammer")) {
            Player clickedPlayer = (Player) event.getRightClicked();
            clickedPlayer.getName();
            Bukkit.getBanList(BanList.Type.NAME).addBan(clickedPlayer.getName(),null, null,player.getName());
            clickedPlayer.kickPlayer(ChatColor.DARK_RED+"You've just been Banned ");
            player.sendMessage(ChatColor.DARK_RED + "You have Banned " + clickedPlayer.getName());

        }


    }
}

