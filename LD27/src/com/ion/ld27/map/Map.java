package com.ion.ld27.map;

import java.awt.Graphics;

import com.ion.ld27.Game;
import com.ion.ld27.gfx.Images;

public class Map {

	public static int[][][] mainMap;
	public static int[][][] underMap1;
	public static int[][][] underMap2;
	
	public static void load(){
		mainMap = MapLoader.load(Images.map1);
	}
	
	public static void draw(Graphics g){
		for(int y = 0; y < mainMap[0].length; y++){
			for(int x = 0; x < mainMap[0][y].length; x++){
				if(y > Game.entities.get(0).ypos - 64 - Game.height && y < Game.entities.get(0).ypos + 64 + Game.height){
					if(x > Game.entities.get(0).xpos - 64 - Game.width && x < Game.entities.get(0).xpos + 64 + Game.width){
						g.drawImage(Images.tiles[mainMap[0][y][x]], x*64 - Game.entities.get(0).xpos + Game.width/2 - 32, y*64 - Game.entities.get(0).ypos + Game.height/2 - 32, null);
					}
				}
			}
		}
		for(int y = 0; y < mainMap[1].length; y++){
			for(int x = 0; x < mainMap[1][y].length; x++){
				if(mainMap[1][y][x] != 0){
					if(y > Game.entities.get(0).ypos - 128 - Game.height && y < Game.entities.get(0).ypos + 64 + Game.height){
						if(x > Game.entities.get(0).xpos - 128 - Game.width && x < Game.entities.get(0).xpos + 64 + Game.width){
							g.drawImage(Images.tiles[mainMap[1][y][x]], x*64 - Game.entities.get(0).xpos + Game.width/2 - 32, y*64 - Game.entities.get(0).ypos + Game.height/2 - 32, null);
							if(mainMap[1][y][x] == 6){//tree
								g.drawImage(Images.tiles[8], (x + 1)*64 - Game.entities.get(0).xpos + Game.width/2 - 32, y*64 - Game.entities.get(0).ypos + Game.height/2 - 32, null);
								g.drawImage(Images.tiles[9], x*64 - Game.entities.get(0).xpos + Game.width/2 - 32, (y + 1)*64 - Game.entities.get(0).ypos + Game.height/2 - 32, null);
								g.drawImage(Images.tiles[10], (x + 1)*64 - Game.entities.get(0).xpos + Game.width/2 - 32, (y + 1)*64 - Game.entities.get(0).ypos + Game.height/2 - 32, null);
							}
							else if(mainMap[1][y][x] == 7){//rock
								g.drawImage(Images.tiles[11], (x + 1)*64 - Game.entities.get(0).xpos + Game.width/2 - 32, y*64 - Game.entities.get(0).ypos + Game.height/2 - 32, null);
								g.drawImage(Images.tiles[12], x*64 - Game.entities.get(0).xpos + Game.width/2 - 32, (y + 1)*64 - Game.entities.get(0).ypos + Game.height/2 - 32, null);
								g.drawImage(Images.tiles[13], (x + 1)*64 - Game.entities.get(0).xpos + Game.width/2 - 32, (y + 1)*64 - Game.entities.get(0).ypos + Game.height/2 - 32, null);
							}
						}
					}
				}
			}
		}
	}
}
