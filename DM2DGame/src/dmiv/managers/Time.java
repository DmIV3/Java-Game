package dmiv.managers;

import java.util.Date;

public class Time{
		
	private static float deltaTime = 0.0f;
	private static long lastFrameTime = new Date().getTime();
	
	public static void calculateDeltaTime() {
		deltaTime = (float)(new Date().getTime() - lastFrameTime) / 1000;
		lastFrameTime = new Date().getTime();
	}
	
	public static float getDeltaTime() {
		return deltaTime;
	}
}
