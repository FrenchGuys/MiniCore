package me.frenchguys.minicore.Commands;

import me.frenchguys.minicore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {

  private Main main;
  public CommandFly(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {

      Player player = (Player) sender;

      if (cmd.getName().equalsIgnoreCase("fly"));

      if (!player.hasPermission("fly.minicore")) {
        player.sendMessage(main.getConfig().getString("fly.noperm").replace("&", "§"));
        return true;
      } else {

        if (player.getAllowFlight() == true) {
          player.setAllowFlight(false);
          player.sendMessage(main.getConfig().getString("fly.disable").replace("&", "§"));
          return true;
        }

        if (player.getAllowFlight() == false) {
          player.setAllowFlight(true);
          player.sendMessage(main.getConfig().getString("fly.enable").replace("&", "§"));
          return true;
        }


        return false;
      }
    }
    return false;
  }
}
