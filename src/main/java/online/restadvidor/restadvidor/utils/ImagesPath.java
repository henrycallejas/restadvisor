package online.restadvidor.restadvidor.utils;

import java.io.File;

public class ImagesPath {

	public static StringBuilder getPath() {
		StringBuilder builder = new StringBuilder();
		System.out.println("EL HOME ES: " + System.getProperty("user.home"));
		//System.out.println(System.getProperty("os.name"));
		//if(System.getProperty("os.name") == "Windows 7") {
			builder.append(System.getProperty("user.home"));
		//}else {
			//builder.append("/var/www/html");
		//}
		
		builder.append(File.separator);
		builder.append("uploads");
		builder.append(File.separator);
		return builder;
	}
}
