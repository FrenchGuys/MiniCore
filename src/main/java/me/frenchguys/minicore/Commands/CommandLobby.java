package me.frenchguys.minicore.Commands;

import me.frenchguys.minicore.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class CommandLobby implements CommandExecutor {

    private Main main;

    public CommandLobby(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only player can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equals("lobby")) {
            FileConfiguration spawnConfig = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "spawnconfig.yml"));

            double x = spawnConfig.getDouble("lobby.Location.X");
            double y = spawnConfig.getDouble("lobby.Location.Y");
            double z = spawnConfig.getDouble("lobby.Location.Z");
            float yaw = (float) spawnConfig.getDouble("lobby.Location.Yaw");
            float pitch = (float) spawnConfig.getDouble("lobby.Location.Pitch");
             Location spawnLocation = new Location(Bukkit.getWorld("world"), x, y, z, yaw, pitch);

            player.teleport(spawnLocation);
            player.sendMessage(main.getConfig().getString("messages.lobbyteleported").replace("&", "§"));
            player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
        }

        return true;
    }
}
