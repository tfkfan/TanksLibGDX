package com.tanks.game;

import com.badlogic.gdx.Game;
import com.tanks.game.screens.MainScreen;

public class TanksApp extends Game {
	
	public MainScreen mainScreen = new MainScreen();
	
	@Override
	public void create () {
		this.setScreen(mainScreen);

	}
}
