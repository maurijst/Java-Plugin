package me.maurhice.commandos;

import me.maurhice.commandos.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {


    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        Player k = p.getKiller();
        e.setDeathMessage(Utils.chat("&4" + p.getName() + " " +  "&cis dood gegaan door:" + " " + k.getName()));
        p.sendMessage(Utils.chat("&cJe bent zojuist dood gegaan door:" + " " + k.getName()));
        p.setExp(0);

        }




    }


