package com.tanks.game.game_objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import static com.tanks.game.Configs.cellSizeX;
import static com.tanks.game.Configs.cellSizeY;
import static com.tanks.game.Configs.PLAYER_SPRITE_COLUMNS_NUM;
import static com.tanks.game.Configs.PLAYER_SPRITE_ROWS_NUM;
import static com.tanks.game.Configs.pSizeX;
import static com.tanks.game.Configs.pSizeY;
import static com.tanks.game.Configs.PLAYER_SPRITE_PATH;

public class Player extends Sprite {
	
	protected Vector2 position;
	protected Vector2 velocity;
	
	protected String userName;
	protected Integer healthPoints;
	
	private Sprite[][] sprites;
	
	public Player(){
		Sprite sp = new Sprite(new Texture(PLAYER_SPRITE_PATH));
		sprites = new Sprite[PLAYER_SPRITE_ROWS_NUM][PLAYER_SPRITE_COLUMNS_NUM];
		
		position = new Vector2();
		velocity = new Vector2();
		
		for(int i = 0; i < PLAYER_SPRITE_ROWS_NUM; i++){
			for(int j = 0; j < PLAYER_SPRITE_COLUMNS_NUM; j++){
				Sprite sprite = new Sprite(sp);
				sprite.setRegion(j*pSizeX, i*pSizeY , pSizeX, pSizeY);
				sprite.setSize(cellSizeX, cellSizeY);
			
				sprites[i][j] = sprite;
				
			}
		}
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(Integer healthPoints) {
		this.healthPoints = healthPoints;
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprites[0][0].setPosition(position.x, position.y);
		sprites[0][0].draw(batch);
	}
}
