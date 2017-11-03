package com.tanks.game.math;

public class Vector2D {
	private float x, y;

	public Vector2D() {
		setX(0f);
		setY(0f);
	}

	public Vector2D(float x, float y) {
		setX(x);
		setY(y);
	}

	public Vector2D(Vector2D vec) {
		setX(vec.getX());
		setY(vec.getY());
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
