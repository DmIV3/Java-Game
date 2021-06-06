package dmiv.utils.maths;

import dmiv.utils.geometry.Circle;
import dmiv.utils.geometry.Line;
import dmiv.utils.geometry.Point;
import dmiv.utils.geometry.Rect;

public class RayCaster {

	public static Point castRay(Line l1, Line l2) {

		float rx  = l1.getB().getX() - l1.getA().getX();
		float ry = l1.getB().getY() - l1.getA().getY();
		float sx = l2.getB().getX() - l2.getA().getX();
		float sy = l2.getB().getY() - l2.getA().getY();
		float d = rx * sy - ry * sx;
		if(d == 0)
			return null;
		float u = ((l2.getA().getX() - l1.getA().getX()) * ry - (l2.getA().getY() - l1.getA().getY()) * rx) / d;
		float t = ((l2.getA().getX() - l1.getA().getX()) * sy - (l2.getA().getY() - l1.getA().getY()) * sx) / d;
		if(0 <= u && u <= 1 && 0 <= t && t <= 1) {
			return new Point(l1.getA().getX() + t * rx, l1.getA().getY() + t * ry);
		}
		return null;
	}
	
	public static Point castRay(Line l1, Rect r) {
		Point closest = null;
		float record = 999999;
		Line l2 = new Line(r.getX(), r.getY(), r.getX() + r.getWidth(), r.getY());
		Point p1 = castRay(l1, l2);
		l2 = new Line(r.getX() + r.getWidth(), r.getY(),  r.getX() + r.getWidth(), r.getY() + r.getHeight());
		Point p2 = castRay(l1, l2);
		l2 = new Line(r.getX() + r.getWidth(), r.getY() + r.getHeight(), r.getX(), r.getY() + r.getHeight());
		Point p3 = castRay(l1, l2);
		l2 = new Line(r.getX(), r.getY() + r.getHeight(), r.getX(), r.getY());
		Point p4 = castRay(l1, l2);
		if(p1 != null) {
			closest = p1;
			record = Maths.calcDist(closest.getX(), closest.getY(), l1.getA().getX(), l1.getA().getY());
		}
		if(p2 != null) {
			float d = Maths.calcDist(p2.getX(), p2.getY(), l1.getA().getX(), l1.getA().getY());
			if(d < record) {
				record = d;
				closest = p2;
			}
		}
		if(p3 != null) {
			float d = Maths.calcDist(p3.getX(), p3.getY(), l1.getA().getX(), l1.getA().getY());
			if(d < record) {
				record = d;
				closest = p3;
			}
		}
		if(p4 != null) {
			float d = Maths.calcDist(p4.getX(), p4.getY(), l1.getA().getX(), l1.getA().getY());
			if(d < record) {
				closest = p4;
			}
		}
		return closest;
	}
	
	public static Point castRay(Line l1, Circle c1) {
		Point near = null;
		float rayDirX = l1.getB().getX() - l1.getA().getX(); //WARN
		float rayDirY = l1.getB().getY() - l1.getA().getY();
		float len = (float) Math.sqrt(rayDirX*rayDirX+rayDirY*rayDirY);
		if(len == 0)return null;
		rayDirX /= len;
		rayDirY /= len;
		float t = rayDirX * (c1.getX() - l1.getA().getX()) + rayDirY * (c1.getY() - l1.getA().getY());
		float perpendicularToDirX = rayDirX * t + l1.getA().getX();
		float perpendicularToDirY = rayDirY * t + l1.getA().getY();

		float xDist = perpendicularToDirX - c1.getX();
		float yDist = perpendicularToDirY - c1.getY();
		float closestPointDist = (float) Math.sqrt(xDist * xDist + yDist * yDist);
		float inteSection = c1.getRadius() * c1.getRadius() - closestPointDist * closestPointDist;
		if(inteSection < 0)return null;
		inteSection = (float) Math.sqrt(inteSection);
		float itX = t-inteSection;
//		float itY = t+inteSection;

		if(itX > 0) {
	
			near = new Point(rayDirX * itX + l1.getA().getX(), rayDirY * itX + l1.getA().getY());
//			Point far = new Point(rayDirX * itY + l1.getA().getX(), rayDirY * itY + l1.getA().getY());
		}
		
		return near;
	}
}
