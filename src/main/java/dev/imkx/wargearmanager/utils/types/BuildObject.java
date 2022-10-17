package dev.imkx.wargearmanager.utils.types;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.io.Serializable;
import java.util.ArrayList;

public class BuildObject implements Serializable {
	private final ArrayList<Part> parts = new ArrayList<>();

	public void addPart(Part part) {
		parts.add(part);
	}

	public Vector getOffsetStart() {
		Vector offsetStart = null;

		for(Part part : parts) {
			if(offsetStart == null) {
				offsetStart = part.getOffsetStart();
			} else {
				Vector partOffsetStart = part.getOffsetStart();

				offsetStart.setX(Math.min(offsetStart.getX(), partOffsetStart.getX()));
				offsetStart.setY(Math.min(offsetStart.getY(), partOffsetStart.getY()));
				offsetStart.setZ(Math.min(offsetStart.getZ(), partOffsetStart.getZ()));
			}
		}

		return offsetStart;
	}

	public Vector getOffsetEnd() {
		Vector offsetEnd = null;

		for(Part part : parts) {
			if(offsetEnd == null) {
				offsetEnd = part.getOffsetEnd();
			} else {
				Vector partOffsetEnd = part.getOffsetEnd();

				offsetEnd.setX(Math.max(offsetEnd.getX(), partOffsetEnd.getX()));
				offsetEnd.setY(Math.max(offsetEnd.getY(), partOffsetEnd.getY()));
				offsetEnd.setZ(Math.max(offsetEnd.getZ(), partOffsetEnd.getZ()));
			}
		}

		return offsetEnd;
	}

	public void build(Location location) {
		for (Part part : parts) {
			part.build(location);
		}
	}
}
