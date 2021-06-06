package dmiv.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while((line = reader.readLine()) != null) {
				builder.append(line + "\n");
			}
			reader.close();
		}catch(IOException e) {
			System.err.println("Map file isn't found!");
			builder.append("14 7" + "\n");
			builder.append("0 0 0 0 0 0 0 0 0 0 0 0 0 0" + "\n");
			builder.append("0 2 2 2 0 0 2 0 0 2 0 2 0 0" + "\n");
			builder.append("0 2 0 0 0 2 0 2 0 2 0 2 0 0" + "\n");
			builder.append("0 2 2 2 0 2 2 2 0 2 0 2 0 0" + "\n");
			builder.append("0 2 0 0 0 2 0 2 0 2 0 2 0 0" + "\n");
			builder.append("0 2 0 0 0 2 0 2 0 2 0 2 2 0" + "\n");
			builder.append("0 0 0 0 0 0 0 0 0 0 0 0 0 0" + "\n");
		}
		
		return builder.toString();
	}
}
