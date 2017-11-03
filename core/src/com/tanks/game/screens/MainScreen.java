package com.tanks.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.tanks.game.game_objects.Player;

public class MainScreen implements Screen {
	SpriteBatch batch;
	String title = "TanksLibGDX";
	
	private World world;
	private Box2DDebugRenderer debugRenderer;
	
	Player player;

	float dx = 0;
	@Override
	public void show() {
		batch = new SpriteBatch();
		player = new Player();
		
		
		Gdx.app.log(title, "Hi1!");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		dx += 1;
		player.setPosition(new Vector2(dx, dx));
		batch.begin();
		//DRAWING GAME OBJECTS
		player.draw(batch);

		batch.end();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}
