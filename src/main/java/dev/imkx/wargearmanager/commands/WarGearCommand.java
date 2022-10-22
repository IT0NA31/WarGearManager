package dev.imkx.wargearmanager.commands;

import dev.imkx.wargearmanager.WarGearManager;
import dev.imkx.wargearmanager.utils.BuildUtil;
import dev.imkx.wargearmanager.utils.ParticleUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class WarGearCommand implements CommandExecutor {
    HashMap<UUID, BukkitTask> tasks = new HashMap<>();

    private void removeTask(UUID uuid) {
        if (tasks.containsKey(uuid)) {
            tasks.get(uuid).cancel();
            tasks.remove(uuid);
        }
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof ConsoleCommandSender)
            return true;
        Player p = (Player) s;
        BukkitTask task;
        switch (args[0]) {
            case "show":
                removeTask(p.getUniqueId());
                task = new ParticleUtil.BuildObjectOutliner(p, WarGearManager.getBasicWarGearArena())
                        .runTaskTimer(WarGearManager.getInstance(), 0, 10);
                tasks.put(p.getUniqueId(), task);
                break;
            case "hide":
                removeTask(p.getUniqueId());
                break;
            case "freeze":
                removeTask(p.getUniqueId());
                task = new ParticleUtil.BuildObjectOutliner(p, WarGearManager.getBasicWarGearArena(), p.getLocation())
                        .runTaskTimer(WarGearManager.getInstance(), 0, 10);
                tasks.put(p.getUniqueId(), task);
                break;
            case "apply":
                WarGearManager.getBasicWarGearArena().build(p.getLocation());
                break;
            case "save":
                try {
                    BuildUtil.toBuildFile("plugins/WarGearManager/basicWarGearArena.bf", WarGearManager.getBasicWarGearArena());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        return true;
    }
}
