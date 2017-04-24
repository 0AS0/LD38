package com.its0as0.ld38.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite voidSprite = new Sprite(32, 0x1B87E0);
	public static Sprite grass = new Sprite(32, 0, 0, SpriteSheet.tiles);
	public static Sprite grass_hill = new Sprite(32, 1, 0, SpriteSheet.tiles);
	public static Sprite stone = new Sprite(32, 2, 0, SpriteSheet.tiles);
	public static Sprite path = new Sprite(32, 3, 0, SpriteSheet.tiles);
	public static Sprite floor = new Sprite(32, 4, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(32, 5, 0, SpriteSheet.tiles);
	public static Sprite stair = new Sprite(32, 6, 0, SpriteSheet.tiles);

	public static Sprite player_down_0 = new Sprite(32, 0, 0, SpriteSheet.player);
	public static Sprite player_down_1 = new Sprite(32, 0, 1, SpriteSheet.player);
	public static Sprite player_down_2 = new Sprite(32, 0, 2, SpriteSheet.player);
	public static Sprite player_up_0 = new Sprite(32, 1, 0, SpriteSheet.player);
	public static Sprite player_up_1 = new Sprite(32, 1, 1, SpriteSheet.player);
	public static Sprite player_up_2 = new Sprite(32, 1, 2, SpriteSheet.player);
	public static Sprite player_left_0 = new Sprite(32, 3, 0, SpriteSheet.player);
	public static Sprite player_left_1 = new Sprite(32, 3, 1, SpriteSheet.player);
	public static Sprite player_left_2 = new Sprite(32, 3, 2, SpriteSheet.player);
	public static Sprite player_right_0 = new Sprite(32, 2, 0, SpriteSheet.player);
	public static Sprite player_right_1 = new Sprite(32, 2, 1, SpriteSheet.player);
	public static Sprite player_right_2 = new Sprite(32, 2, 2, SpriteSheet.player);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		this.pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {
		this.SIZE = size;
		this.pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < SIZE * SIZE; i++)
			pixels[i] = color;
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
