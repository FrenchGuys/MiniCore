package me.frenchguys.minicore.Commands;

import me.frenchguys.minicore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFlySpeed implements CommandExecutor {

  private Main main;
  public CommandFlySpeed(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {

      Player player = (Player) sender;

      if (cmd.getName().equalsIgnoreCase("flyspeed")) {
        if (args.length == 0) {
          return false;
        }
        if (args.length == 1) {
          int speed;
          try {
            speed = Integer.parseInt(args[0]);
          } catch (NumberFormatException var8) {
            player.sendMessage(main.getConfig().getString("fly.onlynumber").replace("&", "§"));
            return true;
          }

          if (player.hasPermission("fly.speed")) {
            if (speed >= 1 && speed <= 5) {
              player.setFlySpeed((float) speed / 10.0F);
              player.sendMessage(main.getConfig().getString("fly.flyspeed").replace("&", "§").replace("%speed%", String.valueOf(speed)));
            } else {
              player.sendMessage(main.getConfig().getString("fly.speed").replace("&", "§"));
            }

            return true;
          }
        }
      }
    }
    return false;
  }
}
