package dev.imkx.wargearmanager.utils;

import dev.imkx.wargearmanager.utils.types.BuildObject;
import dev.imkx.wargearmanager.utils.types.Part;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleUtil {
    public static void spawnLine(Location from, Location to) {
        int lengthX = (to.getBlockX() - from.getBlockX());
        int lengthY = (to.getBlockY() - from.getBlockY());
        int lengthZ = (to.getBlockZ() - from.getBlockZ());
        double length = (lengthY + lengthZ + lengthX);
        for(int i = 0; i <= length; i++) {
            Location l = from.clone().add(lengthX/length, lengthY/length, lengthZ/length);
            l.getWorld().spawnParticle(Particle.REDSTONE, l, 0, Float.MIN_VALUE, 1, Float.MIN_VALUE, 1);
        }

    }

    public static void spawnBox(Location from, Location to) {
        for(Location l : GeometryUtil.getHollowCube(from, to)) {
            l.getWorld().spawnParticle(Particle.REDSTONE, l, 0, Float.MIN_VALUE, 1, Float.MIN_VALUE, 1);
        }
    }

    public static void spawnBox(Player p, Location from, Location to) {
        for(Location l : GeometryUtil.getHollowCube(from, to)) {
            p.spawnParticle(Particle.REDSTONE, l, 0, Float.MIN_VALUE, 1, Float.MIN_VALUE, 1);
        }
    }

    public static class BuildObjectOutliner extends BukkitRunnable {
        Player p;
        BuildObject buildObject;
        public BuildObjectOutliner(Player p, BuildObject buildObject) {
            this.p = p;
            this.buildObject = buildObject;
        }

        @Override
        public void run() {
            if (!p.isOnline())
                cancel();
            Location loc = p.getLocation().getBlock().getLocation();
            // main box
            ParticleUtil.spawnBox(p, loc.clone().add(buildObject.getOffsetStart()),
                    loc.clone().add(buildObject.getOffsetEnd()));
            for (Part part : buildObject.getParts()) {
                ParticleUtil.spawnBox(p, loc.clone().add(part.getOffsetStart()),
                        loc.clone().add(part.getOffsetEnd()));
            }
        }
    }
}
