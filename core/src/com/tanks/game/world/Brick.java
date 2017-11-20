package com.tanks.game.world;
import static com.tanks.game.Configs.BRICK_CODE;
import static com.tanks.game.Configs.WALL_CODE;

public class Brick extends MapObject {
	public Brick() {
		super(BRICK_CODE);
		setDestructible(true);
	}

	public Brick(Integer code) {
		super(code);
		setDestructible(true);
	}
}
