package com.its0as0.ld38.level.tile;

import com.its0as0.ld38.graphics.Screen;
import com.its0as0.ld38.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile grass_hill = new GrassHillTile(Sprite.grass_hill);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile stone = new StoneTile(Sprite.stone);
	public static Tile path = new PathTile(Sprite.path);
	public static Tile floor = new FloorTile(Sprite.floor);
	public static Tile stair = new StairTile(Sprite.stair);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public static final int COL_GRASS = 0xff00ff00;
	public static final int COL_GRASS_HILL = 0xff007f00;
	public static final int COL_STONE = 0xff808080;
	public static final int COL_PATH = 0xffffb27f;
	public static final int COL_FLOOR = 0xff7f3300;
	public static final int COL_FLOWER = 0xffffff00;
	public static final int COL_STAIR = 0xffd8d8d8;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public boolean solid() {
		return false;
	}

	public void render(int x, int y, Screen screen) {
	}

}
