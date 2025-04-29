package me.hal989.betterfarming;

import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public final class Utils {

    public static void send(Player p, String message) {
        p.sendMessage(ChatColor.LIGHT_PURPLE + "[BetterFarming] " + ChatColors.color(message));
    }

    static public int itemsInInventory(Inventory inventory, Material... search) {
        List<Material> wanted = Arrays.asList(search);
        int found = 0;

        for (ItemStack item : inventory.getContents()) {
            if (item != null && wanted.contains(item.getType()))
                found += item.getAmount();
        }

        return found;
    }
}

