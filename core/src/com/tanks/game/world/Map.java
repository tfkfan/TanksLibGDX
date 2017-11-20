package com.tanks.game.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import static com.tanks.game.Configs.BRICK_CODE;
import static com.tanks.game.Configs.WALL_CODE;
import static com.tanks.game.Configs.EMPTY_CODE;
import static com.tanks.game.Configs.PPM;

public class Map {
	private MapObject[][] mapLayers;
	private Integer y_size;
	private Integer x_size;
	private SpriteBatch batch;
	private Texture[] textures;
	private final float cx = 100 / PPM;
	private final float cy = 100 / PPM;
	private float width, height;
	

	public Map(SpriteBatch batch, String path) throws Exception {
		x_size = y_size = 0;
		mapLayers = readMap(path);
		init();
		this.batch = batch;
	}

	public MapObject[][] readMap(String path) throws Exception {

		Scanner sc = new Scanner(Gdx.files.internal(path).read());

		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine())
			lines.add(sc.nextLine());

		if (lines.size() == 0 || lines.get(0).length() == 0) {
			sc.close();
			throw new Exception("Incorrect tilemap file '" + path + "'");
		}

		y_size = lines.size();
		x_size = lines.get(0).length();
		width = cx * x_size;
		height = cy * y_size;

		MapObject[][] mObjs = new MapObject[y_size][x_size];

		for (int i = 0; i < y_size; i++) {
			String line = lines.get(i);
			for (int j = 0; j < x_size; j++) {
				char ch = line.charAt(j);
				final Integer code = Integer.parseInt(ch + "");
				MapObject obj;
				switch (code) {
				case BRICK_CODE:
					obj = new Brick();
					break;
				case WALL_CODE:
					obj = new Wall();
					break;
				case EMPTY_CODE:
				default:
					obj = new EmptyCell();
					break;
				}
				mObjs[i][j] = obj;
			}
		}

		sc.close();

		return mObjs;
	}

	public void init() {
		textures = new Texture[2];
		textures[0] = new Texture(Gdx.files.internal("brick.png"));
		textures[1] = new Texture(Gdx.files.internal("wall.jpg"));
	}

	public void render() {
		for (int i = 0; i < y_size; i++) {
			for (int j = 0; j < x_size; j++) {
				MapObject obj = mapLayers[i][j];
				float x = j * cx;
				float y = i * cy;
				
				if(!obj.isActive())
					continue;
				
				if (obj instanceof Brick)
					batch.draw(textures[0], x , y, cx, cy);
				else if (obj instanceof Wall)
					batch.draw(textures[1], x , y, cx, cy);
			}
		}
	}
	
	public void collision(float x, float y) {
		if(x < 0 || x > width || y < 0 || y > height)
			return;
		
		int i = (int)(y/cy);
		int j = (int)(x/cx);
		
		MapObject obj = mapLayers[i][j];
		if(obj.isDestructible())
			obj.setActive(false);
	}

	public MapObject[][] getMapLayers() {
		return mapLayers;
	}
}
