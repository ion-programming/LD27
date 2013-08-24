package com.ion.ld27.gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.ion.ld27.Game;

public class Static {

	
	static Random r = new Random();
	static int t = 0;
	static int mt = 5;
	
	static int[][] s = new int[Game.height / 4][Game.width / 4];
	
	public static void render(Graphics g){
		t++;
		if(t >= mt){
			t = 0;
			for(int y = 0; y < s.length; y++){
				for(int x = 0; x < s[0].length; x++){
					s[y][x] = r.nextInt(2);
				}
			}
		}
		
		for(int y = 0; y < s.length; y++){
			for(int x = 0; x < s[0].length; x++){
				if(s[y][x] == 0){
					g.setColor(Color.white);
				}
				else{
					g.setColor(Color.black);
				}
				g.fillRect(x*4, y*4, 4, 4);
			}
		}
		
		g.drawImage(Images.end, 0, 0, null);
	}
}
