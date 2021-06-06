package dmiv.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInput extends KeyAdapter{
	
	private static boolean[] keys = new boolean[180];
	private static boolean[] lastKeys = new boolean[180];
	
	public static void update() {
		for (int i = 0; i < keys.length; i++) {
			lastKeys[i] = keys[i];
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}
	
	public static boolean keyDown(int keyCode) {
		if(keyCode < 0 || keyCode > keys.length)
			return false;
		return keys[keyCode];
	}
	
	public static boolean keyPressed(int keyCode) {
		if(keyCode < 0 || keyCode > keys.length)
			return false;
		return keys[keyCode] && !lastKeys[keyCode];
	}
	
	public static boolean keyReleased(int keyCode) {
		if(keyCode < 0 || keyCode > keys.length)
			return false;
		return !keys[keyCode] && lastKeys[keyCode];
	}
}
