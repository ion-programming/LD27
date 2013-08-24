package com.ion.ld27.hud;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import com.ion.ld27.Game;

public class GPS {
	public static int[][] screen = new int[50][31];
	
	static int xoffset = 16;
	static int yoffset = Game.height - 216;
	
	static Color bkgrnd = new Color(0x637041);
	
	public static void update(int x, int y, int tx, int ty){
		for(int n = 0; n < screen.length; n++){
			Arrays.fill(screen[n], 0);
		}
		screen[15][15] = 1;
		if((tx != x) || (ty != y)){
			double theta = Math.atan(Math.abs(tx - x)/Math.abs(ty - y));
			int cx = (int)(14*Math.sin(theta));
			int cy = (int)(14*Math.cos(theta));
			if(tx - x < 0){
				cx = -cx;
			}
			if(ty - y < 0){
				cy = -cy;
			}
			screen[cy + 15][cx + 15] = 1;
		}
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
