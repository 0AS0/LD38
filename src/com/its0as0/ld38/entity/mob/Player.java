package com.its0as0.ld38.entity.mob;

import com.its0as0.ld38.entity.Entity;
import com.its0as0.ld38.graphics.Screen;
import com.its0as0.ld38.graphics.Sprite;
import com.its0as0.ld38.input.InputHandler;
import com.its0as0.ld38.level.tile.Coordinate;

public class Player extends Mob {

	private InputHandler input;
	private Sprite sprite;
	private int anim = 0;
	private int speed = 1;
	public static int friends;
	private boolean walking = false;

	public Player(int x, int y, InputHandler input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_down_0;
	}

	public void addNewCitizen() {
		for (int i = 0; i < level.entities.size(); i++) {
			Entity e = level.entities.get(i);
			if (e instanceof Citizen) {
				if (((x >> 5) == (e.x >> 5)) || ((y >> 5) == (e.y >> 5)) && ((Citizen) e).isFriends == false) {
					if (x >> 5 - e.x >> 5 <= 10 || y >> 5 - e.y >> 5 <= 10) {
						Coordinate spawn = new Coordinate(8, 7);
						Citizen citizen = new Citizen(spawn.getX(), spawn.getY());
						citizen.x = (x >> 5) + 15 << 4;
						citizen.y = (y >> 5) + 15 << 4;
						level.add(citizen);
						((Citizen) e).isFriends = true;
						friends = level.entities.size() * 2;
					}
				} else return;
			}
		}
	}

	public void update() {
		int xa = 0, ya = 0;
		if (anim < 7500) anim++;
		else anim = 0;
		if (input.up) ya -= speed;
		if (input.down) ya += speed;
		if (input.left) xa -= speed;
		if (input.right) xa += speed;

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
