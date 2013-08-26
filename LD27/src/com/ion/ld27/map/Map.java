package com.ion.ld27.map;

import java.awt.Graphics;
import java.util.Random;

import com.ion.ld27.Game;
import com.ion.ld27.entities.mobs.Bear;
import com.ion.ld27.entities.mobs.Rat;
import com.ion.ld27.entities.mobs.Spider;
import com.ion.ld27.entities.mobs.Tiger;
import com.ion.ld27.gfx.Images;

public class Map {

	public static int[][][] mainMap;
	public static int[][][] underMap1;
	public static int[][][] underMap2;
	
	public static boolean isUnderGround = false;
	
	public static Random random = new Random();
	
	public static void load(){
		if(StageManager.stage == 2){
			underMap1 = MapLoader.load(Images.map2);
		}
		else if(StageManager.stage == 4){
			underMap2 = MapLoader.load(Images.map3);
		}
		else{
			mainMap = MapLoader.load(Images.map1);
		}
	}
	
	public static void draw(Graphics g){
		if(StageManager.stage == 2){
			for(int y = 0; y < underMap1[0].length; y++){
				for(int x = 0; x < underMap1[0][y].length; x++){
					if(y*64 - Game.entities.get(0).ypos + Game.height/2 - 32 > -64 && y*64 - Game.entities.get(0).ypos + Game.height/2 - 32 < Game.height){
						if(x*64 - Game.entities.get(0).xpos + Game.width/2 - 32 >  -64 && x*64 - Game.entities.get(0).xpos + Game.width/2 - 32 < Game.width){
							g.drawImage(Images.tiles[underMap1[0][y][x]], x*64 - Game.entities.get(0).xpos + Game.width/2 - 32, y*64 - Game.entities.get(0).ypos + Game.height/2 - 32, null);
						}
					}
				}
			}
		}
		else if(StageManager.stage == 4){
			for(int y = 0; y < underMap2[0].length; y++){
				for(int x = 0; x < underMap2[0][y].length; x++){
					if(y*64 - Game.entities.get(0).ypos + Game.height/2 - 32 > -64 && y*64 - Game.entities.get(0).ypos + Game.height/2 - 32 < Game.height){
						if(x*64 - Game.entities.get(0).xpos + Game.width/2 - 32 >  -64 && x*64 - Game.entities.get(0).xpos + Game.width/2 - 32 < Game.width){
							g.drawImage(Images.tiles[underMap2[0][y][x]], x*64 - Game.entities.get(0).xpos + Game.width/2 - 32, y*64 - Game.entities.get(0).ypos + Game.height/2 - 32, null);
						}
					}
				}
			}
		}
		else{
			for(int y = 0; y < mainMap[0].length; y++){
				for(int x = 0; x < mainMap[0][y].length; x++){
					if(y*64 - Game.entities.get(0).ypos + Game.height/2 - 32 > -64 && y*64 - Game.entities.get(0).ypos + Game.height/2 - 32 < Game.height){
						if(x*64 - Game.entities.get(0).xpos + Game.width/2 - 32 >  -64 && x*64 - Game.entities.get(0).xpos + Game.width/2 - 32 < Game.width){
							g.drawImage(Images.tiles[mainMap[0][y][x]], x*64 - Game.entities.get(0).xpos + Game.width/2 - 32, y*64 - Game.entities.get(0).ypos + Game.height/2 - 32, null);
						}
					}
				}
			}
			for(int y = 0; y < mainMap[1].length; y++){
				for(int x = 0; x < mainMap[1][y].length; x++){
					if(mainMap[1][y][x] != 0){
						if(y*64 - Game.entities.get(0).ypos + Game.height/2 - 32 > -128 && y*64 - Game.entities.get(0).ypos + Game.height/2 - 32 < Game.height){
							if(x*64 - Game.entities.get(0).xpos + Game.width/2 - 32 >  -128 && x*64 - Game.entities.get(0).xpos + Game.width/2 - 32 < Game.width){
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
	
	public static void addEnts(){
		int n0 = 0;//bear
		int n1 = 0;//tiger
		int n3 = 0;//rat
		int n4 = 0;//spider
		if(StageManager.stage == 1 || StageManager.stage == 3 || StageManager.stage == 5){
			n0 = 30;
			n1 = 20;
		}
		else if(StageManager.stage == 2){
			n3 = 10;
			n4 = 10;
		}
		else if(StageManager.stage == 4){
			n3 = 10;
			n4 = 10;
		}
		for(int n = 0; n < n0; n++){
			boolean done = false;
			while(!done){
				int x = 0;
				int y = 0;
				if(StageManager.stage == 1 || StageManager.stage == 3 || StageManager.stage == 5){
					y = random.nextInt(mainMap[0].length);
					x = random.nextInt(mainMap[0][0].length);
				}
				else if(StageManager.stage == 2){
					y = random.nextInt(underMap1[0].length);
					x = random.nextInt(underMap1[0][0].length);
				}
				else if(StageManager.stage == 4){
					y = random.nextInt(underMap2[0].length);
					x = random.nextInt(underMap2[0][0].length);
				}
				done = true;
				for(int e = 0; e < Game.entities.size(); e++){
					if(Game.entities.get(e).xpos == x*64 && Game.entities.get(e).ypos == y*64){
						done = false;
					}
				}
				if(done){
					Game.entities.add(new Bear(x*64, y*64));
				}
			}
		}
		for(int n = 0; n < n1; n++){
			boolean done = false;
			while(!done){
				int x = 0;
				int y = 0;
				if(StageManager.stage == 1 || StageManager.stage == 3 || StageManager.stage == 5){
					y = random.nextInt(mainMap[0].length);
					x = random.nextInt(mainMap[0][0].length);
				}
				else if(StageManager.stage == 2){
					y = random.nextInt(underMap1[0].length);
					x = random.nextInt(underMap1[0][0].length);
				}
				else if(StageManager.stage == 4){
					y = random.nextInt(underMap2[0].length);
					x = random.nextInt(underMap2[0][0].length);
				}
				done = true;
				for(int e = 0; e < Game.entities.size(); e++){
					if(Game.entities.get(e).xpos == x*64 && Game.entities.get(e).ypos == y*64){
						done = false;
					}
				}
				if(done){
					Game.entities.add(new Tiger(x*64, y*64));
				}
			}
		}
		for(int n = 0; n < n3; n++){
			boolean done = false;
			while(!done){
				int x = 0;
				int y = 0;
				if(StageManager.stage == 1 || StageManager.stage == 3 || StageManager.stage == 5){
					y = random.nextInt(mainMap[0].length);
					x = random.nextInt(mainMap[0][0].length);
				}
				else if(StageManager.stage == 2){
					y = random.nextInt(underMap1[0].length);
					x = random.nextInt(underMap1[0][0].length);
				}
				else if(StageManager.stage == 4){
					y = random.nextInt(underMap2[0].length);
					x = random.nextInt(underMap2[0][0].length);
				}
				done = true;
				for(int e = 0; e < Game.entities.size(); e++){
					if(Game.entities.get(e).xpos == x*64 && Game.entities.get(e).ypos == y*64){
						done = false;
					}
				}
				if(done){
					Game.entities.add(new Rat(x*64, y*64));
				}
			}
		}
		for(int n = 0; n < n4; n++){
			boolean done = false;
			while(!done){
				int x = 0;
				int y = 0;
				if(StageManager.stage == 1 || StageManager.stage == 3 || StageManager.stage == 5){
					y = random.nextInt(mainMap[0].length);
					x = random.nextInt(mainMap[0][0].length);
				}
				else if(StageManager.stage == 2){
					y = random.nextInt(underMap1[0].length);
					x = random.nextInt(underMap1[0][0].length);
				}
				else if(StageManager.stage == 4){
					y = random.nextInt(underMap2[0].length);
					x = random.nextInt(underMap2[0][0].length);
				}
				done = true;
				for(int e = 0; e < Game.entities.size(); e++){
					if(Game.entities.get(e).xpos == x*64 && Game.entities.get(e).ypos == y*64){
						done = false;
					}
				}
				if(done){
					Game.entities.add(new Spider(x*64, y*64));
				}
			}
		}
	}
}
