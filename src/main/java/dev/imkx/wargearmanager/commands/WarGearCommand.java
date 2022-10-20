package dev.imkx.wargearmanager.commands;

import dev.imkx.wargearmanager.WarGearManager;
import dev.imkx.wargearmanager.utils.ParticleUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.UUID;

public class WarGearCommand implements CommandExecutor {
    HashMap<UUID, BukkitTask> tasks = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof ConsoleCommandSender)
            return true;
        Player p = (Player) s;
        if (args.length > 0 && args[0].equalsIgnoreCase("show")) {
            BukkitTask task = new ParticleUtil.BuildObjectOutliner(p, WarGearManager.getBasicWarGearArena())
                    .runTaskTimer(WarGearManager.getInstance(), 0, 10);
            tasks.put(p.getUniqueId(), task);
        } else if (args.length > 0 && args[0].equalsIgnoreCase("hide")) {
            if(tasks.containsKey(p.getUniqueId())) {
                tasks.get(p.getUniqueId()).cancel();
                tasks.remove(p.getUniqueId());
            }
        }
        return true;
    }
}
