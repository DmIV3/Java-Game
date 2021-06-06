package dmiv.gameobjects;

import java.awt.image.BufferedImage;

import dmiv.utils.maths.Vector2f;

public abstract class StaticEntity extends GameObject{
	
	public StaticEntity(BufferedImage texture, Vector2f position, int width, int height) {
		super(texture, position, width, height);
		
	}
}
