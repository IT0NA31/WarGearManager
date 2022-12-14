package dev.imkx.wargearmanager.utils.types.models;

import dev.imkx.wargearmanager.utils.types.Part;
import dev.imkx.wargearmanager.utils.types.SerializableVector;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class EdgeBoxPart implements Part {
	SerializableVector offset_start;
	SerializableVector offset_end;
	Material material;

	public EdgeBoxPart(Vector offsetStart, Vector size, Material material) {
		this.offset_start = new SerializableVector(offsetStart);
		this.offset_end = new SerializableVector(offsetStart.clone().add(size));
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
		int minX = Math.min(corner1.getBlockX(), corner2.getBlockX());
		int minY = Math.min(corner1.getBlockY(), corner2.getBlockY());
		int minZ = Math.min(corner1.getBlockZ(), corner2.getBlockZ());
		int maxX = Math.max(corner1.getBlockX(), corner2.getBlockX()) - 1;
		int maxY = Math.max(corner1.getBlockY(), corner2.getBlockY()) - 1;
		int maxZ = Math.max(corner1.getBlockZ(), corner2.getBlockZ()) - 1;

		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				for (int z = minZ; z <= maxZ; z++) {
					int components = 0;
					if (x == minX || x == maxX) components++;
					if (y == minY || y == maxY) components++;
					if (z == minZ || z == maxZ) components++;
					if (components >= 2) {
						world.getBlockAt(x, y, z).setType(material);
					}
				}
			}
		}
	}
}
