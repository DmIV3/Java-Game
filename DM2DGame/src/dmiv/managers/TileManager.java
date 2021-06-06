package dmiv.managers;

import java.awt.Rectangle;

import dmiv.assets.SpriteAssets;
import dmiv.rendering.Renderer;
import dmiv.tile.Tile;
import dmiv.utils.Utils;

public class TileManager {
	
	private Tile[][] tileMap;
	private Tile grass;
	private Tile dirt;
	private Tile rock;

	private Tile errorTile;
	private Renderer renderer;
	
	public TileManager(Renderer renderer) {
		this.renderer = renderer;
		
		grass = new Tile(SpriteAssets.getSprite("grass"), 0, false);
		dirt = new Tile(SpriteAssets.getSprite("dirt"), 1, false);
		rock = new Tile(SpriteAssets.getSprite("rock"), 2, true);
		errorTile = new Tile(SpriteAssets.getSprite("error"), 2, false);
	}
	
	public void update() {
		
	}
	
	public void render() {
		for(int y = 0; y < Settings.WORLD_HEIGHT; y++) {
			for(int x = 0; x < Settings.WORLD_WIDTH; x++) {
				renderer.drawImage(tileMap[x][y].getTexture(), x * Settings.TILE_WIDTH - (int)SceneManager.MAIN_CAMERA.getX(), y * Settings.TILE_HEIGHT - (int)SceneManager.MAIN_CAMERA.getY(), Settings.TILE_WIDTH, Settings.TILE_HEIGHT);
			}
		}
	}
	
	public void loadTileMap(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		Settings.WORLD_WIDTH = Utils.parseInt(tokens[0]);
		Settings.WORLD_HEIGHT = Utils.parseInt(tokens[1]);
		
		tileMap = new Tile[Settings.WORLD_WIDTH][Settings.WORLD_HEIGHT];
		for(int y = 0; y < Settings.WORLD_HEIGHT; y++) {
			for(int x = 0; x < Settings.WORLD_WIDTH; x++) {
				tileMap[x][y] = getTileById(Utils.parseInt(tokens[(x + y * Settings.WORLD_WIDTH) + 2]));
			}
		}
	}
	
	private Tile getTileById(int id){
		if(id == 0)
			return grass;
		if(id == 1)
			return dirt;
		if(id == 2)
			return rock;
		
		return errorTile;
	}
	
	// GETTERS AND SETTERS
	public Tile[][] getTileMap() {
		return tileMap;
	}
	
	public Tile getTileByGlobalPosition(float x, float y) {
		int tx = (int) Math.floor(x / Settings.TILE_WIDTH);
		int ty = (int) Math.floor(y / Settings.TILE_HEIGHT);
		if(tx < 0 || ty < 0 || tx >= Settings.WORLD_WIDTH || ty >= Settings.WORLD_HEIGHT)
			return grass;
		return tileMap[tx][ty];
	}
	
	public Rectangle getTileRectangle(float x, float y) {
		int tx = ((int) Math.floor(x / Settings.TILE_WIDTH)) * Settings.TILE_WIDTH;
		int ty = ((int) Math.floor(y / Settings.TILE_HEIGHT)) * Settings.TILE_HEIGHT;
		return new Rectangle(tx, ty, Settings.TILE_WIDTH,Settings.TILE_HEIGHT);
	}
}
