package com.its0as0.ld38.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.its0as0.ld38.Game;
import com.its0as0.ld38.entity.mob.Player;
import com.its0as0.ld38.input.InputHandler;

public class GameOverMenu extends Menu {

	private String option = "Back";

	public GameOverMenu(InputHandler input) {
		super(input);
	}

	public void update() {
		option = "> " + "Back" + " <";
		if (input.back) {
			Game.menu = new MainMenu(input);
		}

		if (input.back) {
			Game.menu = new MainMenu(input);
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Verdana", 0, 75));
		g.drawString("Game Over", 428, 203);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 75));
		g.drawString("Game Over", 425, 200);

		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 35));
		String[] text = { " You made " + Player.friends + " friends!", //
				"", //
				" Tweet your score to @Its0AS0", //
				" Thanks for playing! :)" };
		for (int i = 0; i < text.length; i++) {
			g.setColor(Color.BLACK);
			g.drawString(text[i], 3, 273 + i * 42);
			g.setColor(Color.WHITE);
			g.drawString(text[i], 1, 270 + i * 42);
		}

		g.setColor(Color.BLACK);
		g.drawString(option, 1077, 698);
		g.setColor(Color.WHITE);
		g.drawString(option, 1075, 695);
	}

}
