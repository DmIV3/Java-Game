package dmiv.utils.geometry;

public class Line {
	
	private Point a;
	private Point b;
	
	
	public Line(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	public Line(float ax, float ay, float bx, float by) {
		this.a = new Point(ax, ay);
		this.b = new Point(bx, by);
	}
	
	public Point getA() {
		return a;
	}


	public void setA(Point a) {
		this.a = a;
	}
	
	public void setA(float x, float y) {
		this.a.setX(x);
		this.a.setY(y);
	}


	public Point getB() {
		return b;
	}


	public void setB(Point b) {
		this.b = b;
	}
	
	public void setB(float x, float y) {
		this.b.setX(x);
		this.b.setY(y);
	}

	public String toString() {
		return "Line: a.x=" + a.getX() + " a.y=" + a.getY() + " b.x=" + b.getX() + " b.y=" + b.getY();
	}
}	
