package dmiv.loaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TileMapLoader {

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
			e.printStackTrace();
		}
		
		return builder.toString();
	}

}
