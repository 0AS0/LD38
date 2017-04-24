package com.its0as0.ld38.graphics;

import java.util.Random;

import com.its0as0.ld38.level.tile.Tile;

public class Screen {

	public int width, height;
	public int[] pixels;
	public final int TILE_SIZE = 32;
	public final int TILE_SIZE_MASK = TILE_SIZE - 1;
	public int xOffset, yOffset;
	public final int[] tiles;
	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		tiles = new int[TILE_SIZE * TILE_SIZE];

		for (int i = 0; i < tiles.length; i++)
			tiles[i] = random.nextInt(0xffffff);
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0;
	}

	public void render(int xOffset, int yOffset) {
		for (int y = 0; y < height; y++) {
			int yy = y - yOffset;
			if (yy >= height || yy < 0) break;
			for (int x = 0; x < width; x++) {
				int xx = x - xOffset;
				if (xx >= width || xx < 0) break;
				pixels[xx + yy * width] = Sprite.grass.pixels[(x & TILE_SIZE_MASK) + (y & TILE_SIZE_MASK) * Sprite.grass.SIZE];
			}
		}
	}

	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		if (fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = tile.sprite.pixels[x + y * tile.sprite.SIZE];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			int ys = y;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				int xs = 31 - x;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * 32];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

}
