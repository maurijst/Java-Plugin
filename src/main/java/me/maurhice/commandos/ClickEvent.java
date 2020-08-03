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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.awt.*;
import java.util.ArrayList;

import static org.bukkit.Bukkit.*;

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
                    String message = ChatColor.LIGHT_PURPLE + "Difficulty aangepast naar vredig!";
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR,TextComponent.fromLegacyText(message));
                    break;

                case DOUBLE_PLANT:
                    getWorld("world").setTime(6);
                   String message1 = ChatColor.AQUA + "Het is nu dag!";
                   player.spigot().sendMessage(ChatMessageType.ACTION_BAR,TextComponent.fromLegacyText(message1));
                    player.closeInventory();
                    break;

                case GHAST_TEAR:
                    if(player.isOp()){
                    if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                        player.removePotionEffect(PotionEffectType.INVISIBILITY);
                        String message2 = ChatColor.AQUA + "Je bent uit vanish gegaan";
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,TextComponent.fromLegacyText(message2));

                    } else {
                        String message3 = ChatColor.DARK_PURPLE + "Je bent in vanish gegaan!";
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,TextComponent.fromLegacyText(message3));
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
                        String message = Utils.chat("&aJe hebt zojuist ijzeren boots gecraft!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }else{
                        String message = Utils.chat("&4Je hebt niet genoeg ijzer!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }
                    break;
                case IRON_LEGGINGS:
                    if(player.getInventory().contains(Material.IRON_INGOT,9)){
                        player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT,9));
                        player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS,1));
                        String message = Utils.chat("&aJe hebt zojuist een ijzeren broek gecraft!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }else{
                        String message = Utils.chat("&4Je hebt niet genoeg ijzer!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }
                    break;
                case IRON_CHESTPLATE:
                    if(player.getInventory().contains(Material.IRON_INGOT,12)){
                        player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT,12));
                        player.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE,1));
                        String message = Utils.chat("&aJe hebt zojuist een ijzeren harnas gecraft!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }else{
                        String message = Utils.chat("&4Je hebt niet genoeg ijzer!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }
                    break;

                case IRON_HELMET:
                    if(player.getInventory().contains(Material.IRON_INGOT,7)){
                        player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT,7));
                        player.getInventory().addItem(new ItemStack(Material.IRON_HELMET,1));
                        String message = Utils.chat("&aJe hebt zojuist een ijzeren helm gecraft!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }else{
                        String message = Utils.chat("&4Je hebt niet genoeg ijzer!");
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
                        String message = Utils.chat("&aJe hebt zojuist een ijzeren set gecraft!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }else{
                        String message = Utils.chat("&4Je hebt niet genoeg ijzer!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }
                    break;

                case SPECTRAL_ARROW:
                   Inventory Next = Bukkit.createInventory(player,27,ChatColor.GOLD + "Page 2" );
                   ItemStack test = new ItemStack(Material.DIAMOND_BOOTS);
                    ItemStack vul = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                    ItemStack vul2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
                    ItemStack vul3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
                    ItemStack vul4 = new ItemStack(Material.AIR);
                    ItemStack rep6 = new ItemStack(Material.SPECTRAL_ARROW);
                    ItemStack rep7 = new ItemStack(Material.ARROW);

                   ItemStack[] menu_items = {vul, vul, vul, vul3, vul2, vul3, vul, vul, vul,rep7,vul4,vul4,vul4,test,vul4,vul4,vul4,rep6,vul, vul, vul, vul3, vul2, vul3, vul, vul, vul,};
                   Next.setContents(menu_items);
                   player.openInventory(Next);


                   }


            e.setCancelled(true);


            }
        if(e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Page 2" )) {
            switch (e.getCurrentItem().getType()) {

                case DIAMOND_BOOTS:
                    if (player.getInventory().contains(Material.DIAMOND, 6)) {
                        player.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS, 1));
                        player.getInventory().removeItem(new ItemStack(Material.DIAMOND,6));
                        String message = Utils.chat("&aJe hebt diamanten boots gecraft");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    } else {
                        String message = Utils.chat("&4Je hebt niet genoeg diamanten!");
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    }
                case ARROW:
                    Inventory Previous = Bukkit.createInventory(player,27,ChatColor.DARK_GRAY + "Craft Menu");
                    ItemStack rep1 = new ItemStack(Material.IRON_CHESTPLATE);
                    ItemStack rep2 = new ItemStack(Material.IRON_LEGGINGS);
                    ItemStack rep3 = new ItemStack(Material.IRON_HELMET);
                    ItemStack rep4 = new ItemStack(Material.IRON_BOOTS);
                    ItemStack vul = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                    ItemStack vul2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
                    ItemStack vul3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
                    ItemStack vul4 = new ItemStack(Material.AIR);
                    ItemStack rep5 = new ItemStack(Material.IRON_BLOCK);
                    ItemStack rep6 = new ItemStack(Material.SPECTRAL_ARROW);
                    ItemStack rep7 = new ItemStack(Material.ARROW);

                    ItemMeta rep1_meta = rep1.getItemMeta();
                    rep1_meta.setDisplayName(Utils.chat("&7Craft a Chestplate"));
                    ArrayList<String> rep1_lore = new ArrayList<String>();
                    rep1_lore.add(Utils.chat("&5Benodigdheden:"));
                    rep1_lore.add(Utils.chat("&f12 Iron Ingots"));
                    rep1_meta.setLore(rep1_lore);
                    rep1.setItemMeta(rep1_meta);

                    ItemMeta rep2_meta = rep2.getItemMeta();
                    rep2_meta.setDisplayName(Utils.chat("&7Craft Leggings"));
                    ArrayList<String> rep2_lore = new ArrayList<String>();
                    rep2_lore.add(Utils.chat("&5Benodigdheden:"));
                    rep2_lore.add(Utils.chat("&f9 Iron Ingots"));
                    rep2_meta.setLore(rep2_lore);
                    rep2.setItemMeta(rep2_meta);

                    ItemMeta rep3_meta = rep3.getItemMeta();
                    rep3_meta.setDisplayName(Utils.chat("&7Craft a Helmet"));
                    ArrayList<String> rep3_lore = new ArrayList<String>();
                    rep3_lore.add(Utils.chat("&5Benodigdheden:"));
                    rep3_lore.add(Utils.chat("&f7 Iron Ingots"));
                    rep3_meta.setLore(rep3_lore);
                    rep3.setItemMeta(rep3_meta);

                    ItemMeta rep4_meta = rep4.getItemMeta();
                    rep4_meta.setDisplayName(Utils.chat("&7Craft Boots"));
                    ArrayList<String> rep4_lore = new ArrayList<String>();
                    rep4_lore.add(Utils.chat("&5Benodigdheden:"));
                    rep4_lore.add(Utils.chat("&f6 Iron Ingots"));
                    rep4_meta.setLore(rep4_lore);
                    rep4.setItemMeta(rep4_meta);

                    ItemMeta rep5_meta = rep5.getItemMeta();
                    rep5_meta.setDisplayName(Utils.chat("&7Craft Set"));
                    ArrayList<String> rep5_lore = new ArrayList<String>();
                    rep5_lore.add(Utils.chat("&5Benodigdheden:"));
                    rep5_lore.add(Utils.chat("&f32 Iron Ingots"));
                    rep5_meta.setLore(rep5_lore);
                    rep5.setItemMeta(rep5_meta);

                    ItemMeta rep6_meta = rep6.getItemMeta();
                    rep6_meta.setDisplayName(Utils.chat("&5Next Page"));
                    rep6.setItemMeta(rep6_meta);

                    ItemMeta rep7_meta = rep7.getItemMeta();
                    rep7_meta.setDisplayName(Utils.chat("&5Previous Page"));
                    rep7.setItemMeta(rep7_meta);


                    ItemStack[] Crafts = {vul, vul, vul, vul3, vul2, vul3, vul, vul, vul, rep7, vul4, rep3, rep1, rep5, rep2, rep4, vul4, rep6, vul, vul, vul, vul3, vul2, vul3, vul, vul, vul};
                    Previous.setContents(Crafts);
                    player.openInventory(Previous);



            }
            e.setCancelled(true);

        }


    }
}

