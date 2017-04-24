package com.its0as0.ld38.level.tile;

public class Coordinate {

	private int x, y;
	private final int TILE_SIZE = 32;

	public Coordinate(int x, int y) {
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int[] xy() {
		int[] r = new int[2];
		r[0] = x;
		r[1] = y;
		return r;
	}

}
