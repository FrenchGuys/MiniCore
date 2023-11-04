package me.frenchguys.minicore;


import me.frenchguys.minicore.Listener.ClearOnJoin;
import org.bukkit.Server.Spigot;
import org.bukkit.plugin.java.JavaPlugin;
//Commands
import me.frenchguys.minicore.Commands.CommandDiscord;
import me.frenchguys.minicore.Commands.CommandHeal;
import me.frenchguys.minicore.Commands.CommandFeed;
import me.frenchguys.minicore.Commands.CommandHealFeed;
import me.frenchguys.minicore.Commands.CommandGMC;
import me.frenchguys.minicore.Commands.CommandGMS;
import me.frenchguys.minicore.Commands.CommandGMSP;
import me.frenchguys.minicore.Commands.CommandID;
import me.frenchguys.minicore.Commands.CommandFly;
import me.frenchguys.minicore.Commands.CommandFlySpeed;
import me.frenchguys.minicore.Commands.CommandSetLobby;
import me.frenchguys.minicore.Commands.CommandLobby;

public class Main extends JavaPlugin {

  public static Spigot getPlugin() {

    return null;
  }

  @Override
  public void onEnable() {

    saveDefaultConfig();
    System.out.println("------------------------------------------");
    System.out.println("[MiniCore] Enable");
    System.out.println("[MiniCore] Join the discord !");
    System.out.println("[MiniCore] https://discord.gg/ZjwruYffD4");
    System.out.println("------------------------------------------");

    //CMD

    getCommand("discord").setExecutor(new CommandDiscord(this));  // Default
    getCommand("heal").setExecutor(new CommandHeal(this)); // heal.minicore
    getCommand("feed").setExecutor(new CommandFeed(this)); // feed.minicore
    getCommand("feedheal").setExecutor(new CommandHealFeed(this)); // feedheal.minicore
    getCommand("gmc").setExecutor(new CommandGMC(this)); // gmc.minicore
    getCommand("gms").setExecutor(new CommandGMS(this)); // gms.minicore
    getCommand("gmsp").setExecutor(new CommandGMSP(this)); // gmsp.minicore
    getCommand("id").setExecutor(new CommandID(this));  // id.minicore
    getCommand("fly").setExecutor(new CommandFly(this));  // fly.minicore
    getCommand("flyspeed").setExecutor(new CommandFlySpeed(this));  // flyspeed.minicore
    getCommand("setlobby").setExecutor(new CommandSetLobby(this));  // setlobby.minicore
    getCommand("lobby").setExecutor(new CommandLobby(this)); // Default

    getServer().getPluginManager().registerEvents(new ClearOnJoin(), this);
  }

  @Override
  public void onDisable() {
    System.out.println("------------------------------------------");
    System.out.println("[MiniCore] Disable");
    System.out.println("[MiniCore] Join the discord !");
    System.out.println("[MiniCore] https://discord.gg/ZjwruYffD4");
    System.out.println("------------------------------------------");
    saveConfig();
   }
}

