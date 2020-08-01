package me.maurhice.commandos;

import me.maurhice.commandos.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class RightClick implements Listener {
    @EventHandler
    public void Selector(PlayerInteractEvent i) {
        if (i.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (i.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Selector")) {

                Player p = i.getPlayer();
                Inventory Selector = Bukkit.createInventory(p, 27, ChatColor.GOLD + "Selector");
                ItemStack Tik = new ItemStack(Material.SLIME_BALL);
                ItemStack Vul = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 13);
                ItemStack Vul1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
                ItemStack Vul2 = new ItemStack(Material.STAINED_GLASS_PANE, 1);
                ItemStack Vul3 = new ItemStack(Material.AIR);

                ItemMeta Tik_meta = Tik.getItemMeta();
                Tik_meta.setDisplayName(Utils.chat("&aTikkertje"));
                ArrayList<String> Tik_lore = new ArrayList<String>();
                Tik_lore.add(Utils.chat("&fStart een tik spel"));
                Tik_lore.add(Utils.chat("&b______"));
                Tik_lore.add(Utils.chat("&fDoe /quit [Speler] om het spel te stoppen!"));
                Tik_meta.setLore(Tik_lore);
                Tik.setItemMeta(Tik_meta);

                ItemMeta Vul_meta = Vul.getItemMeta();
                Vul_meta.setDisplayName(Utils.chat("&khihi"));
                Vul.setItemMeta(Vul_meta);

                ItemMeta Vul1_meta = Vul1.getItemMeta();
                Vul1_meta.setDisplayName(Utils.chat("&khihi"));
                Vul1.setItemMeta(Vul1_meta);

                ItemMeta Vul2_meta = Vul2.getItemMeta();
                Vul2_meta.setDisplayName(Utils.chat("&khihi"));
                Vul2.setItemMeta(Vul2_meta);

                ItemStack[] Selector_items = {Vul, Vul, Vul, Vul1, Vul2, Vul1, Vul, Vul, Vul, Vul3, Vul3, Vul3, Vul3, Tik, Vul3, Vul3, Vul3, Vul3, Vul, Vul, Vul, Vul1, Vul2, Vul1, Vul, Vul, Vul};
                Selector.setContents(Selector_items);
                p.openInventory(Selector);
            }
            if (i.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                if (i.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Craft Menu")) {
                    Player p = i.getPlayer();
                    Inventory rep = Bukkit.createInventory(p, 27, ChatColor.DARK_GRAY + "Craft Menu");
                    ItemStack rep1 = new ItemStack(Material.IRON_CHESTPLATE);
                    ItemStack rep2 = new ItemStack(Material.IRON_LEGGINGS);
                    ItemStack rep3 = new ItemStack(Material.IRON_HELMET);
                    ItemStack rep4 = new ItemStack(Material.IRON_BOOTS);
                    ItemStack vul = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                    ItemStack vul2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
                    ItemStack vul3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
                    ItemStack vul4 = new ItemStack(Material.AIR);
                    ItemStack rep5 = new ItemStack(Material.IRON_BLOCK);

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



                    ItemStack[] Crafts = {vul, vul, vul, vul3, vul2, vul3, vul, vul, vul, vul4, vul4, rep3, rep1, rep5, rep2, rep4, vul4, vul4, vul, vul, vul, vul3, vul2, vul3, vul, vul, vul};
                    rep.setContents(Crafts);
                    p.openInventory(rep);


                }

            }

        }
    }
}

