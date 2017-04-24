package com.its0as0.ld38.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.its0as0.ld38.entity.Entity;
import com.its0as0.ld38.entity.mob.Player;
import com.its0as0.ld38.graphics.Screen;
import com.its0as0.ld38.graphics.SpriteSheet;
import com.its0as0.ld38.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tiles;

	public List<Entity> entities = new ArrayList<Entity>();

	public static Level first = new FirstLevel();

	public Level(String path) {
		loadLevelFromFile(path);
		generateLevel();
	}

	protected void generateLevel() {
	}

	protected void loadLevelFromFile(String path) {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file!");
		}
	}

	public void update() {
		for (Entity e : entities) {
			if (e.removed) entities.remove(e);
			else e.update();
			Player.friends = entities.size();
		}
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 5;
		int x1 = (xScroll + screen.width + 32) >> 5;
		int y0 = yScroll >> 5;
		int y1 = (yScroll + screen.height + 32) >> 5;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}

		for (Entity e : entities) {
			if (e.removed) entities.remove(e);
			e.render(screen);
		}
	}

	public void add(Entity e) {
		e.init(this);
		entities.add(e);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.COL_GRASS) return Tile.grass;
		if (tiles[x + y * width] == Tile.COL_GRASS_HILL) return Tile.grass_hill;
		if (tiles[x + y * width] == Tile.COL_STONE) return Tile.stone;
		if (tiles[x + y * width] == Tile.COL_PATH) return Tile.path;
		if (tiles[x + y * width] == Tile.COL_FLOOR) return Tile.floor;
		if (tiles[x + y * width] == Tile.COL_FLOWER) return Tile.flower;
		if (tiles[x + y * width] == Tile.COL_STAIR) return Tile.stair;
		return Tile.voidTile;
	}

}
