package com.its0as0.ld38.sound;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {

	public static final Sound menu_select = new Sound("/sound/menu_select.wav");

	private AudioClip sound;

	public Sound(String name) {
		sound = Applet.newAudioClip(Sound.class.getResource(name));
	}

	public void play(boolean loop) {
		if (loop) sound.loop();
		else sound.play();
	}

	public void stop() {
		sound.stop();
	}

	public static void stopAll() {
		menu_select.stop();
	}

}
