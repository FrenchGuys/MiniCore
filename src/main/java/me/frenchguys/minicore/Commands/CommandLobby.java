package me.frenchguys.minicore.Commands;

import java.util.HashMap;
import me.frenchguys.minicore.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLobby implements CommandExecutor {



  private Main main;
  public CommandLobby(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player) sender;

      if(cmd.getName().equalsIgnoreCase("lobby")) {
        int x = main.getConfig().getInt("lobby.Location.X");
        int y = main.getConfig().getInt("lobby.Location.Y");
        int z = main.getConfig().getInt("lobby.Location.Z");
        float yaw = (float)main.getConfig().getInt("lobby.Location.Yaw");
        float pitch = (float)main.getConfig().getInt("lobby.Location.Pitch");
        Location lobbyloc = new Location(Bukkit.getWorld("world"), (double)x + 0.5, (double)y, (double)z + 0.5, yaw, pitch);
        player.teleport(lobbyloc);
        player.sendMessage(main.getConfig().getString("messages.lobbyteleported").replace("&", "§"));
        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);


      }

      return false;
    }
    return false;
  }
}
