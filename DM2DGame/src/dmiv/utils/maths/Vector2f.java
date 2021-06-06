package dmiv.utils.maths;

public class Vector2f {
	
	private float x, y;
	
	public Vector2f() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2f(Vector2f v) {
		this(v.x, v.y);
	}
	
	public void translate(float x, float y) {
		this.x += x;
		this.y += y;
	}
	
	public void negate() {
		this.x = -this.x;
		this.y = -this.y;
	}
	
	public void scale(float val) {
		this.x *= val;
		this.y *= val;
	}

	public void divide(float val) {
		this.x /= val;
		this.y /= val;
	}
	
	public void addVector(Vector2f v) {
		this.x += v.x;
		this.y += v.y;
	}
	
	public void substractVector(Vector2f v) {
		this.x -= v.x;
		this.y -= v.y;
	}
	
	public float getAngleBetweenVectors(Vector2f v) {
		float dls = dot(v) / (this.getLength() * v.getLength());
		if (dls < -1.0f) dls = -1.0f;
        else if (dls > 1.0f) dls = 1.0f;
		return (float) Math.acos(dls);
	}
	
	public float dot(Vector2f v) {
		return this.x * v.x + this.y * v.y;
	}
	
	public void normalize() {
		float len = getLength();
		if(len != 0) {
			this.x /= len;
			this.y /= len;
		}else {
			this.x = 0;
			this.y = 0;
			System.err.println("Warning: length of the vector = zero");
		}
	}
	
	public void setAngle(float angle){
        float length = this.getLength();
        this.x = (float) (Math.cos(angle) * length);
        this.y = (float) (Math.sin(angle) * length);
    }
	
	public float getAngle() {
		return (float) Math.atan2(this.y, this.x);
	}
	
	public void setLength(float length) {
		float angle = this.getAngle();
        this.x = (float) (Math.cos(angle) * length);
        this.y = (float) (Math.sin(angle) * length);
	}
	
	public float getLength() {
		return (float) Math.sqrt(this.x * this.x + this.y * this.y);
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
	
	public String toString() {
		return "Vec2f: " + x + " " + y;
	}
}
