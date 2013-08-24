package com.ion.ld27.hud;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import com.ion.ld27.Game;

public class GPS {
	public static int[][] screen = new int[50][32];
	
	static int xoffset = 16;
	static int yoffset = Game.height - 216;
	
	static Color bkgrnd = new Color(0x8FA556);
	
	public static void init(){
		for(int n = 0; n < screen.length; n++){
			Arrays.fill(screen[n], 0);
		}
		screen[24][24] = 1;
		screen[24][25] = 1;
		screen[25][24] = 1;
		screen[25][25] = 1;
	}
	
	public static void update(int x, int y, int tx, int ty){
		
	}
	
	public static void draw(Graphics g){
		for(int y = 0; y < screen.length; y++){
			for(int x = 0; x < screen[y].length; x++){
				if(screen[y][x] == 0){
					g.setColor(bkgrnd);
				}
				else{
					g.setColor(Color.black);
				}
				g.fillRect(x*4 + xoffset, y*4 + yoffset, 4, 4);
			}
		}
	}
}
