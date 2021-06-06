package dmiv.gameobjects;

import dmiv.managers.Settings;
import dmiv.utils.maths.Vector2f;

public class Camera {
	
	private Vector2f position;
	private Vector2f offset;
	private GameObject target;
	
	public Camera(float x, float y) {
		position = new Vector2f(x, y);
		this.offset = new Vector2f(0, 0);
	}
	
	public void update() {
		if(target != null)
			centerOnTarget();
		checkWorldBounds();
	}
	
	public void centerOnTarget() {
		position.setX(target.position.getX() - Settings.WINDOW_WIDTH / 2 + target.width / 2);
		position.setY(target.position.getY() - Settings.WINDOW_HEIGHT / 2 + target.height / 2);
		position.addVector(offset);
	}
	
	public void checkWorldBounds() {
		if(Settings.WORLD_WIDTH * Settings.TILE_WIDTH > Settings.WINDOW_WIDTH) {
			if(position.getX() < 0)
				position.setX(0);
			else if(position.getX() > Settings.WORLD_WIDTH * Settings.TILE_WIDTH - Settings.WINDOW_WIDTH) 
				position.setX(Settings.WORLD_WIDTH * Settings.TILE_WIDTH - Settings.WINDOW_WIDTH);
		}
		if(Settings.WORLD_HEIGHT * Settings.TILE_HEIGHT > Settings.WINDOW_HEIGHT) {
			if(position.getY() < 0)
				position.setY(0);
			else if(position.getY() > Settings.WORLD_HEIGHT * Settings.TILE_HEIGHT - Settings.WINDOW_HEIGHT) 
				position.setY(Settings.WORLD_HEIGHT * Settings.TILE_HEIGHT - Settings.WINDOW_HEIGHT);
		}
	}
	// GETTERS AND SETTERS
	public void setTarget(GameObject target) {
		this.target = target;
	}
	
	public float getX() {
		return position.getX();
	}
	
	public float getY() {
		return position.getY();
	}
	
	public String toString() {
		return "camera: " + position.getX() + " " + position.getY();
	}
}
