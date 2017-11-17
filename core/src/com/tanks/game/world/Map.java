package com.tanks.game.world;

public class Map {
	private Integer[][] mapLayers;

	public Map() {

	}

	public Map(String path) {
		mapLayers = readMap(path);
	}
	
	public Integer[][] readMap(String path) {
		
	}
	
	public Integer[][] getMapLayers() {
		return mapLayers;
	}
}
