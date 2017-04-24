package com.its0as0.ld38.entity.mob;

import com.its0as0.ld38.graphics.Screen;
import com.its0as0.ld38.graphics.Sprite;

public class Citizen extends Mob {

	private int anim = 0;
	private int time = 0;
	private int xa = 0, ya = 0;
	public boolean isFriends = false;

	public Citizen(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		sprite = Sprite.player_down_0;
	}

	public void update() {
		time++;
		if (time % (random.nextInt(50) + 30) == 0) {
			xa = random.nextInt(3) - 1;
			ya = random.nextInt(3) - 1;
			if (random.nextInt(5) == 0) {
				xa = 0;
				ya = 0;
			}
		}
		if (anim < 7500) anim++;
		else anim = 0;
		if (ya > 0) {
			dir = Direction.UP;
			sprite = Sprite.player_up_0;
		}
		if (ya < 0) {
			dir = Direction.DOWN;
			sprite = Sprite.player_down_0;
		}
		if (xa > 0) {
			dir = Direction.LEFT;
			sprite = Sprite.player_left_0;
		}
		if (xa < 0) {
			dir = Direction.RIGHT;
			sprite = Sprite.player_right_0;
		}

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}

	public void render(Screen screen) {
		if (dir == Direction.DOWN) {
			sprite = Sprite.player_up_0;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_up_1;
				} else {
					sprite = Sprite.player_up_2;
				}
			}
		}

		if (dir == Direction.UP) {
			sprite = Sprite.player_down_0;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_down_1;
				} else {
					sprite = Sprite.player_down_2;
				}
			}
		}

		if (dir == Direction.LEFT) {
			sprite = Sprite.player_left_0;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_left_1;
				} else {
					sprite = Sprite.player_left_2;
				}
			}
		}

		if (dir == Direction.RIGHT) {
			sprite = Sprite.player_right_0;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_right_1;
				} else {
					sprite = Sprite.player_right_2;
				}
			}
		}

		screen.renderSprite(x, y, sprite, true);
	}

}
