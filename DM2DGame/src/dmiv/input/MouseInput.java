package dmiv.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInput extends MouseAdapter{

	private static boolean[] buttons = new boolean[8];
	private static boolean[] lastButtons = new boolean[8];
	private static int mouseX = 0;
	private static int mouseY = 0;
	private static int mouseWheel = 0;
	private static boolean drag = false;
	
	public static void update() {
		mouseWheel = 0;
		for (int i = 0; i < buttons.length; i++) {
			lastButtons[i] = buttons[i];
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() < 0 || e.getButton() >= buttons.length)
			return;
		buttons[e.getButton()] = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() < 0 || e.getButton() >= buttons.length)
			return;
		buttons[e.getButton()] = false;
		drag = false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e){
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if(buttons[MouseEvent.BUTTON1])
			drag = true;
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e){
		mouseWheel = e.getWheelRotation();
	}
	
	// GETTERS
	public static int getX() {
		return mouseX;
	}
	
	public static int getY() {
		return mouseY;
	}
	
	public static boolean buttonDown(int code) {
		if(code < 0 || code > buttons.length)
			return false;
		return buttons[code];
	}
	
	public static boolean buttonPressed(int code) {
		if(code < 0 || code > buttons.length)
			return false;
		return buttons[code] && !lastButtons[code];
	}
	
	public static boolean buttonReleased(int code) {
		if(code < 0 || code > buttons.length)
			return false;
		return !buttons[code] && lastButtons[code];
	}
	
	public static boolean isDragging() {
		return drag;
	}
	
	public static int getWheel() {
		return mouseWheel;
	}
}
