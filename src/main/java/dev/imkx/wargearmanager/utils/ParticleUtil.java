package dev.imkx.wargearmanager.utils;

import org.bukkit.Location;
import org.bukkit.Particle;

public class ParticleUtil {
    public static void spawnLine(Location from, Location to) {
        int lengthX = (to.getBlockX() - from.getBlockX());
        int lengthY = (to.getBlockY() - from.getBlockY());
        int lengthZ = (to.getBlockZ() - from.getBlockZ());
        double length = (lengthY + lengthZ + lengthX);
        for(int i = 0; i <= length; i++) {
            Location l = from.clone().add(lengthX/length, lengthY/length, lengthZ/length);
            l.getWorld().spawnParticle(Particle.REDSTONE, l, 1);
        }

    }
    public static void spawnBox(Location from, Location to) {
        for(Location l : GeometryUtil.getHollowCube(from, to)) {
            l.getWorld().spawnParticle(Particle.REDSTONE, l, 1);
        }
    }
}
