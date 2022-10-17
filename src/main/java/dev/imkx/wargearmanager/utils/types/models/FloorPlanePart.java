package dev.imkx.wargearmanager.utils.types.models;

import dev.imkx.wargearmanager.utils.types.Part;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

public class FloorPlanePart implements Part {
	Vector offset_start;
	Vector offset_end;
	Material material;

	public FloorPlanePart(Vector offsetStart, Vector size, Material material) {
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
		Location from = location.clone().add(offset_start);
		Location to = location.clone().add(offset_end);

		for(int x = from.getBlockX(); x <= to.getBlockX() - 1; x++) {
			for(int z = from.getBlockZ(); z <= to.getBlockZ() - 1; z++) {
				from.getWorld().getBlockAt(x, from.getBlockY(), z).setType(material);
			}
		}
	}
}
