package me.hal989.betterfarming;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import static me.hal989.betterfarming.BetterFarming.*;

public class BlockBreakHandler implements Listener {
    public BlockBreakHandler(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Material blockName = e.getBlock().getType();
        Block block = e.getBlock();
        Player p = e.getPlayer();
        if(blockName.equals(Material.OAK_LEAVES)||blockName.equals(Material.DARK_OAK_LEAVES)||blockName.equals(Material.SPRUCE_LEAVES)||blockName.equals(Material.BIRCH_LEAVES)||blockName.equals(Material.ACACIA_LEAVES)||blockName.equals(Material.JUNGLE_LEAVES)){
            if(SlimefunItem.getByItem(p.getInventory().getItemInMainHand()).getID().equals(appleHoe.getItemId())){
                if(Math.random()<0.3){
                 block.getWorld().dropItemNaturally(block.getLocation(),new ItemStack(Material.APPLE));
                }
            }
            if(SlimefunItem.getByItem(p.getInventory().getItemInMainHand()).getID().equals(goldenAppleHoe.getItemId())){
                if(Math.random()<0.1){
                    block.getWorld().dropItemNaturally(block.getLocation(),new ItemStack(Material.GOLDEN_APPLE));
                }
            }
            if(SlimefunItem.getByItem(p.getInventory().getItemInMainHand()).getID().equals(enchGoldenAppleHoe.getItemId())){
                if(Math.random()<0.05){
                    block.getWorld().dropItemNaturally(block.getLocation(),new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
                }
            }
        }
        if(blockName.equals(Material.GRASS)||blockName.equals(Material.TALL_GRASS)){
            p.sendMessage(String.valueOf(SlimefunItem.getByItem(p.getInventory().getItemInMainHand()).getID()));
            if(String.valueOf(SlimefunItem.getByItem(p.getInventory().getItemInMainHand()).getID()).equals("KOKIRISWORD")){
                p.sendMessage("kokiri sword");
                p.sendMessage(String.valueOf(SlimefunItem.getByItem(p.getInventory().getItemInMainHand()).getID()));
                p.sendMessage(String.valueOf(blueRupee));
                p.sendMessage(String.valueOf(greenRupee));
                if(Math.random()>0.5){
                    if(Math.random()<0.9){p.getInventory().addItem(new ItemStack(greenRupee));}
                    else{p.getInventory().addItem(new ItemStack(blueRupee));}
                }
            }
            if(SlimefunItem.getByItem(p.getInventory().getItemInMainHand()).getID().equals(magicalSword.getItemId())){
                if(Math.random()>0.3){
                    if(Math.random()<0.9){block.getWorld().dropItemNaturally(block.getLocation(), blueRupee);}
                    else{block.getWorld().dropItemNaturally(block.getLocation(), redRupee);}
                }
            }
            if(SlimefunItem.getByItem(p.getInventory().getItemInMainHand()).getID().equals(masterSword.getItemId())){
                if((Math.random()>0.3)||p.getHealth()>19){
                    if(Math.random()<0.9){block.getWorld().dropItemNaturally(block.getLocation(), redRupee);}
                    else{block.getWorld().dropItemNaturally(block.getLocation(), purpleRupee);}
                }
                else{
                    if(Math.random()<0.5){block.getWorld().dropItemNaturally(block.getLocation(), redRupee);}
                }
            }
        }

    }

}
