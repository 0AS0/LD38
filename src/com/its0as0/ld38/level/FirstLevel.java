package com.its0as0.ld38.level;

import com.its0as0.ld38.entity.mob.Citizen;
import com.its0as0.ld38.level.tile.Coordinate;

public class FirstLevel extends Level {

	public static Coordinate spawn = new Coordinate(8, 7);

	public FirstLevel() {
		super("/levels/first_level.png");
		add(new Citizen(16, 16));
	}

}
