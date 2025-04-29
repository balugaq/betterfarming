package me.hal989.betterfarming;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.hal989.betterfarming.BetterFarming.breakablePot;
import static me.hal989.betterfarming.BetterFarming.greenRupee;

public class BreakablePot extends SlimefunItem {

    public BreakablePot(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {

        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        Player p = event.getPlayer();
        p.getInventory().removeItem(breakablePot);
        p.getInventory().addItem(greenRupee);
        p.getInventory().addItem(greenRupee);
        p.getInventory().addItem(greenRupee);
        p.getInventory().addItem(greenRupee);
        if(Math.random()>0.6){p.getInventory().addItem(greenRupee);
        }
    }
}
