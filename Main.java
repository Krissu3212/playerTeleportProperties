package me.Hullumeelne.playerTeleportProperties;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
		
	@Override
	public void onEnable() {
		System.out.println("playerTeleportProperties has been turned on");
		
		this.getCommand("test").setExecutor((CommandExecutor)new TestCmd());
		
		PluginManager pm = getServer().getPluginManager();
		Listeners listener = new Listeners(this);
		pm.registerEvents(listener, this);
	}
	@Override
	public void onDisable() {
		System.out.println("playerTeleportProperties has been turned off");
	}
}
