package dev.imkx.wargearmanager;

import dev.imkx.wargearmanager.commands.WarGearCommand;
import dev.imkx.wargearmanager.utils.types.BuildObject;
import dev.imkx.wargearmanager.utils.types.models.BlockPart;
import dev.imkx.wargearmanager.utils.types.models.EdgeBoxPart;
import dev.imkx.wargearmanager.utils.types.models.FloorPlanePart;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class WarGearManager extends JavaPlugin {
	private static BuildObject basicWarGearArena;

	public static BuildObject getBasicWarGearArena() {
		return basicWarGearArena;
	}

	public static void spawnWarGearArena(Player player) {
		basicWarGearArena.build(player.getLocation());
	}

	public void setupBasicArena() {
		basicWarGearArena = new BuildObject();
		// red box
		basicWarGearArena.addPart(new EdgeBoxPart(
				new Vector(-22, 0, -54), new Vector(45, 32, 30), Material.WOOL));
		// blue box
		basicWarGearArena.addPart(new EdgeBoxPart(
				new Vector(-22, 0, 26), new Vector(45, 32, 30), Material.WOOL));
		// floor plane
		basicWarGearArena.addPart(new FloorPlanePart(
				new Vector(-22, -1, -54), new Vector(45, 1, 110), Material.ENDER_STONE));
		// middle blocks
		basicWarGearArena.addPart(new FloorPlanePart(
				new Vector(0, -1, 0), new Vector(1, 1, 2), Material.GLOWSTONE));
		// red block
		basicWarGearArena.addPart(new BlockPart(new Vector(0, 0, 26), Material.GLOWSTONE));
		// blue block
		basicWarGearArena.addPart(new BlockPart(new Vector(0, 0, -25), Material.GLOWSTONE));
	}

	@Override
	public void onLoad() {
		setupBasicArena();
	}

	@Override
	public void onEnable() {
		// Plugin startup logic
		getCommand("wargear").setExecutor(new WarGearCommand());
		Bukkit.getPluginManager().registerEvents(new PingListener(), this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
