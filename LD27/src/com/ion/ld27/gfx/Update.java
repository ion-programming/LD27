package com.ion.ld27.gfx;

import com.ion.ld27.Game;
import com.ion.ld27.hud.GPS;
import com.ion.ld27.sfx.SoundManager;
import com.ion.ld27.sfx.Sounds;



public class Update {
	public static void update(){
		Sounds.update();
		GPS.update(Game.entities.get(0).xpos, Game.entities.get(0).ypos, GPS.targetx, GPS.targety);
		for(int n = 0; n < Game.entities.size(); n++){
			if(Math.abs(Game.entities.get(n).ypos - Game.entities.get(0).ypos) < 64*30){
				if(Math.abs(Game.entities.get(n).xpos - Game.entities.get(0).xpos) < 64*30){
					Game.entities.get(n).update();
				}
			}
		}
		SoundManager.update();
	}
}
