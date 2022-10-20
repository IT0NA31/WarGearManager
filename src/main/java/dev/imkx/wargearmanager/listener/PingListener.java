package dev.imkx.wargearmanager.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.HashMap;

public class PingListener implements Listener {
	private static String[] motds = {
			"§6§lIT0NAs §7§lTestserver §8§l  §6§lRunning on §7§l1.12.2",
			"§6§lIT0NAs §7§lTestserver §8§l  §6§lDeveloping the future on §7§l1.12.2",
			"§6§lIT0NAs §7§lTestserver §8§l  §6§lMaking dreams come true on §7§l1.12.2"
	};

	@EventHandler
	public void onServerPing(ServerListPingEvent event) {
		event.setMotd(motds[(int) (Math.random() * motds.length)]);
	}
}
