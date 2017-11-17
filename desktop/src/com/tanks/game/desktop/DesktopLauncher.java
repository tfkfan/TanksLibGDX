package com.tanks.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tanks.game.TanksApp;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Tanks 2D";
		cfg.width = 1200;
		cfg.height = 800;
		new LwjglApplication(new TanksApp(), cfg);
	}
}
