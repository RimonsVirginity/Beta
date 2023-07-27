package me.rimon;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.util.Vector;

import java.util.Random;


public class Troll implements Listener {


    private Balls plugin;
    public Troll(Balls plugin) {this.plugin = plugin;}


    @EventHandler
    public void OnSleep(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        Location loc = event.getBed().getLocation();
        Vector v = player.getVelocity();
        v.setZ(randomNumberNZ());
        Bukkit.broadcastMessage(v.getZ()+"");
        v.setY(5);
        Bukkit.broadcastMessage(v.getY()+"");
        v.setX(randomNumberNX());
        Bukkit.broadcastMessage(v.getX()+"");
        player.setVelocity(v);
        player.getWorld().createExplosion(player.getLocation(),20);
        Bukkit.broadcastMessage("Guys " + player.getDisplayName() + " tried to sleep, LOL. Sleep is for the weak ");

    }

    public int randomNumberNX() {
        Random random3 = new Random();
        int xRandom = random3.nextInt(plugin.getConfig().getInt("RandomTelePort.Bounds.x") -
                plugin.getConfig().getInt("RandomTelePort.Bounds.-x")) + plugin.getConfig().getInt("RandomTelePort.Bounds.-x");
        return xRandom;

    }

    public int randomNumberNZ() {
        Random random4 = new Random();
        int xRandom = random4.nextInt(plugin.getConfig().getInt("RandomTelePort.Bounds.z") -
                plugin.getConfig().getInt("RandomTelePort.Bounds.-z")) + plugin.getConfig().getInt("RandomTelePort.Bounds.-z");
        return xRandom;

    }


    @EventHandler
    public void OnRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Welcome back to life");

    }

}
