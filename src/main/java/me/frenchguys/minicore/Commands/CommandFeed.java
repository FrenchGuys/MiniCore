package me.frenchguys.minicore.Commands;

import java.security.PrivateKey;
import me.frenchguys.minicore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFeed implements CommandExecutor {
  private Main main;
  public CommandFeed(Main main) {
    this.main = main;
  }
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {

      Player player = (Player)sender;

      if (cmd.getName().equalsIgnoreCase("feed")){

        player.setFoodLevel(20);

        player.sendMessage(main.getConfig().getString("messages.feed").replace("&", "§"));
      }
      return false;
    }
    return false;
  }
}
