package me.maurhice.commandos;

import me.maurhice.commandos.utils.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import java.awt.*;

public class CraftEvent implements Listener {
    @EventHandler
    public void CraftEvent(PrepareItemCraftEvent e) {
        Material itemType = e.getRecipe().getResult().getType();
        if(itemType==Material.IRON_CHESTPLATE||itemType==Material.IRON_LEGGINGS||(itemType==Material.IRON_BOOTS || (itemType==Material.IRON_HELMET || (itemType==Material.IRON_PICKAXE || itemType==Material.IRON_SWORD)))) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
                }
            }
        }

