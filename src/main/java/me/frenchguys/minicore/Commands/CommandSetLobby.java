package me.frenchguys.minicore.Commands;

import me.frenchguys.minicore.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetLobby implements CommandExecutor {

  private Main main;

  public CommandSetLobby(Main main) {
    this.main = main;
  }


  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    if (cmd.getName().equalsIgnoreCase("setlobby")) {
      if (sender instanceof Player) {

        Player player = (Player) sender;
        if (sender.hasPermission("setlobby.minicore")) {
          Location loc = player.getLocation();
          int x = loc.getBlockX();
          int y = loc.getBlockY();
          int z = loc.getBlockZ();
          float yaw = loc.getYaw();
          float pitch = loc.getPitch();
          main.getConfig().set("lobby.Location.X", x);
          main.getConfig().set("lobby.Location.Y", y);
          main.getConfig().set("lobby.Location.Z", z);
          main.getConfig().set("lobby.Location.Yaw", yaw);
          main.getConfig().set("lobby.Location.Pitch", pitch);
          main.saveConfig();
          player.sendMessage(main.getConfig().getString("messages.lobbyset").replace("&", "§"));
          player.sendMessage(ChatColor.GOLD + "x: " + x + " y: " + y + " z: " + z);
        }
      }

      return false;
    }
    return false;
  }
}

