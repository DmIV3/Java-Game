package dmiv.gobjects;

import java.util.HashMap;
import java.util.Map;

import dmiv.gobjects.components.Component;
import dmiv.gobjects.components.ComponentID;
import dmiv.utils.maths.Vector2f;

public abstract class GObject {
	
	protected Vector2f pos;
	protected int width, height;
	protected boolean isActive;
	protected Map<ComponentID, Component> components;
	
	public GObject(Vector2f pos, int width, int height) {
		this.pos = pos;
		this.width = width;
		this.height = height;
		this.isActive = true;
		this.components = new HashMap<ComponentID, Component>();
	}
	
	public abstract void update();
	
	public void updateComponents() {
		for (Map.Entry<ComponentID, Component> c : components.entrySet()) {
		    c.getValue().update();
		}
	}
	
	public void addComponent(Component component) {
		if(components.containsKey(component.getId())){
			System.err.println("This object already hac such a component");
			return;
		}
		this.components.put(component.getId(), component);
	}
	
	public boolean hasComponent(ComponentID id) {
		if(components.containsKey(id))
			return true;
		return false;
	}
	
	public Component getComponent(ComponentID id) {
		return components.get(id);
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

	public Vector2f getPosition() {
		return pos;
	}
	
	public void setPosition(Vector2f pos) {
		this.pos = pos;
	}
	
	public void setPosition(float x, float y) {
		this.pos.setX(x);
		this.pos.setY(y);
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
