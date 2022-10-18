package dev.imkx.wargearmanager.utils.types.models;

import dev.imkx.wargearmanager.utils.types.Part;
import dev.imkx.wargearmanager.utils.types.SerializableVector;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

public class BlockPart implements Part {
	private final SerializableVector offset_start;
	private final Material material;

	public BlockPart(Vector offsetStart, Material material) {
		this.offset_start = new SerializableVector(offsetStart);
		this.material = material;
	}

	public Vector getOffsetStart() {
		return offset_start;
	}

	@Override
	public Vector getOffsetEnd() {
		return offset_start.clone().add(new Vector(1, 1, 1));
	}

	public Material getMaterial() {
		return material;
	}

	public void build(Location location) {
		location.clone().add(offset_start).getBlock().setType(material);
	}
}
