package me.Hullumeelne.playerTeleportProperties;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class OpenFile {
	
	private Main plugin;
	
	public OpenFile(Main plugin) {
		this.plugin = plugin;
	}
	
	private File customConfigFile;
    private FileConfiguration customConfig;

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    private void createCustomConfig() {
        //Main plugin = new Main();
    	
    	customConfigFile = new File(plugin.getDataFolder(), "custom.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            plugin.saveResource("custom.yml", false);
         }

        customConfig= new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        
        
    }
    public String printSmth(String player, String world) {
		createCustomConfig();
		String rank = getCustomConfig().getString("users." + player + "." + world + ".rank");
    	return rank;
	}
}
