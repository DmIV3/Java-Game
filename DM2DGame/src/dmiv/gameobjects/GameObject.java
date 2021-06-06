package dmiv.gameobjects;

import java.awt.image.BufferedImage;

import dmiv.utils.maths.Vector2f;

public abstract class GameObject {
	
	protected Vector2f position;
	protected int width, height;
	protected Vector2f spritePosition;
	protected int spriteOffsetX, spriteOffsetY;
	protected int spriteWidth, spriteHeight;
	protected boolean active;
	protected BufferedImage texture;
	
	public GameObject(BufferedImage texture, Vector2f position, int width, int height) {
		this.width = width;
		this.height = height;
		this.position = position;
		this.spritePosition = new Vector2f(position);
		this.spriteWidth = width;
		this.spriteHeight = height;
		this.spriteOffsetX = 0;
		this.spriteOffsetY = 0;
		this.texture = texture;
		this.active = true;
	}
	
	public abstract void update();
	
	// GETTERS AND SETTERS
	public BufferedImage getTexture() {
		return texture;
	}
	
	public Vector2f getSpritePosition() {
		return spritePosition;
	}

	public void setSpritePosition(Vector2f spritePosition) {
		this.spritePosition = spritePosition;
	}

	public int getSpriteOffsetX() {
		return spriteOffsetX;
	}

	public void setSpriteOffsetX(int spriteOffsetX) {
		this.spriteOffsetX = spriteOffsetX;
	}

	public int getSpriteOffsetY() {
		return spriteOffsetY;
	}

	public void setSpriteOffsetY(int spriteOffsetY) {
		this.spriteOffsetY = spriteOffsetY;
	}

	public int getSpriteWidth() {
		return spriteWidth;
	}

	public void setSpriteWidth(int spriteWidth) {
		this.spriteWidth = spriteWidth;
	}

	public int getSpriteHeight() {
		return spriteHeight;
	}

	public void setSpriteHeight(int spriteHeight) {
		this.spriteHeight = spriteHeight;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
	
	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String toString() {
		return this.getClass().getName() + " pos: x" + getPosition().getX() + " y" + getPosition().getY();
	}
}
