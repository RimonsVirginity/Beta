package me.rimon;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Sit implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

     if (sender instanceof Player){
         Player player = (Player) sender;
         if (player.hasPermission("B.sit")) {
             Location location = player.getLocation();
             location.setY(location.getY()-0.2);
             ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
             armorStand.addPassenger(player);

             armorStand.setSmall(true);
             armorStand.setMarker(true);
             armorStand.setVisible(false);

             if (Balls.armorStandMap.containsKey(player)) {
                 Balls.armorStandMap.replace(player, armorStand.getUniqueId());


             }
            else {
                Balls.armorStandMap.put(player, armorStand.getUniqueId());
             }



             return true;

         }




     }























        return false;
    }
}
