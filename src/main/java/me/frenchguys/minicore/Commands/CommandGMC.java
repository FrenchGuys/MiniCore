package me.frenchguys.minicore.Commands;

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
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("gmc")) {
                if (player.hasPermission("gmc.minicore")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(main.getConfig().getString("gamemode.gmc").replace("&", "§"));
                    return true;
                } else {
                    player.sendMessage(main.getConfig().getString("messages.noperm").replace("&", "§"));
                }
            } else {
                sender.sendMessage("This command can only be executed by a player.");
            }

            return false;
        }            return false;

    }
}
