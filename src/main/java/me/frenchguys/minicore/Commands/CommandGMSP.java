package me.frenchguys.minicore.Commands;

import me.frenchguys.minicore.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGMSP implements CommandExecutor {
  private Main main;
  public CommandGMSP(Main main) {
    this.main = main;
  }
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (sender instanceof Player) {
      Player player = (Player)sender;

        if (cmd.getName().equalsIgnoreCase("gmsp")){
        if (sender.hasPermission("gmsp.minicore")) {

        player.setGameMode(GameMode.SPECTATOR);

        player.sendMessage(main.getConfig().getString("gamemode.gmsp").replace("&", "§"));
            }
         return false;
         }
      return false;
      }
    return false;
  }
}
