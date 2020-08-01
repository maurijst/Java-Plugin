package me.maurhice.commandos;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;


public class Knight implements Listener {
    public Plugin plugin = Commandos.getPlugin(Commandos.class);



    public void customRecipe() {
        ItemStack KnightChest = new ItemStack(Material.DIAMOND_CHESTPLATE,1);
        ItemMeta KnightChest_Meta = KnightChest.getItemMeta();

        KnightChest_Meta.setDisplayName(ChatColor.DARK_GREEN + "Knight Chestplate");
        ArrayList<String> KnightChest_lore = new ArrayList<String>();
        KnightChest_lore.add(ChatColor.GREEN + "Soldaten Chestplate");
        KnightChest_Meta.setLore(KnightChest_lore);
        KnightChest_Meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4,true);
        KnightChest_Meta.addEnchant(Enchantment.DURABILITY,3,true);
        KnightChest_Meta.addEnchant(Enchantment.MENDING,1,true);
        KnightChest.setItemMeta(KnightChest_Meta);





        ShapedRecipe Mending_Recipe = new ShapedRecipe(KnightChest);

        Mending_Recipe.shape("D D", "IDI", "DID");
        Mending_Recipe.setIngredient('D', Material.DIAMOND_BLOCK);
        Mending_Recipe.setIngredient('I', Material.DIAMOND);

        plugin.getServer().addRecipe(Mending_Recipe);

        ItemStack MendingBook = new ItemStack(Material.ENCHANTED_BOOK,1);
        EnchantmentStorageMeta MendingBook_Meta = (EnchantmentStorageMeta) MendingBook.getItemMeta();
        MendingBook_Meta.addStoredEnchant(Enchantment.MENDING,1,true);
        MendingBook.setItemMeta(MendingBook_Meta);


        ShapedRecipe MendingBook_Recipe = new ShapedRecipe(MendingBook);

        MendingBook_Recipe.shape(" D ", "DID", " D ");
        MendingBook_Recipe.setIngredient('D', Material.DIAMOND_BLOCK);
        MendingBook_Recipe.setIngredient('I', Material.BOOK);

        plugin.getServer().addRecipe(MendingBook_Recipe);

        ItemStack Steak = new ItemStack(Material.COOKED_BEEF,1);
        ItemMeta Steak_Meta = Steak.getItemMeta();
        Steak.setItemMeta(Steak_Meta);


        ShapedRecipe Steak_Recipe = new ShapedRecipe(Steak);

        Steak_Recipe.shape("   ", " R ", " B ");
        Steak_Recipe.setIngredient('R', Material.REDSTONE);
        Steak_Recipe.setIngredient('B', Material.RAW_BEEF);

        plugin.getServer().addRecipe(Steak_Recipe);




    }


}



