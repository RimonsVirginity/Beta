package me.rimon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class LavaSponge implements Listener {

    @EventHandler
    void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Material material = event.getBlockPlaced().getType();
        if (player.hasPermission("b.lavasponge")) {
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("LavaSponge")) {
                if (material == Material.SPONGE) {

                    // run command
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    Bukkit.getServer().dispatchCommand(console, "lp user " +player.getName()+ " permission settemp worldedit.replacenear true 2s");
                    Bukkit.getServer().dispatchCommand(player, "/replacenear 3 lava air");

                    // message
                    player.sendMessage("Done!");


                }
            }
        }

    }
}