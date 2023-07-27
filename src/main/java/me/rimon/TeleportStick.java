package me.rimon;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class TeleportStick implements Listener {

    private final Balls plugin;

    public TeleportStick(Balls plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        if (!event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.STICK)) return;
        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("TeleportStick")){

            if (event.getAction() == Action.RIGHT_CLICK_AIR){
                Player player = event.getPlayer();
                Block b = player.getTargetBlock(null,plugin.getConfig().getInt("TeleportStick.Distance"));
                Location location = b.getLocation();
                event.getPlayer().teleport(location);

            }

        }

    }
}