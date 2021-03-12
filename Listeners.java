package me.Hullumeelne.playerTeleportProperties;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class Listeners implements Listener {
	
	// Constructor
	public Listeners(Main main) {
		
	}
	
	@EventHandler
	public void PlayerChangedWorldEvent(PlayerChangedWorldEvent e) {
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "say Someone changed worlds");
		
		Player p = e.getPlayer();
		String world = p.getWorld().getName();
		
		openFile data = new openFile();
		String rank = data.printSmth(p.getDisplayName(), world);
		System.out.println(rank);

		// Code not necessarily needed right now, just print out the world name that the player joined
		if (world.equals("world_nether") ) {
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
