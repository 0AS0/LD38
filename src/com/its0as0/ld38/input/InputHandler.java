package com.its0as0.ld38.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	private boolean[] keys = new boolean[65536];
	public boolean up, down, left, right, up_arrow, down_arrow, use, back;

	public void update() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		up_arrow = keys[KeyEvent.VK_UP];
		down_arrow = keys[KeyEvent.VK_DOWN];
		use = keys[KeyEvent.VK_ENTER];
		back = keys[KeyEvent.VK_BACK_SPACE];
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
	}

	public void releaseAll() {
		up = down = left = right = up_arrow = down_arrow = back = false;
	}

}
