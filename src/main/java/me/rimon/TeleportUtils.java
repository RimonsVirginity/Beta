package me.rimon;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Random;

public class TeleportUtils {

    public Balls plugin;

    public TeleportUtils(Balls plugin) {
        this.plugin = plugin;
    }

    public static HashSet<Material> bad_blocks = new HashSet<>();

    static {
        bad_blocks.add(Material.LAVA);
        bad_blocks.add(Material.WATER);


    }

    public static Location generateLocation(Player player, Plugin plugin) {
        Random random = new Random();
        int x = random.nextInt(plugin.getConfig().getInt("RandomTelePort.Bounds.x"));
        int y = 150;
        int z = random.nextInt(plugin.getConfig().getInt("RandomTelePort.Bounds.z"));


        Location randomLocation = new Location(player.getWorld(), x, y, z);

        y = randomLocation.getWorld().getHighestBlockYAt(randomLocation) + 1;
        randomLocation.setY(y);

        while (!isLocationSafe(randomLocation)) {
            randomLocation = generateLocation(player, plugin);
        }
        return randomLocation;
    }


    public static boolean isLocationSafe(Location location) {

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        Block block = location.getWorld().getBlockAt(x, y, z);
        Block below = location.getWorld().getBlockAt(x, y - 1, z);
        Block above = location.getWorld().getBlockAt(x, y + 1, z);
        return !(bad_blocks.contains(below.getType()) || (block.getType().isSolid()) || (above.getType().isSolid()));


    }


}
