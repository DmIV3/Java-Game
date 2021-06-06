package dmiv.input;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import dmiv.managers.Settings;

public class ResizeWindowInput extends ComponentAdapter{

	@Override
	public void componentResized(ComponentEvent e) {
		Settings.WINDOW_WIDTH = e.getComponent().getWidth();
		Settings.WINDOW_HEIGHT = e.getComponent().getHeight();
	}

}
