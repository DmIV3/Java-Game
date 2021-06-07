package dmiv.gobjects.components;

public abstract class Component {
	
	protected ComponentID id;
	
	public abstract void update();
	
	public ComponentID getId() {
		return id;
	}
}
