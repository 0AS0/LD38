package com.its0as0.ld38.level.tile;

import com.its0as0.ld38.graphics.Screen;
import com.its0as0.ld38.graphics.Sprite;

public class FlowerTile extends Tile {

	public FlowerTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 5, y << 5, this);
	}

}
