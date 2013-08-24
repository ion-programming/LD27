package com.ion.ld27.map;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.ion.ld27.Game;
import com.ion.ld27.entities.Solid;


public class MapLoader {
	
	public static int[][] rg = new int[][]{
		new int[]{1, 20, 40, 60},
		new int[]{1, 1, 1, 1, 20, 40, 60, 80}
	};

	public static int[][][] load(BufferedImage mapImage){
		int[][][] map = new int[2][mapImage.getHeight()][mapImage.getWidth()];
		
		for(int y = 0; y < map[0].length; y++){
			for(int x = 0; x < map[0][y].length; x++){
				Color col = new Color(mapImage.getRGB(x, y));
				for(int n = 0; n < rg[0].length; n++){
					if(rg[0][n] == col.getRed()){
						map[0][y][x] = n;
					}
				}
				for(int n = 0; n < rg[1].length; n++){
					if(rg[1][n] == col.getGreen()){
						map[1][y][x] = n;
					}
				}
				if(col.getBlue() == 20){
					Game.entities.add(new Solid(x*64, y*64));
				}
			}
		}
		return map;	
	}
}
