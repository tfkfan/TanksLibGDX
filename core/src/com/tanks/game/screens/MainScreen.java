package com.tanks.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tanks.game.game_objects.Player;
import com.tanks.game.world.Map;
import com.tanks.game.world.WorldRenderer;

import static com.tanks.game.Configs.VIEW_WIDTH;
import static com.tanks.game.Configs.VIEW_HEIGHT;
import static com.tanks.game.Configs.PPM;

public class MainScreen implements Screen {
	SpriteBatch batch;
	String title = "TanksLibGDX";

	private Player player;
	private OrthographicCamera cam;
	private Viewport viewport;
	private WorldRenderer worldRenderer;
	private Map map;

	float dx = 0;

	@Override
	public void show() {
		batch = new SpriteBatch();
		player = new Player();
		cam = new OrthographicCamera();
		cam.position.set(0, 0, 0);
		cam.zoom = 2;

		viewport = new StretchViewport(VIEW_WIDTH / PPM, VIEW_HEIGHT / PPM, cam);
		viewport.apply();

		worldRenderer = new WorldRenderer();
		try {
			worldRenderer.initWorld(cam, batch);
			map = worldRenderer.getMap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gdx.app.log(title, "Hi1!");
	}

	@Override
	public void render(float delta) {
		handleInput();
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		map.collision(player.getPosition().x, player.getPosition().y);
		// DRAWING GAME OBJECTS
		batch.begin();
		worldRenderer.render();
		player.draw(batch);
		batch.end();
	}

	private void handleInput() {
		Float speed = 0.1f;
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			cam.zoom += 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			cam.zoom -= 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			cam.translate(-speed, 0, 0);
			player.setPosition(player.getPosition().add(new Vector2(-speed, 0)));
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			cam.translate(speed, 0, 0);
			player.setPosition(player.getPosition().add(new Vector2(speed, 0)));
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			cam.translate(0, -speed, 0);
			player.setPosition(player.getPosition().add(new Vector2(0, -speed)));
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			cam.translate(0, speed, 0);
			player.setPosition(player.getPosition().add(new Vector2(0, speed)));
		}
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
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
