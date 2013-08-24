package com.ion.ld27.gfx;

import com.ion.ld27.hud.GPS;



public class Update {
	static int x = 1000;
	static int y = 200;
	
	public static void update(){
		GPS.update(0, 0, x, y);
		x+=1;
		y+=1;
	}
}
