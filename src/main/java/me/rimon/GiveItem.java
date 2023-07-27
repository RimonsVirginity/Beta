package me.rimon;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveItem implements CommandExecutor {

    private Balls plugin;
    public GiveItem(Balls plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("B.Give")){
                ItemStack i = new ItemStack(Material.matchMaterial(plugin.getConfig().getString("GiveItem.Item")),1);
                player.getInventory().addItem(i);

                return true;
            }
        }
        return false;
    }
}
