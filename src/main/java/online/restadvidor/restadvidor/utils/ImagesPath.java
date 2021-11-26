package online.restadvidor.restadvidor.utils;

import java.io.File;

public class ImagesPath {

	public static StringBuilder getPath() {
		StringBuilder builder = new StringBuilder();
		builder.append(System.getProperty("user.home"));
		builder.append(File.separator);
		builder.append("uploads");
		builder.append(File.separator);
		return builder;
	}
}
