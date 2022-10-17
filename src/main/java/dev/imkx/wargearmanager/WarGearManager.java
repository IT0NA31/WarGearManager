package dev.imkx.wargearmanager;

import dev.imkx.wargearmanager.commands.WarGearCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class WarGearManager extends JavaPlugin {

	@Override
	public void onEnable() {
		// Plugin startup logic
		getCommand("wargear").setExecutor(new WarGearCommand());

	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
