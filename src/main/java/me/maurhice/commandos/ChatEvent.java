package me.maurhice.commandos;

import me.maurhice.commandos.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatEvent implements Listener {
    @EventHandler
    public void ChatEvent(AsyncPlayerChatEvent event){
        String display = event.getPlayer().getPlayerListName();
        event.setFormat(Utils.chat("&f" + "" + display + "" + ":" + " "  + event.getMessage()));
    }
}
