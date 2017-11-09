package com.tanks.game.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.tanks.game.TanksApp;

public class HtmlLauncher extends GwtApplication {

	@Override
	public GwtApplicationConfiguration getConfig() {
		GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(1280, 720);
		cfg.alpha = true;
		cfg.useDebugGL = true;
		cfg.stencil = true;
		cfg.antialiasing = true;
		cfg.disableAudio = true;
		this.consoleLog("opening1");
		return cfg;
	}

	@Override
	public ApplicationListener createApplicationListener() {
		this.consoleLog("opening2");
		return new TanksApp();

	}
}