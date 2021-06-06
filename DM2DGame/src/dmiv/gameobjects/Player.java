package dmiv.gameobjects;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import dmiv.input.KeyboardInput;
import dmiv.input.MouseInput;
import dmiv.managers.SceneManager;
import dmiv.managers.Time;
import dmiv.utils.geometry.Rect;
import dmiv.utils.maths.Collision;
import dmiv.utils.maths.Vector2f;

public class Player extends DynamicEntity{
	
	private float movementSpeed = 400;
	private int healthPoints = 100;
	private ID id = ID.Player;
	
	public Player(BufferedImage texture, Vector2f position, int width, int height) {
		super(texture, position, width, height);
		this.spriteOffsetX = -16;
		this.spriteOffsetY = -32;
		this.spriteWidth = 64;
		this.spriteHeight = 64;
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
		// TEST CODE
		if(MouseInput.buttonReleased(3))
			setPosition(new Vector2f(MouseInput.getX() + SceneManager.MAIN_CAMERA.getX() - width/2, MouseInput.getY() + SceneManager.MAIN_CAMERA.getY() -  height/2));
		if(MouseInput.buttonReleased(1))
			System.out.println(SceneManager.TILE_MANAGER.getTileByGlobalPosition(position.getX()+width/2, position.getY()+height/2));
//			System.out.println(WorldManager.TILE_MANAGER.getTileRectangle(position.getX()+width/2, position.getY()+height/2));
		if(Collision.GameObjectVSRect(this, new Rect(320, 192, 64, 64))) {

		}
			
		// END TEST CODE
		position.addVector(velocity);
		clampInsideMap();
		updateSpritePosition();
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

}
