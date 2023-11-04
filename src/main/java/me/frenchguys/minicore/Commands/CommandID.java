package me.frenchguys.minicore.Commands;

import me.frenchguys.minicore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandID implements CommandExecutor {

  private Main main;
  public CommandID(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;

      if (cmd.getName().equalsIgnoreCase("id"));
      {
        player.sendMessage(main.getConfig().getString("messages.id").replace("&", "§").replace("%id%", String.valueOf(player.getItemInHand().getTypeId())));

      }
      return false;
    }
    return false;
  }
}
