package com.its0as0.ld38.entity.mob;

import com.its0as0.ld38.entity.Entity;
import com.its0as0.ld38.graphics.Screen;

public abstract class Mob extends Entity {

	protected boolean moving = false;
	protected boolean walking = false;

	protected enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	protected Direction dir;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		if (xa > 0) dir = Direction.LEFT;
		if (xa < 0) dir = Direction.RIGHT;
		if (ya > 0) dir = Direction.UP;
		if (ya < 0) dir = Direction.DOWN;
		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public abstract void update();

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + (c % 2 * 2 + 2) * 5) >> 5;
			int yt = ((y + ya) + (c / 2 * 2 + 4) * 5) >> 5;
			if (level.getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}

	public abstract void render(Screen screen);

}
