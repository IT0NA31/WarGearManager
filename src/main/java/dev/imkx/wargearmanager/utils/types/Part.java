package dev.imkx.wargearmanager.utils.types;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

import java.io.Serializable;

public interface Part extends Serializable {
	Vector getOffsetStart();
	Vector getOffsetEnd();

	Material getMaterial();

	void build(Location location);
}
