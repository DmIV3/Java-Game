package dmiv.managers;

import dmiv.assets.SpriteAssets;
import dmiv.gameobjects.Camera;
import dmiv.gameobjects.Player;
import dmiv.rendering.Renderer;
import dmiv.utils.maths.Vector2f;

public class SceneManager {
	
	private EntityManager entityManager;
	private Renderer renderer;
	private int currentLevel;
	private Vector2f playerSpawn;
	public static TileManager TILE_MANAGER;
	public static Player PLAYER;
	public static Camera MAIN_CAMERA;

	public SceneManager(Renderer renderer) {
		this.renderer = renderer;
		TILE_MANAGER = new TileManager(renderer);
		entityManager = new EntityManager(renderer);
		// TODO: перенести в отдельную функцию загрузки
		PLAYER = new Player(SpriteAssets.getSprite("player"), new Vector2f(100,400), 32, 32);
		entityManager.addEntity(PLAYER);
		MAIN_CAMERA = new Camera(0, 0);
		MAIN_CAMERA.setTarget(PLAYER);
		currentLevel = 1;
		loadWorld(currentLevel);
	}
	
	public void update() {
		TILE_MANAGER.update();
		entityManager.update();
		MAIN_CAMERA.update();
	}
	
	public void render() {
		renderer.preRender();
		renderer.clearScreen();
		TILE_MANAGER.render();
		entityManager.render();
		renderer.showResult();
	}
	
	public void loadWorld(int level) {
		TILE_MANAGER.loadTileMap("res/worlds/map" + "-" + level);
	}

	public Vector2f getPlayerSpawn() {
		return playerSpawn;
	}

	public void setPlayerSpawn(Vector2f playerSpawn) {
		this.playerSpawn = playerSpawn;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}
}
