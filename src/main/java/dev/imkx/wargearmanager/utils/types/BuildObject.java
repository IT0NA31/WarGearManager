package dev.imkx.wargearmanager.utils.types;

import org.bukkit.Location;

import java.io.Serializable;
import java.util.ArrayList;

public class BuildObject implements Serializable {
	private final ArrayList<Part> parts = new ArrayList<>();

	public void addPart(Part part) {
		parts.add(part);
	}

	public void build(Location location) {
		for (Part part : parts) {
			part.build(location);
		}
	}
}
