package com.tanks.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tanks.game.game_objects.Player;

public class MainScreen implements Screen {
	SpriteBatch batch;
	String title = "TanksLibGDX";
	
	Player player;
	private OrthographicCamera cam;
	private Sprite mapSprite;
	
	Viewport viewport;

	float dx = 0;
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		player = new Player();
		
		mapSprite = new Sprite(new Texture(Gdx.files.internal("world.jpg")));
		mapSprite.setPosition(0, 0);
		mapSprite.setSize(100, 100);


		// Constructs a new OrthographicCamera, using the given viewport width and height
		// Height is multiplied by aspect ratio.
		cam = new OrthographicCamera();
		cam.position.set(0, 0, 0);
		cam.zoom = 2;
	
		viewport = new StretchViewport(10,10,cam);
		viewport.apply();

		Gdx.app.log(title, "Hi1!");
	}

	@Override
	public void render(float delta) {
		handleInput();
		cam.update();
		
		batch.setProjectionMatrix(cam.combined);
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//dx += 1;
		
		batch.begin();
		//DRAWING GAME OBJECTS
		
		mapSprite.draw(batch);
		player.draw(batch);
		batch.end();
		
	}
	
	
	private void handleInput() {
		Float speed = 0.01f;
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
		
		Rectangle r;
		
		/*

		cam.zoom = MathUtils.clamp(cam.zoom, 0.1f, 100/cam.viewportWidth);

		float effectiveViewportWidth = cam.viewportWidth * cam.zoom;
		float effectiveViewportHeight = cam.viewportHeight * cam.zoom;

		cam.position.x = MathUtils.clamp(cam.position.x, -100, 100);
		cam.position.y = MathUtils.clamp(cam.position.y, -100, 100 );
		*/
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width,height,false);
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
