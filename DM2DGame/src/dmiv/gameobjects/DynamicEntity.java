package dmiv.gameobjects;

import java.awt.image.BufferedImage;

import dmiv.managers.Settings;
import dmiv.utils.geometry.Point;
import dmiv.utils.maths.Maths;
import dmiv.utils.maths.Vector2f;

public abstract class DynamicEntity extends GameObject{
	
	protected Vector2f velocity;
	protected float contactTime;
	protected Point contactPoint,
					contactNormal;
					
	
	public DynamicEntity(BufferedImage texture, Vector2f position, int width, int height) {
		super(texture, position, width, height);
		this.texture = texture;
		this.velocity = new Vector2f(0, 0);
		this.contactPoint = new Point(0, 0);
		this.contactNormal = new Point(0, 0);
		this.contactTime = 0;
	}
	
	protected void updateSpritePosition() {
		spritePosition.setX(position.getX() + spriteOffsetX);
		spritePosition.setY(position.getY() + spriteOffsetY);
	}
	
	protected void clampInsideMap() {
		position.setX(Maths.clamp(position.getX(), 0, Settings.WORLD_WIDTH * Settings.TILE_WIDTH - width));
		position.setY(Maths.clamp(position.getY(), 0, Settings.WORLD_HEIGHT * Settings.TILE_HEIGHT - height));
	}
	
	protected void increaseVelX(float x) {
		velocity.setX((velocity.getX() + x));
	}
	
	protected void increaseVelY(float y) {
		velocity.setY((velocity.getY() + y));
	}
	
	// GETTERS AND SETTERS
	public Vector2f getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public Point getContactPoint() {
		return contactPoint;
	}

	public void setContactPoint(Point contactPoint) {
		this.contactPoint = contactPoint;
	}

	public Point getContactNormal() {
		return contactNormal;
	}

	public void setContactNormal(Point contactNormal) {
		this.contactNormal = contactNormal;
	}

	public float getContactTime() {
		return contactTime;
	}

	public void setContactTime(float contactTime) {
		this.contactTime = contactTime;
	}
}
