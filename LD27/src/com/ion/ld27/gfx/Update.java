package com.ion.ld27.gfx;

import com.ion.ld27.hud.GPS;
import com.ion.ld27.input.Keys;



public class Update {
	static int x = 0;
	static int y = 0;
	public static void update(){
		if(Keys.left){
			x--;
		}
		else if(Keys.right){
			x++;
		}
		if(Keys.up){
			y--;
		}
		else if(Keys.down){
			y++;
		}
		GPS.update(x, y, 0, 0);
	}
}
