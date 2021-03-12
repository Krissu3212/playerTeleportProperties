package me.Hullumeelne.playerTeleportProperties;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class Listeners implements Listener {
	
	private Main plugin;
	
	// Constructor
	public Listeners(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void PlayerChangedWorldEvent(PlayerChangedWorldEvent e) {
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "say Someone changed worlds");
		
		Player p = e.getPlayer();
		String world = p.getWorld().getName();
		
		OpenFile data = new OpenFile(plugin);
		String rank = data.printSmth(p.getDisplayName(), world);
		System.out.println(rank);
		//String rank = file.getData(p.getDisplayName(), world);
		
		//Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "say pex " + p.getDisplayName() + " group set " + rank + " " + world);
		
		if (world.equals("world_nether") ) {
			///pex {user} group set {group} {world}
			Bukkit.broadcastMessage("Teleported to the nether");
		}
		if (world.equals("world_the_end")) {
			Bukkit.broadcastMessage("Teleported to the end");
		}
		if (world.equals("world")) {
			Bukkit.broadcastMessage("Teleported to overworld");
		}
	}
	
}
