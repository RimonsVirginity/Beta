package me.rimon;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;


public class KickStick implements Listener {

    private final Balls plugin;

    public KickStick(Balls plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BLAZE_ROD)) { return; }
        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("KickStick")) {
            Player clickedPlayer = (Player) event.getRightClicked();
            clickedPlayer.kickPlayer("You've just been kicked");
            player.sendMessage(ChatColor.RED + "You have kicked " + clickedPlayer.getName());

        }


    }
}

