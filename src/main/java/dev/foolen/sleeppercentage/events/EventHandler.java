package dev.foolen.sleeppercentage.events;

import org.bukkit.plugin.PluginManager;

import dev.foolen.sleeppercentage.SleepPercentage;
import dev.foolen.sleeppercentage.events.listeners.OnBedEnterEvent;
import dev.foolen.sleeppercentage.events.listeners.OnBedLeaveEvent;

public class EventHandler {
	
	public EventHandler(SleepPercentage plugin) {
		PluginManager pm = plugin.getServer().getPluginManager();
		
		pm.registerEvents(new OnBedEnterEvent(plugin), plugin);
		pm.registerEvents(new OnBedLeaveEvent(plugin), plugin);
	}
}
