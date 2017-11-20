package com.tanks.game.world;
import static com.tanks.game.Configs.BRICK_CODE;
import static com.tanks.game.Configs.WALL_CODE;

public class Wall extends MapObject {
	public Wall() {
		super(WALL_CODE);
		setDestructible(false);
	}

	public Wall(Integer code) {
		super(code);
		setDestructible(false);
	}
}
