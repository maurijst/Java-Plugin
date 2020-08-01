package me.maurhice.commandos;

import me.maurhice.commandos.utils.Utils;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class DamageEvent implements Listener {
    @EventHandler
    public void DamageEvent(EntityDamageByEntityEvent e){
        Entity damager = e.getDamager();
        Entity damagetaker = e.getEntity();
        if(damagetaker instanceof Player) {
            Player damagerPlayer = (Player) damager;

            if (damagerPlayer.isGlowing() == true) {
                ((Player) damagetaker).setPlayerListName(Utils.chat("&4[Tikker]&r" + " " + damagetaker.getName()));
                damagetaker.setGlowing(true);
                damagetaker.sendMessage(Utils.chat("&4[Tikkertje]" + " " + "&fje bent nu de Tikker!"));
                ((Player) damagetaker).getInventory().setHelmet(new ItemStack(Material.SLIME_BLOCK, 1));
                ((Player) damagetaker).getInventory().setItemInMainHand(new ItemStack(Material.SLIME_BALL,1));
                ((Player) damagetaker).playSound(damagetaker.getLocation(), Sound.BLOCK_SLIME_PLACE,100,100);
                ((Player) damagetaker).playEffect(damagetaker.getLocation(),Effect.SLIME,5);
            }
            if (damagerPlayer.isGlowing() == true) {
                    damagerPlayer.setGlowing(false);
                    damagerPlayer.setPlayerListName(Utils.chat("&6[Renner]&f" + " " + damagerPlayer.getName()));
                    damagerPlayer.sendMessage(Utils.chat("&4[Tikkertje]" + "" + "&fRen voor je leven!"));
                    damagerPlayer.getInventory().setHelmet(new ItemStack(Material.AIR, 1));
                    damagerPlayer.getInventory().setItemInMainHand(new ItemStack(Material.AIR,1));


            }


            }
        }

    }

