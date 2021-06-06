package dmiv.assets;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import dmiv.loaders.ImageLoader;
import dmiv.utils.ImageProcessor;

public class SpriteAssets {
	
	private static Map<String, BufferedImage> sprites;
	
	public static void init() {
		sprites =  new HashMap<String, BufferedImage>();
		BufferedImage img = ImageLoader.loadImage("res/textures/sheet.png");
		BufferedImage player = ImageLoader.loadImage("res/textures/char.png");
		
		addSprite("grass", ImageProcessor.crop(img, 0, 0, 64, 64));
		addSprite("dirt", ImageProcessor.crop(img, 64, 0, 64, 64));
		addSprite("rock", ImageProcessor.crop(img, 128, 0, 64, 64));
		addSprite("error", ImageProcessor.crop(img, 256, 0, 64, 64));
		addSprite("player", ImageProcessor.crop(player, 0, 0, 64, 64));
	}
	
	public static void addSprite(String name, BufferedImage img) {
		if(sprites.containsKey(name)) {
			System.out.println("++++++++++++++++++++++++");
			System.err.println("Sprite name: \"" + name + "\" is already taken!");
		}else {
			sprites.put(name, img);
		}
	}
	
	public static BufferedImage getSprite(String name) {
		if(sprites.containsKey(name))
			return sprites.get(name);
		else
			System.err.println("Sprite " + name + " isn't exist!");
		System.exit(1);
		return null;
	}
}
