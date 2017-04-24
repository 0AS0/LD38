package com.its0as0.ld38;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.its0as0.ld38.entity.mob.Player;
import com.its0as0.ld38.graphics.Image;
import com.its0as0.ld38.graphics.Screen;
import com.its0as0.ld38.input.InputHandler;
import com.its0as0.ld38.level.FirstLevel;
import com.its0as0.ld38.level.Level;
import com.its0as0.ld38.menu.GameOverMenu;
import com.its0as0.ld38.menu.MainMenu;
import com.its0as0.ld38.menu.Menu;
import com.its0as0.ld38.menu.State;
import com.its0as0.ld38.util.Timer;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = -4288657229779115154L;

	public static int width = 1280 / 3;
	public static int height = 720 / 3;
	public static int scale = 3;
	public static String title = "A Small World";

	private boolean running = false;
	private JFrame frame;
	private Thread thread;
	private InputHandler input;
	private Level level;
	private Player player;
	private Timer countdown;

	public static Menu menu;
	public static State state;

	private Image bg_img = new Image();

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private BufferedImage bg_image;

	private Screen screen;

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);

		screen = new Screen(width, height);
		frame = new JFrame(title);
		input = new InputHandler();
		level = Level.first;
		player = new Player(FirstLevel.spawn.getX(), FirstLevel.spawn.getY(), input);
		player.init(level);
		countdown = new Timer(300);

		menu = new MainMenu(input);
		state = State.MENU;

		bg_image = bg_img.loadImage("/textures/menu.png");

		addKeyListener(input);
	}

	private void init() {
		frame.requestFocusInWindow();
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void run() {
		init();
		long lastTime = System.nanoTime();
		double amountOfUpdates = 60.0;
		double ns = 1000000000 / amountOfUpdates;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;

				if (state == State.GAME) {
					countdown.update();
					player.addNewCitizen();
				}
			}
		}
		stop();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		requestFocus();
		input.update();
		if (state == State.MENU || state == State.GAMEOVER) {
			menu.update();
		}

		if (state == State.GAME) {
			if (countdown.seconds <= 0) {
				state = State.GAMEOVER;
				menu = new GameOverMenu(input);
			} else {
				player.update();
				level.update();
			}
		}
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		screen.clear();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		if (state == State.MENU || state == State.GAMEOVER) {
			g.drawImage(bg_image, 0, 0, getWidth(), getHeight(), null);
			menu.render(g);
		}
		if (state == State.GAME) {
			int xScroll = player.x - screen.width / 2;
			int yScroll = player.y - screen.height / 2;
			level.render(xScroll, yScroll, screen);
			player.render(screen);

			g.setFont(new Font("Verdana", 0, 35));
			g.setColor(Color.BLACK);
			g.drawString("Total Friends: " + Player.friends, 12, 42);
			g.drawString("Time Left: " + countdown.seconds, 517, 42);
			g.setColor(Color.WHITE);
			g.drawString("Total Friends: " + Player.friends, 10, 40);
			g.drawString("Time Left: " + countdown.seconds, 515, 40);
		}

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

}
