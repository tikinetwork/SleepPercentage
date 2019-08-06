package dev.foolen.sleeppercentage.events.listeners;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult;

import dev.foolen.sleeppercentage.SleepPercentage;

public class OnBedEnterEvent implements Listener {

	private SleepPercentage plugin;
	
	public OnBedEnterEvent(SleepPercentage plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onBedEnterEvent(PlayerBedEnterEvent e) {
		// Check if player is in bed
		if (e.getBedEnterResult() == BedEnterResult.OK) {
			plugin.getSleepingPlayers().add(e.getPlayer());
			plugin.getServer().broadcastMessage(SleepPercentage.PREFIX + e.getPlayer().getName() + " went to bed.");
			
			int sleepingPlayers = plugin.getSleepingPlayers().size();
			int onlinePlayers = plugin.getServer().getOnlinePlayers().size();
			int playersNeeded = ((int) Math.ceil(((double) onlinePlayers / 2)));
			
			// Check if more than 49% of online players are sleeping
			if (sleepingPlayers >= playersNeeded) {
				plugin.getServer().broadcastMessage(SleepPercentage.PREFIX + "Enough players are sleeping, turning it day now!");
				
				// Set daytime
				World world = plugin.getSleepingPlayers().get(0).getWorld();
				world.setTime(1000);
				world.setWeatherDuration(0);
				
				// Heal & feed all players
				plugin.getSleepingPlayers().forEach(player -> {
					player.setHealth(20);
					player.setFoodLevel(20);
				});
			} else {
				playersNeeded = (playersNeeded - sleepingPlayers);
				if (playersNeeded == 1) {
					plugin.getServer().broadcastMessage(SleepPercentage.PREFIX + playersNeeded + " more player needed to skip the night.");
				} else {
					plugin.getServer().broadcastMessage(SleepPercentage.PREFIX + playersNeeded + " more players needed to skip the night.");
				}
			}
		}
	}
}
