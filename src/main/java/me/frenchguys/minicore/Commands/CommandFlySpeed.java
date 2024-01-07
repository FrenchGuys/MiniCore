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
                if (args.length != 1) {
                    return false; // La commande doit avoir exactement un argument
                }

                try {
                    int speed = Integer.parseInt(args[0]);

                    if (player.hasPermission("fly.speed")) {
                        if (speed >= 1 && speed <= 5) {
                            player.setFlySpeed((float) speed / 10.0F);
                            player.sendMessage(main.getConfig().getString("fly.flyspeed")
                                    .replace("&", "§").replace("%speed%", String.valueOf(speed)));
                        } else {
                            player.sendMessage(main.getConfig().getString("fly.speed")
                                    .replace("&", "§"));
                        }
                        return true;
                    } else {
                        player.sendMessage(main.getConfig().getString("messages.noperm").replace("&", "§"));
                    }
                } catch (NumberFormatException var8) {
                    player.sendMessage(main.getConfig().getString("fly.onlynumber")
                            .replace("&", "§"));
                }
            }
        } else {
            sender.sendMessage("This command can only be executed by a player.");
        }

        return false;
    }
}
