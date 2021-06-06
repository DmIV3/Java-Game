package dmiv.rendering;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dmiv.managers.Settings;
import dmiv.utils.geometry.Circle;
import dmiv.utils.geometry.Line;
import dmiv.utils.geometry.Rect;

public class Renderer {
	
	private Graphics2D g;
	private BufferStrategy bufferStrategy;
	private Canvas canvas;
	private Color color;
	public Renderer(Canvas canvas) {
		this.canvas = canvas;
		this.canvas.createBufferStrategy(2);
		this.bufferStrategy = canvas.getBufferStrategy();
		this.g = (Graphics2D) bufferStrategy.getDrawGraphics();
		this.color = Color.red; 
	}
	
	public void preRender() {
		bufferStrategy = canvas.getBufferStrategy();
		g = (Graphics2D) bufferStrategy.getDrawGraphics();
	}
	
	public void showResult() {
		bufferStrategy.show();
	}
	
	public void drawImage(BufferedImage img, int x, int y, int width, int height) {
		if(x + width < 0 || x > Settings.WINDOW_WIDTH || y + height < 0 || y > Settings.WINDOW_HEIGHT)
			return;
		g.drawImage(img, x, y, width, height, null);
	}
	
	public void drawRect(float x, float y, float width, float height) {
		if(x + width < 0 || x > Settings.WINDOW_WIDTH || y + height < 0 || y > Settings.WINDOW_HEIGHT)
			return;
		g.setColor(color);
		g.drawRect((int)x, (int)y, (int)width, (int)height);
	}
	
	public void drawRect(Rect r1) {
		if(r1.getX() + r1.getWidth() < 0 || r1.getX() > Settings.WINDOW_WIDTH || r1.getY() + r1.getHeight() < 0 || r1.getY() > Settings.WINDOW_HEIGHT)
			return;
		g.setColor(color);
		g.drawRect((int)r1.getX(), (int)r1.getY(), (int)r1.getWidth(), (int)r1.getHeight());
	}
	
	public void drawCircle(float x, float y, float radius) {
		if(x + radius < 0 || x - radius > Settings.WINDOW_WIDTH || y + radius < 0 || y - radius > Settings.WINDOW_HEIGHT)
			return;
		g.setColor(color);
		g.drawOval((int)(x - radius), (int)(y - radius), (int)(radius * 2), (int)(radius * 2));
	}
	
	public void drawCircle(Circle c1) {
		if(c1.getX() + c1.getRadius() < 0 || c1.getX() - c1.getRadius() > Settings.WINDOW_WIDTH || c1.getY() + c1.getRadius() < 0 || c1.getY() - c1.getRadius() > Settings.WINDOW_HEIGHT)
			return;
		g.setColor(color);
		g.drawOval((int)(c1.getX() - c1.getRadius()), (int)(c1.getY() - c1.getRadius()), (int)(c1.getRadius() * 2), (int)(c1.getRadius() * 2));
	}
	
	public void drawLine(float x1, float y1, float x2, float y2) {
		g.setColor(color);
		g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
	}
	
	public void drawLine(Line l1) {
		g.setColor(color);
		g.drawLine((int)l1.getA().getX(), (int)l1.getA().getY(), (int)l1.getB().getX(), (int)l1.getB().getY());
	}
	
	public void setLineWidth(float lineWidth) {
		g.setStroke(new BasicStroke(lineWidth));
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setColor(String hex) {
		this.color = Color.decode(hex);
	}
	
	public void clearScreen() {
		g.setColor(Color.BLACK);
		g.fillRect(0,  0, Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);
	}
	
	public void dispose() {
		g.dispose();		
	}
}
