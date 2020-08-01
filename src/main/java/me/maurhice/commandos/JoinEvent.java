package me.maurhice.commandos;

import me.maurhice.commandos.utils.Utils;
import org.bukkit.event.Listener;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    public void JoinEvent(PlayerJoinEvent e){
        String speler = e.getPlayer().getName();
        String message = Utils.chat("&5Welkom op de server");
        Player p = Bukkit.getPlayer(speler);
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR,TextComponent.fromLegacyText(message));
    }

}
