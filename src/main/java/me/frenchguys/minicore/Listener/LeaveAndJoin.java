package me.frenchguys.minicore.Listener;

import me.frenchguys.minicore.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveAndJoin implements Listener {

    private Main main;

    public LeaveAndJoin(Main main) {
        this.main = main;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        event.setJoinMessage(main.getConfig().getString("messages.join").replace("&", "§").replace("%player%", player.getName()));

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();

        event.setQuitMessage(main.getConfig().getString("messages.leave").replace("&", "§").replace("%player%", player.getName()));

    }


}
