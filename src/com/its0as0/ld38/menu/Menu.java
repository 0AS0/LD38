package com.its0as0.ld38.menu;

import java.awt.Graphics;

import com.its0as0.ld38.input.InputHandler;

public abstract class Menu {

	protected InputHandler input;
	protected int selected = 0;

	public Menu(InputHandler input) {
		this.input = input;
	}

	public abstract void update();

	public abstract void render(Graphics g);

}
