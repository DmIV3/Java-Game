package dmiv.managers;

import java.util.ArrayList;
import java.util.Iterator;

import dmiv.gameobjects.GameObject;
import dmiv.rendering.Renderer;

public class EntityManager {
	
	private Renderer renderer;
	private ArrayList<GameObject> entities;

	public EntityManager(Renderer renderer) {
		this.renderer = renderer;
		
		entities = new ArrayList<GameObject>();
	}
	
	public void update() {
		Iterator<GameObject> ite = entities.iterator();
		while(ite.hasNext()) {
			GameObject g = ite.next();
			g.update();
			if(!g.isActive())
				ite.remove();
				
		}
	}
	
	public void render() {
		for(GameObject g: entities) {
			renderer.drawImage(g.getTexture(), (int)(g.getSpritePosition().getX() - SceneManager.MAIN_CAMERA.getX()), (int)(g.getSpritePosition().getY() - SceneManager.MAIN_CAMERA.getY()), g.getSpriteWidth(), g.getSpriteHeight());
			if(Settings.DEVMODE)
				renderBounds(g);
		}
	}
	
	public void renderBounds(GameObject g) {
		renderer.drawRect(g.getPosition().getX() - SceneManager.MAIN_CAMERA.getX(), g.getPosition().getY() - SceneManager.MAIN_CAMERA.getY(), g.getWidth(), g.getHeight());
	}
	
	public void addEntity(GameObject g) {
		entities.add(g);
	}
}
