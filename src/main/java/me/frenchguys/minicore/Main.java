package me.frenchguys.minicore;

import me.frenchguys.minicore.Commands.CommandDiscord;
import me.frenchguys.minicore.Commands.CommandFeed;
import me.frenchguys.minicore.Commands.CommandFly;
import me.frenchguys.minicore.Commands.CommandFlySpeed;
import me.frenchguys.minicore.Commands.CommandGMC;
import me.frenchguys.minicore.Commands.CommandGMS;
import me.frenchguys.minicore.Commands.CommandGMSP;
import me.frenchguys.minicore.Commands.CommandHeal;
// import me.frenchguys.minicore.Listeners.BonbonListener;
import me.frenchguys.minicore.Commands.CommandPing;
import me.frenchguys.minicore.Commands.CommandSetLobby;
import me.frenchguys.minicore.Commands.CommandLobby;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
  @Override
  public void onEnable() {

    saveDefaultConfig();
    System.out.println("------------------------------------------");
    System.out.println("[MiniCore] Enable");
    System.out.println("[MiniCore] Join the discord !");
    System.out.println("[MiniCore] https://discord.gg/ZjwruYffD4");
    System.out.println("------------------------------------------");

    //CMD

    getCommand("heal").setExecutor(new CommandHeal(this));
    getCommand("feed").setExecutor(new CommandFeed(this));
    getCommand("gmc").setExecutor(new CommandGMC(this));
    getCommand("gms").setExecutor(new CommandGMS(this));
    getCommand("gmsp").setExecutor(new CommandGMSP(this));
    getCommand("fly").setExecutor(new CommandFly(this));
    getCommand("id").setExecutor(new CommandPing(this));
    getCommand("discord").setExecutor(new CommandDiscord(this));
    getCommand("flyspeed").setExecutor(new CommandFlySpeed(this));
    getCommand("setlobby").setExecutor(new CommandSetLobby(this));
    getCommand("lobby").setExecutor(new CommandLobby(this));

    //Listeners

    // getServer().getPluginManager().registerEvent(new BonbonListener(this), this);


    //Task

  }
  @Override
  public void onDisable() {
    System.out.println("------------------------------------------");
    System.out.println("[MiniCore] Disable");
    System.out.println("[MiniCore] Join the discord !");
    System.out.println("[MiniCore] https://discord.gg/ZjwruYffD4");
    System.out.println("------------------------------------------");

  }

}
