package dmiv.utils.maths;

public class Maths {

	public static float calcDist(float x1, float y1, float x2, float y2) {       
		return (float) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}
	
	public static float clamp(float val, float min, float max) {
	    return Math.max(min, Math.min(max, val));
	}
}
