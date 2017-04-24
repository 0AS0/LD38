package com.its0as0.ld38.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.its0as0.ld38.Game;
import com.its0as0.ld38.input.InputHandler;

public class AboutMenu extends Menu {

	private String option = "Back";

	public AboutMenu(InputHandler input) {
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
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 35));
		String[] text = { " A Small World is a game created by Andrew Shepherd for Ludum Dare.", //
				" Ludum Dare is a 48 hour game development competition. This game ", //
				" was made in about 15 to 20 hours. Everything was made by me within ", //
				" 48 hours.", //
				"", //
				" This was made for the 38th Ludum Dare compo, which was my first", //
				" entry for Ludum Dare.", //
				" Most of the time when people use the term 'A Small World', they're ", //
				" referring to friends knowing each other, and that's the goal of this", //
				" game. Make as many friends as you can in 5 minutes, and good luck!", //
				"", //
				" Any questions? Tweet me at @Its0AS0", //
				"", //
				" Thanks for playing! :)" };
		for (int i = 0; i < text.length; i++) {
			g.setColor(Color.BLACK);
			g.drawString(text[i], 3, 53 + i * 40);
			g.setColor(Color.WHITE);
			g.drawString(text[i], 1, 50 + i * 40);
		}

		g.setColor(Color.BLACK);
		g.drawString(option, 1077, 698);
		g.setColor(Color.WHITE);
		g.drawString(option, 1075, 695);
	}
}
