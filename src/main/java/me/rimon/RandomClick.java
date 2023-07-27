package me.rimon;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class RandomClick implements Listener{

    private Balls plugin;
    public RandomClick(Balls plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event){

        if (event.getAction()== Action.RIGHT_CLICK_BLOCK){
            
            Block block = event.getClickedBlock();
            if (block.getType() == Material.matchMaterial(plugin.getConfig().getString("RandomClick.Blocks.Input"))){
                block.setType(Material.matchMaterial(plugin.getConfig().getString("RandomClick.Blocks.Output")));






            }

        }

    }

}
