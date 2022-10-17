package dev.imkx.wargearmanager.utils.types.models;

import dev.imkx.wargearmanager.utils.types.Part;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class EdgeBoxPart implements Part {
	Vector offset_start;
	Vector offset_end;
	Material material;

	public EdgeBoxPart(Vector offsetStart, Vector size, Material material) {
		this.offset_start = offsetStart;
		this.offset_end = offsetStart.clone().add(size);
		this.material = material;
	}

	public Vector getOffsetStart() {
		return offset_start;
	}

	public Vector getOffsetEnd() {
		return offset_end;
	}

	public Material getMaterial() {
		return material;
	}

	public void build(Location location) {
		Location corner1 = location.clone().add(offset_start);
		Location corner2 = location.clone().add(offset_end);

		World world = corner1.getWorld();
		double minX = Math.min(corner1.getX(), corner2.getX());
		double minY = Math.min(corner1.getY(), corner2.getY());
		double minZ = Math.min(corner1.getZ(), corner2.getZ());
		double maxX = Math.max(corner1.getX(), corner2.getX());
		double maxY = Math.max(corner1.getY(), corner2.getY());
		double maxZ = Math.max(corner1.getZ(), corner2.getZ());

		for (double x = minX; x <= maxX; x++) {
			for (double y = minY; y <= maxY; y++) {
				for (double z = minZ; z <= maxZ; z++) {
					int components = 0;
					if (x == minX || x == maxX) components++;
					if (y == minY || y == maxY) components++;
					if (z == minZ || z == maxZ) components++;
					if (components >= 2) {
						world.getBlockAt((int) x, (int) y, (int) z).setType(material);
					}
				}
			}
		}
	}
}
