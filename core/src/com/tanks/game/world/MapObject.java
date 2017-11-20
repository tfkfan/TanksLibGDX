package com.tanks.game.world;

public class MapObject {
	protected Integer code;
	protected boolean isActive;
	protected boolean isDestructible;

	public MapObject() {
		setCode(0);
		setActive(true);
	}

	public MapObject(Integer code) {
		setCode(code);
		setActive(true);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDestructible() {
		return isDestructible;
	}

	public void setDestructible(boolean isDestructible) {
		this.isDestructible = isDestructible;
	}
}
