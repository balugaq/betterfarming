package me.hal989.betterfarming;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterFarming extends JavaPlugin implements SlimefunAddon {
	public static SlimefunItemStack fierceDeitySword;
    public static ItemGroup betterFarming;
    public static SlimefunItemStack goldenAppleHoe;
    public static SlimefunItemStack enchGoldenAppleHoe;
    public static SlimefunItemStack appleHoe;
    public static SlimefunItemStack breakablePot;
    public static SlimefunItemStack greenRupee;
    public static SlimefunItemStack blueRupee;
    public static SlimefunItemStack redRupee;
    public static SlimefunItemStack purpleRupee;
    public static SlimefunItemStack orangeRupee;
    public static SlimefunItemStack silverRupee;
    public static SlimefunItemStack goldRupee;
    public static SlimefunItemStack kokiriSword;
    public static SlimefunItemStack magicalSword;
    public static SlimefunItemStack masterSword;
    public static SlimefunItemStack fierceDeitySword;
    public static SlimefunItemStack phantomSword;
    private static BetterFarming plugin;

    public static BetterFarming getInstance() {
        return plugin;
    }

    @Override

    public void onEnable() {
        //region Set-Up
        plugin = this;
        new BlockBreakHandler(this);
        NamespacedKey farmingCategoryId = new NamespacedKey(this, "farming_items");
        CustomItemStack farmingCategoryItem = new CustomItemStack(Material.WOODEN_HOE, "&6Addon Jam: Better Farming");
        betterFarming = new ItemGroup(farmingCategoryId, farmingCategoryItem);
        //endregion
        //region Items Defining
        appleHoe = new SlimefunItemStack("APPLEHOE", Material.WOODEN_HOE, "&cApple Hoe", "", "&7Grants an increased chance to drop", "&7an apple when breaking a leaf.");
        goldenAppleHoe = new SlimefunItemStack("GOLDAPPLEHOE", Material.GOLDEN_HOE, "&6Golden Apple Hoe", "", "&7Grants a chance to drop", "&7a golden apple when breaking a leaf.");
        enchGoldenAppleHoe = new SlimefunItemStack("ENCHGOLDAPPLEHOE", Material.GOLDEN_HOE, "&dGolden Apple Hoe", "", "&7Grants a chance to drop", "&7an enchanted golden apple when breaking a leaf.");
        greenRupee = new SlimefunItemStack("GREENRUPEE", Material.EMERALD, "&aGreen Rupee", "");
        breakablePot = new SlimefunItemStack("BREAKABLEPOT", Material.BOWL, "&6Breakable Pot", "", "&fRight Click - Receive 4-5 rupees");
        blueRupee = new SlimefunItemStack("BLUERUPEE", Material.LAPIS_LAZULI, "&1Blue Rupee", "");
        redRupee = new SlimefunItemStack("REDRUPEE", Material.RED_DYE, "&cRed Rupee", "");
        purpleRupee = new SlimefunItemStack("PURPLERUPEE", Material.PURPLE_DYE, "&5Purple Rupee", "");
        orangeRupee = new SlimefunItemStack("ORANGERUPEE", Material.ORANGE_DYE, "&6Orange Rupee", "");
        silverRupee = new SlimefunItemStack("SILVERRUPEE", Material.LIGHT_GRAY_DYE, "&7Silver Rupee", "");
        goldRupee = new SlimefunItemStack("GOLDRUPEE", Material.GLOWSTONE_DUST, "&eGold Rupee", "");
        kokiriSword = new SlimefunItemStack("KOKIRISWORD", Material.WOODEN_SWORD, "&aKokiri Sword", "", "&aBreaking grass with this may", "&aresult in rupees dropping.");
        magicalSword = new SlimefunItemStack("MAGICALSWORD", Material.IRON_SWORD, "&fMagical Sword", "", "&aBreaking grass with this may", "&aresult in rupees dropping.");
        masterSword = new SlimefunItemStack("MASTERSWORD", Material.DIAMOND_SWORD, "&bMaster Sword", "", "&aBreaking grass with this may", "&aresult in rupees dropping.", "&aRupee drops boosted while you are at full health.");
        //SlimefunItemStack fierceDeitySword = new SlimefunItemStack("FIERCEDEITYSWORD", Material.DIAMOND_SWORD, "&cFierce Deity Sword", "", "&aHitting enemies with this may","&aresult in rupees dropping.","&6Boosted while you are at full health.");
        masterSword.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        enchGoldenAppleHoe.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        //endregion
        //region Recipe Making
        ItemStack[] potRecipe = {
                new ItemStack(Material.BRICKS), new ItemStack(Material.BRICKS), new ItemStack(Material.BRICKS),
                new ItemStack(Material.BRICKS), null, new ItemStack(Material.BRICKS),
                new ItemStack(Material.BRICKS), new ItemStack(Material.BRICKS), new ItemStack(Material.BRICKS)
        };
        ItemStack[] greenRupeeRecipe = {
                new ItemStack(Material.EMERALD), new ItemStack(Material.REDSTONE), null,
                null, null, null,
                null, null, null
        };
        ItemStack[] blueRupeeRecipe = {
                greenRupee, greenRupee, null,
                greenRupee, greenRupee, null,
                null, null, null
        };
        ItemStack[] redRupeeRecipe = {
                blueRupee, blueRupee, null,
                blueRupee, blueRupee, null,
                null, null, null
        };
        ItemStack[] purpleRupeeRecipe = {
                redRupee, redRupee, null,
                redRupee, redRupee, null,
                null, null, null
        };
        ItemStack[] orangeRupeeRecipe = {
                purpleRupee, purpleRupee, null,
                purpleRupee, purpleRupee, null,
                null, null, null
        };
        ItemStack[] silverRupeeRecipe = {
                orangeRupee, orangeRupee, null,
                orangeRupee, orangeRupee, null,
                null, null, null
        };
        ItemStack[] goldRupeeRecipe = {
                silverRupee, silverRupee, null,
                silverRupee, silverRupee, null,
                null, null, null
        };
        ItemStack[] kokiriSwordRecipe = {
                greenRupee, greenRupee, greenRupee,
                greenRupee, new ItemStack(Material.WOODEN_SWORD), greenRupee,
                greenRupee, greenRupee, greenRupee
        };
        ItemStack[] magicalSwordRecipe = {
                redRupee, redRupee, redRupee,
                redRupee, kokiriSword, redRupee,
                redRupee, redRupee, redRupee
        };
        ItemStack[] masterSwordRecipe = {
                silverRupee, silverRupee, silverRupee,
                silverRupee, magicalSword, silverRupee,
                silverRupee, silverRupee, silverRupee
        };
        ItemStack[] appleHoeRecipe = {
                new ItemStack(Material.APPLE), new ItemStack(Material.APPLE), new ItemStack(Material.APPLE),
                new ItemStack(Material.APPLE), new ItemStack(Material.WOODEN_HOE), new ItemStack(Material.APPLE),
                new ItemStack(Material.APPLE), new ItemStack(Material.APPLE), new ItemStack(Material.APPLE)
        };
        ItemStack[] goldenAppleHoeRecipe = {
                new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLDEN_APPLE),
                new ItemStack(Material.GOLDEN_APPLE), appleHoe, new ItemStack(Material.GOLDEN_APPLE),
                new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLDEN_APPLE), new ItemStack(Material.GOLDEN_APPLE)
        };
        ItemStack[] enchGoldenAppleHoeRecipe = {
                new ItemStack(Material.ENCHANTED_GOLDEN_APPLE), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE),
                new ItemStack(Material.ENCHANTED_GOLDEN_APPLE), goldenAppleHoe, new ItemStack(Material.ENCHANTED_GOLDEN_APPLE),
                new ItemStack(Material.ENCHANTED_GOLDEN_APPLE), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE)
        };
        //endregion
        //region Declaring Items
        SlimefunItem greenRupeeItem = new NotPlaceableItem(betterFarming, greenRupee, RecipeType.SMELTERY, greenRupeeRecipe);
        greenRupeeItem.register(this);
        SlimefunItem blueRupeeItem = new NotPlaceableItem(betterFarming, blueRupee, RecipeType.ENHANCED_CRAFTING_TABLE, blueRupeeRecipe);
        blueRupeeItem.register(this);
        SlimefunItem redRupeeItem = new NotPlaceableItem(betterFarming, redRupee, RecipeType.ENHANCED_CRAFTING_TABLE, redRupeeRecipe);
        redRupeeItem.register(this);
        SlimefunItem purpleRupeeItem = new NotPlaceableItem(betterFarming, purpleRupee, RecipeType.ENHANCED_CRAFTING_TABLE, purpleRupeeRecipe);
        purpleRupeeItem.register(this);
        SlimefunItem orangeRupeeItem = new NotPlaceableItem(betterFarming, orangeRupee, RecipeType.ENHANCED_CRAFTING_TABLE, orangeRupeeRecipe);
        orangeRupeeItem.register(this);
        SlimefunItem silverRupeeItem = new NotPlaceableItem(betterFarming, silverRupee, RecipeType.ENHANCED_CRAFTING_TABLE, silverRupeeRecipe);
        silverRupeeItem.register(this);
        SlimefunItem goldRupeeItem = new NotPlaceableItem(betterFarming, goldRupee, RecipeType.ENHANCED_CRAFTING_TABLE, goldRupeeRecipe);
        goldRupeeItem.register(this);
        SlimefunItem kokiriSwordItem = new NotPlaceableItem(betterFarming, kokiriSword, RecipeType.ENHANCED_CRAFTING_TABLE, kokiriSwordRecipe);
        kokiriSwordItem.register(this);
        SlimefunItem magicalSwordItem = new NotPlaceableItem(betterFarming, magicalSword, RecipeType.ENHANCED_CRAFTING_TABLE, magicalSwordRecipe);
        magicalSwordItem.register(this);
        SlimefunItem masterSwordItem = new NotPlaceableItem(betterFarming, masterSword, RecipeType.ENHANCED_CRAFTING_TABLE, masterSwordRecipe);
        masterSwordItem.register(this);
        SlimefunItem appleHoeItem = new NotPlaceableItem(betterFarming, appleHoe, RecipeType.ENHANCED_CRAFTING_TABLE, appleHoeRecipe);
        appleHoeItem.register(this);
        SlimefunItem goldenAppleHoeItem = new NotPlaceableItem(betterFarming, goldenAppleHoe, RecipeType.ENHANCED_CRAFTING_TABLE, goldenAppleHoeRecipe);
        goldenAppleHoeItem.register(this);
        SlimefunItem enchGoldenAppleHoeItem = new NotPlaceableItem(betterFarming, enchGoldenAppleHoe, RecipeType.ENHANCED_CRAFTING_TABLE, enchGoldenAppleHoeRecipe);
        enchGoldenAppleHoeItem.register(this);
        BreakablePot breakablePotItem = new BreakablePot(betterFarming, breakablePot, RecipeType.SMELTERY, potRecipe);
        breakablePotItem.register(this);
        //endregion
        //region Adding Research
        NamespacedKey lozSwordsResearchId = new NamespacedKey(this, "lozswords_r");
        Research lozSwordsResearch = new Research(lozSwordsResearchId, 425689, "It's Dangerous To Go Alone!", 22);
        lozSwordsResearch.addItems(kokiriSword, magicalSword, masterSword);
        lozSwordsResearch.register();
        NamespacedKey potResearchId = new NamespacedKey(this, "pot_r");
        Research potResearch = new Research(potResearchId, 425691, "Breakable Pots", 5);
        potResearch.addItems(breakablePot);
        potResearch.register();
        NamespacedKey rupeeResearchId = new NamespacedKey(this, "rupee_r");
        Research rupeeResearch = new Research(rupeeResearchId, 425691, "Getting A Little Richer", 20);
        rupeeResearch.addItems(breakablePot);
        rupeeResearch.register();
        //endregion


    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return "https://github.com/Gavin296/betterfarming/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }
}


