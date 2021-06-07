package dmiv.gobjects.components;

import java.awt.image.BufferedImage;
import dmiv.gobjects.GObject;

public class SpriteComponent extends Component {

	private BufferedImage sprite;
	private float x, y, xoff, yoff;
	private int width, height;
	private GObject obj;
	
	public SpriteComponent(BufferedImage sprite, GObject obj) {
		this.id = ComponentID.Graphics;
		this.sprite = sprite;
		this.obj = obj;
		this.x = obj.getPosition().getX();
		this.y = obj.getPosition().getY();
		this.xoff = 0;
		this.yoff = 0;
		this.width = obj.getWidth();
		this.height = obj.getHeight();
	}

	@Override
	public void update() {
		this.x = obj.getPosition().getX() + xoff;
		this.y = obj.getPosition().getY() + yoff;
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
	
	public float getXOffset() {
		return xoff;
	}

	public float getYOffset() {
		return yoff;
	}
	
	public void setXOffset(float xoff) {
		this.xoff = xoff;
	}

	public void setYOffset(float yoff) {
		this.yoff = yoff;
	}

	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
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
}
