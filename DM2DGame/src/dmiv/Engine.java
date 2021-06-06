package dmiv;

import dmiv.assets.SpriteAssets;
import dmiv.input.KeyboardInput;
import dmiv.input.MouseInput;
import dmiv.input.ResizeWindowInput;
import dmiv.managers.Settings;
import dmiv.managers.Time;
import dmiv.managers.SceneManager;
import dmiv.rendering.Display;
import dmiv.rendering.Renderer;

// TODO: доделать систему инпутов: проверять последние нажатия и отжатия кнопок/клавиш // DONE!
// TODO: исправить рендеринг, не рендерить обьекты вне окна // DONE!
// TODO: доделат статичные gameObject обьекты, убрат тестовый код // DONE!
// TODO: сделать камеру // DONE!
// TODO: добавить всем обьектам энумератор айди // DONE!
// TODO: проверку столкновений как у лонекодер // DONE!
// TODO: проверку окружающих тайлов с персонажем и другими сущностями
// TODO: сделать другие виды столкновений
// TODO: сделать коллайд менеджер, разместить в ворлд менеджер, с доступом ко всем обьектам.
// TODO: сделать ворлд и стэйт менеджеры

public class Engine implements Runnable {
	
	private Thread thread;
	private boolean running = false;
	
	private Display display;
	private KeyboardInput keyInput;
	private MouseInput mouseInput;
	private ResizeWindowInput resizeWindowInput;
	private Renderer renderer;
	private SceneManager worldManager;
	
	public Engine(String title) {
		// INITIALIZE
		SpriteAssets.init();
		this.display = new Display();
		this.display.create(title, Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);
		this.keyInput = new KeyboardInput();
		this.mouseInput = new MouseInput();
		this.resizeWindowInput = new ResizeWindowInput();
		this.display.getCanvas().addKeyListener(keyInput);
		this.display.getCanvas().addMouseListener(mouseInput);
		this.display.getCanvas().addMouseMotionListener(mouseInput);
		this.display.getCanvas().addMouseWheelListener(mouseInput);
		this.display.getCanvas().addComponentListener(resizeWindowInput);
		this.renderer = new Renderer(display.getCanvas());
		this.worldManager = new SceneManager(renderer);
		
		start();
	}
	
	private void update() {
		worldManager.update();
	}
	private void render() {
		worldManager.render();
	}
	
	@Override
	public void run() {
		running = true;	
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				Time.calculateDeltaTime();
				// UPDATE GAME	
				update();
				// UPDATE GAME
				KeyboardInput.update();
				MouseInput.update();
				delta--;
				
				// RENDER GAME
				render();
				// RENDER GAME
				frames++;
			}
			
			
			if(System.currentTimeMillis() - timer > 1000){
				display.getFrame().setTitle("Frames: " + frames + " // Delta: " + Time.getDeltaTime());
				timer += 1000;
				frames = 0;
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		dispose();
		end();
	}
	
	private synchronized void start() {
		thread = new Thread(this);
		thread.run();
	}
	
	private synchronized void end() {
		try {
			thread.join();
			System.exit(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void dispose() {
		renderer.dispose();
	}
	
	public void stop() {
		running = false;
	}
	// GETTERS AND SETTERS
	
}
