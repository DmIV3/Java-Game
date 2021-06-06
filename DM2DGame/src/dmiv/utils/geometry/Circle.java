package dmiv.utils.geometry;

public class Circle {

	
	private float x, y, radius;

	public Circle(float x, float y, float radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public Circle(Point p, float radius) {
		this.x = p.getX();
		this.y = p.getY();
		this.radius = radius;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
	public String toString() {
		return "Circle: x=" + x + " y=" + y + " radius=" + radius;
	}
}
