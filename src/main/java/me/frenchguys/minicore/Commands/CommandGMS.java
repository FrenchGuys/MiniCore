package me.frenchguys.minicore.Commands;

import java.security.PrivateKey;
import me.frenchguys.minicore.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGMS implements CommandExecutor {
  private Main main;
  public CommandGMS(Main main) {
    this.main = main;
  }
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {

      Player player = (Player)sender;

      if (cmd.getName().equalsIgnoreCase("gms")){
        if (sender.hasPermission("gms.minicore")) {

        player.setGameMode(GameMode.SURVIVAL);

        player.sendMessage(main.getConfig().getString("gamemode.gms").replace("&", "§"));
      }
      return false;
    }
    return false;
  }
    return false;
  }
}
