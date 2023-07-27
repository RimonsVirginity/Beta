package me.rimon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class GiveCommand implements CommandExecutor {

    private Balls plugin;

    public GiveCommand(Balls plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length != 3) {
                player.sendMessage(ChatColor.BOLD + " /TestGive <player> <item> <amount>");
                return true;

            } else if (args.length == 3) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (Material.matchMaterial(args[1].toUpperCase()) != null) {
                        player.sendMessage("Giving " + player.getName() + ChatColor.GREEN + args[2] + " " + args[1] + ChatColor.YELLOW + ".");
                        target.sendMessage("You have received " + ChatColor.GREEN + args[2] + " " + args[1] + ChatColor.YELLOW + " from " + player.getName() + ChatColor.YELLOW + ".");
                        ItemStack Item = new ItemStack(Material.matchMaterial(args[1].toUpperCase()));
                        Item.setAmount(Integer.parseInt(args[2]));
                        PlayerInventory inv = player.getInventory();
                        inv.addItem(Item);
                    }
                }
            }
        } else {
            sender.sendMessage("SenderNotPlayer");
        }
        return false;
    }
}
