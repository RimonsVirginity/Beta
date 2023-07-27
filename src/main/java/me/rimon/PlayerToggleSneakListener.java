package me.rimon;


import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;


public class PlayerToggleSneakListener implements Listener {

    @EventHandler
    void onSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("b.sit")) {

            if (player.isSneaking()) {
                if (Balls.armorStandMap.containsKey(player)) {

                    for (Entity e : player.getNearbyEntities(1, 1, 1)) {

                        if (e.getUniqueId().equals(Balls.armorStandMap.get(player))) {

                            e.remove();
                            return;


                        }


                    }


                }


            }


        }


    }


}
