package me.hal989.betterfarming;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class BetterFarming extends JavaPlugin implements SlimefunAddon {
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
        CustomItemStack farmingCategoryItem = new CustomItemStack(Material.WOODEN_HOE, "&6高级农场");
        betterFarming = new ItemGroup(farmingCategoryId, farmingCategoryItem);
        //endregion
        //region Items Defining
        appleHoe = new SlimefunItemStack("APPLEHOE", Material.WOODEN_HOE, "&c苹果锄头", "", "&7破坏树叶时有更高的几率掉落", "&7一个苹果。");
        goldenAppleHoe = new SlimefunItemStack("GOLDAPPLEHOE", Material.GOLDEN_HOE, "&6金苹果锄头", "", "&7破坏树叶时有几率掉落", "&7一个金苹果。");
        enchGoldenAppleHoe = new SlimefunItemStack("ENCHGOLDAPPLEHOE", Material.GOLDEN_HOE, "&d附魔金苹果锄头", "", "&7破坏树叶时有几率掉落", "&7一个附魔金苹果。");
        greenRupee = new SlimefunItemStack("GREENRUPEE", Material.EMERALD, "&a绿色卢比", "");
        breakablePot = new SlimefunItemStack("BREAKABLEPOT", Material.BOWL, "&6易碎罐头", "", "&f右键点击 - 获得 4-5 个卢比");
        blueRupee = new SlimefunItemStack("BLUERUPEE", Material.LAPIS_LAZULI, "&1蓝色卢比", "");
        redRupee = new SlimefunItemStack("REDRUPEE", Material.RED_DYE, "&c红色卢比", "");
        purpleRupee = new SlimefunItemStack("PURPLERUPEE", Material.PURPLE_DYE, "&5紫色卢比", "");
        orangeRupee = new SlimefunItemStack("ORANGERUPEE", Material.ORANGE_DYE, "&6橙色卢比", "");
        silverRupee = new SlimefunItemStack("SILVERRUPEE", Material.LIGHT_GRAY_DYE, "&7银卢比", "");
        goldRupee = new SlimefunItemStack("GOLDRUPEE", Material.GLOWSTONE_DUST, "&e金卢比", "");
        kokiriSword = new SlimefunItemStack("KOKIRISWORD", Material.WOODEN_SWORD, "&a科基利剑", "", "&a用这把剑破坏草可能会", "&a掉落卢比。");
        magicalSword = new SlimefunItemStack("MAGICALSWORD", Material.IRON_SWORD, "&f魔法剑", "", "&a用这把剑破坏草可能会", "&a掉落卢比。");
        masterSword = new SlimefunItemStack("MASTERSWORD", Material.DIAMOND_SWORD, "&b大师之剑", "", "&a用这把剑破坏草可能会", "&a掉落卢比。", "&a当你满血时，卢比掉落几率提升。");
        // SlimefunItemStack fierceDeitySword = new SlimefunItemStack("FIERCEDEITYSWORD", Material.DIAMOND_SWORD, "&c勇者之剑", "", "&a用这把剑攻击敌人可能会","&a掉落卢比。","&6当你满血时，掉落几率提升。");
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
        Research lozSwordsResearch = new Research(lozSwordsResearchId, 425689, "一个人去很危险！", 22);
        lozSwordsResearch.addItems(kokiriSword, magicalSword, masterSword);
        lozSwordsResearch.register();
        NamespacedKey potResearchId = new NamespacedKey(this, "pot_r");
        Research potResearch = new Research(potResearchId, 425691, "易碎的罐头", 5);
        potResearch.addItems(breakablePot);
        potResearch.register();
        NamespacedKey rupeeResearchId = new NamespacedKey(this, "rupee_r");
        Research rupeeResearch = new Research(rupeeResearchId, 425691, "致富经", 20);
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
        return "https://github.com/balugaq/betterfarming/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }
}


