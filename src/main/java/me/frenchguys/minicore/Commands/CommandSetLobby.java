package me.frenchguys.minicore.Commands;

import me.frenchguys.minicore.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class CommandSetLobby implements CommandExecutor {

    private Main main;

    public CommandSetLobby(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (cmd.getName().equals("setlobby")) {
            if (!sender.hasPermission("setlobby.minicore")) {
                player.sendMessage(main.getConfig().getString("messages.noperm").replace("&", "§"));
            } else {
                Location loc = player.getLocation();
                int x = loc.getBlockX();
                int y = loc.getBlockY();
                int z = loc.getBlockZ();
                float yaw = loc.getYaw();
                float pitch = loc.getPitch();

                // Charger la configuration "spawnconfig.yml"
                File spawnConfigFile = new File(main.getDataFolder(), "spawnconfig.yml");
                FileConfiguration spawnConfig = YamlConfiguration.loadConfiguration(spawnConfigFile);

                // Mettre à jour les valeurs spécifiques dans la configuration spawnconfig.yml
                spawnConfig.set("lobby.Location.X", x);
                spawnConfig.set("lobby.Location.Y", y);
                spawnConfig.set("lobby.Location.Z", z);
                spawnConfig.set("lobby.Location.Yaw", yaw);
                spawnConfig.set("lobby.Location.Pitch", pitch);

                // Sauvegarder uniquement les modifications dans le fichier spawnconfig.yml
                try {
                    spawnConfig.save(spawnConfigFile);
                    // Rafraîchir la configuration du plugin après la sauvegarde
                    main.reloadSpawnConfig();

                    player.sendMessage(main.getConfig().getString("messages.lobbyset").replace("&", "§"));
                    player.sendMessage(ChatColor.GOLD + "x: " + x + " y: " + y + " z: " + z);
                } catch (IOException e) {
                    e.printStackTrace(); // Ajoutez une gestion appropriée des erreurs ici
                    player.sendMessage(ChatColor.RED + "Erreur lors de la sauvegarde de la configuration du spawn.");
                }
            }
        }

        return false;
    }
}

