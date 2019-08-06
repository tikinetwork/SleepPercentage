package dev.foolen.sleeppercentage.events.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import dev.foolen.sleeppercentage.SleepPercentage;

public class OnBedLeaveEvent implements Listener {

	private SleepPercentage plugin;
	
	public OnBedLeaveEvent(SleepPercentage plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onBedLeaveEvent(PlayerBedLeaveEvent e) {
		plugin.getSleepingPlayers().remove(e.getPlayer());
		plugin.getServer().broadcastMessage(SleepPercentage.PREFIX + e.getPlayer().getName() + " got out of bed.");
	}
}
