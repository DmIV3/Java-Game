package dmiv.gobjects;

import java.awt.event.KeyEvent;

import dmiv.assets.SpriteAssets;
import dmiv.gobjects.components.SpriteComponent;
import dmiv.input.KeyboardInput;
import dmiv.managers.Settings;
import dmiv.managers.Time;
import dmiv.utils.maths.Maths;
import dmiv.utils.maths.Vector2f;

public class Player extends GObject {
	
	private Vector2f velocity;
	private float movementSpeed;
	
	public Player(Vector2f pos, int width, int height) {
		super(pos, width, height);
		addComponent(new SpriteComponent(SpriteAssets.getSprite("player"), this));
		this.velocity = new Vector2f(0, 0);
		this.movementSpeed = 300;
	}

	@Override
	public void update() {
		velocity.setX(0);
		velocity.setY(0);
		if(KeyboardInput.keyDown(KeyEvent.VK_A))
			increaseVelX(-1);
		if(KeyboardInput.keyDown(KeyEvent.VK_D))
			increaseVelX(1);
		if(KeyboardInput.keyDown(KeyEvent.VK_W))
			increaseVelY(-1);
		if(KeyboardInput.keyDown(KeyEvent.VK_S))
			increaseVelY(1);
		
		if(velocity.getX() != 0 || velocity.getY() != 0) {
			velocity.normalize();
			velocity.scale(movementSpeed * Time.getDeltaTime());
		}

		pos.addVector(velocity);
		clampInsideMap();
	}
	protected void clampInsideMap() {
		pos.setX(Maths.clamp(pos.getX(), 0, Settings.WORLD_WIDTH * Settings.TILE_WIDTH - width));
		pos.setY(Maths.clamp(pos.getY(), 0, Settings.WORLD_HEIGHT * Settings.TILE_HEIGHT - height));
	}
	
	protected void increaseVelX(float x) {
		velocity.setX((velocity.getX() + x));
	}
	
	protected void increaseVelY(float y) {
		velocity.setY((velocity.getY() + y));
	}
}
