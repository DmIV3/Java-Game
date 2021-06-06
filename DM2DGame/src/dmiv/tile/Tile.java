package dmiv.tile;

import java.awt.image.BufferedImage;

public class Tile {
	
	private BufferedImage texture;
	private boolean isSolid = false;
	private int id;
	
	public Tile(BufferedImage texture, int id, boolean isSolid) {
		this.texture = texture;
		this.isSolid = isSolid;
		this.id = id;
	}
	
	public String toString() {
		return "Tile: " + id + " solid: " + isSolid;
	}
	
	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public boolean isSolid() {
		return isSolid;
	}

	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
}
