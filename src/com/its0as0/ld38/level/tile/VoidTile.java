package com.its0as0.ld38.level.tile;

import com.its0as0.ld38.graphics.Screen;
import com.its0as0.ld38.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}

	public boolean solid() {
		return true;
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 5, y << 5, this);
	}

}
