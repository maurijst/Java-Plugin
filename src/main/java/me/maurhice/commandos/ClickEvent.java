package me.maurhice.commandos;

import me.maurhice.commandos.utils.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.awt.*;

import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.getWorld;

public class ClickEvent implements Listener {


    @EventHandler
    public void Clickevent(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.DARK_AQUA + "Commands GUI")) {

            switch (e.getCurrentItem().getType()) {
                case TNT:
                    player.closeInventory();
                    player.setHealth(0);
                    player.sendMessage(ChatColor.DARK_RED + "You took the easy way out");
                    break;
                case PUMPKIN_PIE:
                    if (player.isOp()) {
                        player.closeInventory();
                        ;
                        player.setFoodLevel(20);
                        player.sendMessage(ChatColor.GREEN + "You fed yourself!");
                    } else {
                        player.sendMessage(ChatColor.DARK_GREEN + "Geen permissies om te Feeden");
                        player.closeInventory();
                    }
                    break;
                case FEATHER:
                    if (player.isOp()) {
                        if (player.getAllowFlight() == false) {
                            player.closeInventory();
                            player.setAllowFlight(true);
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERDRAGON_FLAP, 100, 100);
                            String message =  Utils.chat( "&5Flight has been enabled");
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                        } else {
                            player.closeInventory();
                            player.setAllowFlight(false);
                            player.playEffect(EntityEffect.HURT_EXPLOSION);
                            player.sendMessage(ChatColor.RED + "Flight has been disabled");
                        }

                    } else {
                        player.sendMessage(ChatColor.DARK_GREEN + "Geen permissies om te vliegen");
                        player.closeInventory();

                    }
                    break;
                case BEACON:
                    if (player.isOp()) {
                        if (player.isGlowing() == false) {
                            player.closeInventory();
                            player.setGlowing(true);
                            player.sendMessage(ChatColor.GOLD + "Time to Shine");
                        } else {
                            player.closeInventory();
                            player.setGlowing(false);
                            player.sendMessage(ChatColor.DARK_BLUE + "You are no longer shining");
                        }
                    } else {
                        player.sendMessage(ChatColor.DARK_GREEN + "Geen permissies om te shinen");
                        player.closeInventory();


                    }
                    break;
                case SKULL_ITEM:
                    player.sendMessage(ChatColor.DARK_GREEN + "Hoi jij bent:" + " " + ChatColor.GREEN + player.getName());
                    break;

                case GOLDEN_APPLE:
                    getWorld("world").setDifficulty(Difficulty.PEACEFUL);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Difficulty aangepast naar vredig!");
                    break;

                case DOUBLE_PLANT:
                    getWorld("world").setTime(6);
                    player.sendMessage(ChatColor.AQUA + "Het is nu dag!");
                    player.closeInventory();
                    break;

                case GHAST_TEAR:
                    if(player.isOp()){
                    if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                        player.removePotionEffect(PotionEffectType.INVISIBILITY);
                        player.sendMessage(ChatColor.AQUA + "Je bent uit vanish gegaan");

                    } else {
                        player.sendMessage(ChatColor.DARK_PURPLE + "Je bent in vanish gegaan!");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, true, false));
                        player.closeInventory();
                    }

                    }else{
                        player.sendMessage(Utils.chat("&6Geen permissie om in vanish te gaan"));
                    }
                    break;


            }
            e.setCancelled(true);





        }
        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Tab Kleur")) {

            switch (e.getCurrentItem().getType()) {
                case PINK_SHULKER_BOX:
                    player.closeInventory();
                    player.setPlayerListName(ChatColor.LIGHT_PURPLE + "" + player.getName());
                    player.sendMessage(Utils.chat( "&6Je Tab Kleur is aangepast naar &dRoze &6!"));
                    break;
                case BLUE_SHULKER_BOX:
                    player.closeInventory();
                    player.setPlayerListName(ChatColor.BLUE + "" + player.getName());
                    player.sendMessage(Utils.chat( "&6Je Tab Kleur is aangepast naar &9Blauw &6!"));
                    break;
                case LIGHT_BLUE_SHULKER_BOX:
                    player.closeInventory();
                    player.setPlayerListName(ChatColor.AQUA + "" + player.getName());
                    player.sendMessage(Utils.chat( "&6Je Tab Kleur is aangepast naar &bAqua &6!"));
                    break;
                case RED_SHULKER_BOX:
                    player.closeInventory();
                    player.setPlayerListName(ChatColor.RED + "" + player.getName());
                    player.sendMessage(Utils.chat( "&6Je Tab Kleur is aangepast naar &cRood &6!"));
                    break;
                case YELLOW_SHULKER_BOX:
                    player.closeInventory();
                    player.setPlayerListName(ChatColor.YELLOW + "" + player.getName());
                    player.sendMessage(Utils.chat( "&6Je Tab kleur is aangepast naar &eGeel &6!"));
                    break;
                case LIME_SHULKER_BOX:
                    player.closeInventory();
                    player.setPlayerListName(ChatColor.GREEN + "" + player.getName());
                    player.sendMessage(Utils.chat( "&6Je Tab kleur is aangepast naar &aGroen &6!"));
                    break;
                case WHITE_SHULKER_BOX:
                    player.closeInventory();
                    player.setPlayerListName(ChatColor.WHITE + "" + player.getName());
                    player.sendMessage(Utils.chat( "&6Je Tab kleur is gereset!"));
                    break;

            }
            e.setCancelled(true);
        }
        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.DARK_BLUE + "Kits")){
            switch (e.getCurrentItem().getType()) {
                case DIAMOND_CHESTPLATE:
                    player.closeInventory();
                    player.setCooldown(Material.IRON_SWORD, 0);
                    player.setSprinting(true);
                    player.getInventory().setItemInMainHand(new ItemStack(Material.IRON_SWORD, 1));
                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DURABILITY, 1);
                    player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
                    player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
                    player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
                    player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                    player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 16));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 0, true, false));
                    break;
                case IRON_SWORD:
                    player.closeInventory();
                    player.setCooldown(Material.IRON_SWORD, 0);
                    player.setSprinting(true);
                    player.getInventory().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD, 1));
                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DURABILITY, 1);
                    player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
                    player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
                    player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
                    player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
                    player.getInventory().addItem( new ItemStack(Material.COOKED_BEEF, 16));

                case GOLD_CHESTPLATE:
                    player.closeInventory();
                    player.setCooldown(Material.IRON_SWORD,0);
                    player.setSprinting(true);
                    player.getInventory().setItemInMainHand(new ItemStack(Material.IRON_SWORD,1));
                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DURABILITY,3);
                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DAMAGE_ALL,3);
                    player.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
                    player.getInventory().getHelmet().getItemMeta().setUnbreakable(true);
                    player.getInventory().getHelmet().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
                    player.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
                    player.getInventory().getChestplate().getItemMeta().setUnbreakable(true);
                    player.getInventory().getChestplate().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
                    player.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
                    player.getInventory().getLeggings().getItemMeta().setUnbreakable(true);
                    player.getInventory().getLeggings().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
                    player.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
                    player.getInventory().getBoots().getItemMeta().setUnbreakable(true);
                    player.getInventory().getBoots().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1);
                    player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF,16));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE,0, true, false));

                case GOLD_HELMET:
                    player.closeInventory();
                    player.setCooldown(Material.DIAMOND_SWORD,0);
                    player.getInventory().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD,1));
                    player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DURABILITY,1);
                    player.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
                    player.getInventory().getHelmet().getItemMeta().setDisplayName(Utils.chat("&6The &eKing"));
                    String message = Utils.chat(player.getName() + " " + "&eheeft de King kit geselecteerd!");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                    player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                    player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                    player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF,16));

            }
            e.setCancelled(true);
        }
        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Selector")){
            switch(e.getCurrentItem().getType()){
                case SLIME_BALL:
                    player.sendMessage(Utils.chat("&3Doe /tikkertje om het spel te beginnen!"));
            }
            e.setCancelled(true);
        }
        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Craft Menu")) {
            switch (e.getCurrentItem().getType()) {
                case IRON_BOOTS:
                    if(player.getInventory().contains(Material.IRON_INGOT,6)){
                        player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT,6));
                        player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS,1));
                        String message = Utils.chat("&7Je hebt zojuist ijzeren boots gecraft!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }else{
                        String message = Utils.chat("&7Je hebt niet genoeg ijzer!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }
                    break;
                case IRON_LEGGINGS:
                    if(player.getInventory().contains(Material.IRON_INGOT,9)){
                        player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT,9));
                        player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS,1));
                        String message = Utils.chat("&7Je hebt zojuist een ijzeren broek gecraft!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }else{
                        String message = Utils.chat("&7Je hebt niet genoeg ijzer!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }
                    break;
                case IRON_CHESTPLATE:
                    if(player.getInventory().contains(Material.IRON_INGOT,12)){
                        player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT,12));
                        player.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE,1));
                        String message = Utils.chat("&7Je hebt zojuist een ijzeren harnas gecraft!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }else{
                        String message = Utils.chat("&7Je hebt niet genoeg ijzer!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }
                    break;

                case IRON_HELMET:
                    if(player.getInventory().contains(Material.IRON_INGOT,7)){
                        player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT,7));
                        player.getInventory().addItem(new ItemStack(Material.IRON_HELMET,1));
                        String message = Utils.chat("&7Je hebt zojuist een ijzeren helm gecraft!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }else{
                        String message = Utils.chat("&7Je hebt niet genoeg ijzer!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }
                    break;

                case IRON_BLOCK:
                    if(player.getInventory().contains(Material.IRON_INGOT,32)){
                        player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT,32));
                        player.getInventory().addItem(new ItemStack(Material.IRON_HELMET,1));
                        player.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE,1));
                        player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS,1));
                        player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS,1));
                        player.getInventory().addItem(new ItemStack(Material.IRON_SWORD,1));
                        player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE,1));
                        String message = Utils.chat("&7Je hebt zojuist een ijzeren set gecraft!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }else{
                        String message = Utils.chat("&7Je hebt niet genoeg ijzer!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }
                    break;

            }
            e.setCancelled(true);
        }


    }
}

