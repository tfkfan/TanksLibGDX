package com.tanks.game.world;
import static com.tanks.game.Configs.EMPTY_CODE;

public class EmptyCell extends MapObject {
	public EmptyCell() {
		super(EMPTY_CODE);
		setDestructible(false);
	}

	public EmptyCell(Integer code) {
		super(code);
		setDestructible(false);
	}
}
