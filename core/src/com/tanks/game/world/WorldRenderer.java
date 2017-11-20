package com.tanks.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {

	private OrthographicCamera cam;
	private SpriteBatch batch;
	private Map map;

	public void initWorld(OrthographicCamera cam, SpriteBatch batch) throws Exception {
		this.cam = cam;
		this.batch = batch;
		this.map = new Map(batch, "map.txt");
	}

	public void render() {
		map.render();
	}
	
	public Map getMap() {
		return map;
	}
}
