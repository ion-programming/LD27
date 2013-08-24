package com.ion.ld27.map;

import java.awt.Color;
import java.awt.image.BufferedImage;


public class MapLoader {

	public static int[][] load(BufferedImage mapImage){
		int[][] map = new int[mapImage.getHeight()][mapImage.getWidth()];
		
		for(int x = 0; x < map.length; x++){
			for(int y = 0; y < map[0].length; y++){
				Color col = new Color(mapImage.getRGB(x, y));
				if(compareColours(col, 0x00FF00)){
					map[y][x] = 1;//grass
				}
				if(compareColours(col, 0xFF0000)){
					map[y][x] = 2;//dirt
				}
				if(compareColours(col, 0x0000FF)){
					map[y][x] = 3;//stone
				}
				if(compareColours(col, 0xFF00FF)){
					map[y][x] = 4;//rocks
				}
				if(compareColours(col, 0xFFFF00)){
					map[y][x] = 5;//leaves
				}
				else{
					map[y][x] = 0;
				}
			}
		}
		return null;	
	}
	
	
	public static boolean compareColours(Color one, int in){
		boolean status = false;
		Color two = new Color(in);
		if(one.getRed() == two.getRed() && one.getGreen() == two.getGreen() && one.getBlue() == two.getBlue()){
			status = true;
		}
		return status;
	}
}
