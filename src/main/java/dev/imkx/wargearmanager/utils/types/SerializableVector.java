package dev.imkx.wargearmanager.utils.types;

import org.bukkit.util.Vector;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SerializableVector extends Vector implements Externalizable, Cloneable {
	public SerializableVector() {
	}
	public SerializableVector(Vector vector) {
		super(vector.getX(), vector.getY(), vector.getZ());
	}
	public SerializableVector(float x, float y, float z) {
		super(x, y, z);
	}



	public SerializableVector add(Vector vec) {
		return new SerializableVector(super.add(vec));
	}
	public SerializableVector subtract(Vector vec) {
		return new SerializableVector(super.subtract(vec));
	}
	public SerializableVector multiply(Vector vec) {
		return new SerializableVector(super.multiply(vec));
	}
	public SerializableVector divide(Vector vec) {
		return new SerializableVector(super.divide(vec));
	}



	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeDouble(getX());
		out.writeDouble(getY());
		out.writeDouble(getZ());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException {
		setX(in.readDouble());
		setY(in.readDouble());
		setZ(in.readDouble());
	}



	@Override
	public SerializableVector clone() {
		return (SerializableVector) super.clone();
	}
}
