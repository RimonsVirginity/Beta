package me.rimon;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class Balls extends JavaPlugin {

    public HashMap<Player, ArrayList<String>> pcords = new HashMap<>();
    public static HashMap<Player, UUID> armorStandMap = new HashMap<>();
    public static List<Location> LavaSponge = new ArrayList<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("Bhelp").setExecutor(new Help());
        getCommand("TestGive").setExecutor(new GiveCommand(this));
        getCommand("Bfly").setExecutor(new Fly());
        getCommand("Bsit").setExecutor(new Sit());
        getCommand("Brtp").setExecutor(new RandomTelePort(this));
        getCommand("Bgive").setExecutor(new GiveItem(this));
        getCommand("Btp").setExecutor(new Teleport());
        getCommand("MyInfo").setExecutor(new Info());
        getCommand("altcheck").setExecutor(new AccountChecker());
        getServer().getPluginManager().registerEvents(new PlayerToggleSneakListener(), this);
        getServer().getPluginManager().registerEvents(new RandomClick(this),this);
        getServer().getPluginManager().registerEvents(new LavaSponge(), this);
        getServer().getPluginManager().registerEvents(new Troll(this), this);
        getServer().getPluginManager().registerEvents(new TeleportStick(this), this);
        getServer().getPluginManager().registerEvents(new KickStick(this),this);
        getServer().getPluginManager().registerEvents(new BanHammer(this),this);
        getServer().getPluginManager().registerEvents(new STFU (),this);
        getServer().getPluginManager().registerEvents(new Welcome(), this);



        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
