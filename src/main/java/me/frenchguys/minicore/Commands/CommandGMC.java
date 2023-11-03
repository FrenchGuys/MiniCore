package me.frenchguys.minicore.Commands;

import java.security.PrivateKey;
import me.frenchguys.minicore.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGMC implements CommandExecutor {
  private Main main;
  public CommandGMC(Main main) {
    this.main = main;
  }
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {

      Player player = (Player)sender;

      if (cmd.getName().equalsIgnoreCase("gmc")){
        if (sender.hasPermission("gmc.minicore")) {

        player.setGameMode(GameMode.CREATIVE);

        player.sendMessage(main.getConfig().getString("gamemode.gmc").replace("&", "§"));
      }
      return false;
    }
    return false;
  }
    return false;
  }
}
