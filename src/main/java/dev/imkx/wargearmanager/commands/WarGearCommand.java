package dev.imkx.wargearmanager.commands;

import dev.imkx.wargearmanager.utils.ParticleUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class WarGearCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof ConsoleCommandSender)
            return true;
        Player p = (Player) s;
        ParticleUtil.spawnBox(p.getLocation().clone().subtract(20, 20, 20),
                p.getLocation().clone().add(10, 10, 10));
        return true;
    }
}
