package dev.imkx.wargearmanager.utils;

import dev.imkx.wargearmanager.utils.types.BuildObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BuildUtil {
	public static BuildObject fromBuildResource(String resourceName) throws IOException, ClassNotFoundException {
		ObjectInputStream is = new ObjectInputStream(BuildUtil.class.getClassLoader().getResourceAsStream(resourceName));
		return (BuildObject) is.readObject();
	}

	public static BuildObject fromBuildFile(String filePath) throws IOException, ClassNotFoundException {
		ObjectInputStream is = new ObjectInputStream(Files.newInputStream(Paths.get(filePath)));
		return (BuildObject) is.readObject();
	}

	public static void toBuildFile(String filePath, BuildObject buildObject) throws IOException {
		ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(Paths.get(filePath)));
		os.writeObject(buildObject);
	}
}
