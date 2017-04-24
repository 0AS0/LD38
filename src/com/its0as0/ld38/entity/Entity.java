package com.its0as0.ld38.entity;

import java.util.Random;

import com.its0as0.ld38.graphics.Screen;
import com.its0as0.ld38.graphics.Sprite;
import com.its0as0.ld38.level.Level;

public abstract class Entity {

	public int x, y;
	public Sprite sprite;
	public boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	public void update() {
	}

	public void render(Screen screen) {
		if (sprite != null) screen.renderSprite(x, y, sprite, true);
	}

	public void init(Level level) {
		this.level = level;
	}

	public Sprite getSprite() {
		return sprite;
	}

}
