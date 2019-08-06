package dev.foolen.sleeppercentage;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import dev.foolen.sleeppercentage.events.EventHandler;

public class SleepPercentage extends JavaPlugin {
	
	public static final String PREFIX = ChatColor.GOLD + "[SleepPercentage] ";
	
	private static ArrayList<Player> sleepingPlayers;

	@Override
	public void onEnable() {
		sleepingPlayers = new ArrayList<Player>();
		
		// Load events
		new EventHandler(this);
	}
	
	public ArrayList<Player> getSleepingPlayers() {
		return sleepingPlayers;
	}
}
