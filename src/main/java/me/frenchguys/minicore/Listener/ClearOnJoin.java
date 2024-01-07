package me.frenchguys.minicore.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ClearOnJoin implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event){

    Player player = event.getPlayer();

    player.setFlying(false);
    int speed = 1;
    player.setFlySpeed((float) speed / 10.0F);

  }
}
