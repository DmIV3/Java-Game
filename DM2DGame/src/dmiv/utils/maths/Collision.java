package dmiv.utils.maths;

import dmiv.gameobjects.DynamicEntity;
import dmiv.utils.geometry.Line;
import dmiv.utils.geometry.Rect;

public class Collision {

	public static boolean GameObjectVSRect(DynamicEntity gameObject, Rect rectangle) {		
		if(gameObject.getVelocity().getX() == 0 && gameObject.getVelocity().getY() == 0)
			return false;
	    
		Rect rect = new Rect(
				rectangle.getX() - gameObject.getWidth() / 2,
				rectangle.getY() - gameObject.getHeight() / 2,
				rectangle.getWidth() + gameObject.getWidth(),
				rectangle.getHeight() + gameObject.getHeight()
			);
		Line line = new Line(
				gameObject.getPosition().getX() + gameObject.getWidth() / 2,
				gameObject.getPosition().getY() + gameObject.getHeight() / 2,
				gameObject.getVelocity().getX(),
				gameObject.getVelocity().getY());
		
		Line invRay = new Line(
				line.getA().getX(),
				line.getA().getY(),
				1 / line.getB().getX(),
				1 / line.getB().getY());
		
	    float tNearX = (rect.getX() - line.getA().getX()) * invRay.getB().getX(); 
	    float tNearY = (rect.getY() - line.getA().getY()) * invRay.getB().getY();    
	    float tFarX = (rect.getX() + rect.getWidth() - line.getA().getX()) * invRay.getB().getX();
	    float tFarY = (rect.getY() + rect.getHeight() - line.getA().getY()) * invRay.getB().getY();	  
	    
	    if (tNearX > tFarX){
	        float tmp = tNearX;
	        tNearX = tFarX;
	        tFarX = tmp;
	    }
		if (tNearY > tFarY){
	        float tmp = tNearY;
	        tNearY = tFarY;
	        tFarY = tmp;
	    }
		
		if(tNearX > tFarY || tNearY > tFarX)
			return false;
	    float tHitNear = Math.max(tNearX, tNearY);
	    float tHitFar = Math.min(tFarX, tFarY);
	    gameObject.setContactTime(tHitNear);
	    if(tHitNear >= 1)return false;
	    if(tHitFar < 0)return false;
	    
	    gameObject.getContactPoint().setX(line.getA().getX() + tHitNear * line.getB().getX());
	    gameObject.getContactPoint().setY(line.getA().getX() + tHitNear * line.getB().getY());
	    
	    if (tNearX > tNearY){
	        if (invRay.getB().getX() < 0){
	        	gameObject.getContactNormal().setX(1);
	        	gameObject.getContactNormal().setY(0);
	        }else{
	        	gameObject.getContactNormal().setX(-1);
	        	gameObject.getContactNormal().setY(0);
	        }
	    }else if (tNearX < tNearY){
	        if (invRay.getB().getY() < 0){
	        	gameObject.getContactNormal().setX(0);
	        	gameObject.getContactNormal().setY(1);
	        }else{
	        	gameObject.getContactNormal().setX(0);
	        	gameObject.getContactNormal().setY(-1);
	        }
	    }
	    
		if(gameObject.getContactTime() >= 0 && gameObject.getContactTime() < 1) {
			gameObject.getVelocity().setX(gameObject.getVelocity().getX() + gameObject.getContactNormal().getX() * Math.abs(gameObject.getVelocity().getX()) * (1 - gameObject.getContactTime()));
			gameObject.getVelocity().setY(gameObject.getVelocity().getY() + gameObject.getContactNormal().getY() * Math.abs(gameObject.getVelocity().getY()) * (1 - gameObject.getContactTime()));
		}    
		return true;
	}

	public static boolean AABBCollision(Rect r1, Rect r2) {
		return(r1.getX() + r1.getWidth() > r2.getX() && r1.getX() < r2.getX() + r2.getWidth() && 
				r1.getY() + r1.getHeight() > r2.getY() && r1.getY() < r2.getY() + r2.getHeight());
	}
	
	public static boolean AABBCollision(Line l1, Rect r1) {
		float rayDirX = l1.getB().getX() - l1.getA().getX();
		float rayDirY = l1.getB().getY() - l1.getA().getY();
		float invRayX = 1/ rayDirX;
		float invRayY = 1/ rayDirY;
		float leftBottomX = r1.getX(); 
		float leftBottomY = r1.getY() + r1.getHeight();
		float rightTopX = r1.getX() + r1.getWidth();
		float rightTopY = r1.getY();
		float tx1 = (leftBottomX - l1.getA().getX()) * invRayX;
		float tx2 = (rightTopX - l1.getA().getX()) * invRayX;
		float ty1 = (leftBottomY - l1.getA().getY()) * invRayY;
		float ty2 = (rightTopY - l1.getA().getY()) * invRayY;
		
		float tmin = Math.min(tx1, tx2);
	    float tmax = Math.max(tx1, tx2);
	    
	    tmin = Math.max(tmin, Math.min(ty1, ty2));
	    tmax = Math.min(tmax, Math.max(ty1, ty2));

	    return tmax >= tmin;
	}
}
