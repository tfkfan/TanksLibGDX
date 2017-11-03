package com.tanks.game.game_objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tanks.game.math.Vector2D;
import static com.tanks.game.Configs.cellSizeX;
import static com.tanks.game.Configs.cellSizeY;
import static com.tanks.game.Configs.PLAYER_SPRITE_COLUMNS_NUM;
import static com.tanks.game.Configs.PLAYER_SPRITE_ROWS_NUM;
import static com.tanks.game.Configs.pSizeX;
import static com.tanks.game.Configs.pSizeY;
import static com.tanks.game.Configs.PLAYER_SPRITE_PATH;

public class Player implements GameObject{
	
	protected Vector2D position;
	protected Vector2D velocity;
	
	protected String userName;
	protected Integer healthPoints;
	
	private Sprite[][] sprites;
	
	public Player(){
		Sprite sp = new Sprite(new Texture(PLAYER_SPRITE_PATH));
		sprites = new Sprite[PLAYER_SPRITE_ROWS_NUM][PLAYER_SPRITE_COLUMNS_NUM];
		
		position = new Vector2D();
		velocity = new Vector2D();
		
		for(int i = 0; i < PLAYER_SPRITE_ROWS_NUM; i++){
			for(int j = 0; j < PLAYER_SPRITE_COLUMNS_NUM; j++){
				Sprite sprite = new Sprite(sp);
				sprite.setRegion(j*pSizeX, i*pSizeY , pSizeX, pSizeY);
				sprite.setSize(cellSizeX, cellSizeY);
			
				sprites[i][j] = sprite;
				
			}
		}
	}
	
	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public Vector2D getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2D velocity) {
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
		sprites[0][0].setPosition(position.getX(), position.getY());
		sprites[0][0].draw(batch);
	}
}
