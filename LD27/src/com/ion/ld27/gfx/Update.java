package com.ion.ld27.gfx;

import com.ion.ld27.Game;
import com.ion.ld27.hud.GPS;



public class Update {
	public static void update(){
		GPS.update(Game.entities.get(0).xpos, Game.entities.get(0).ypos, 0, 0);
		for(int n = 0; n < Game.entities.size(); n++){
			Game.entities.get(n).update();
		}
	}
}
