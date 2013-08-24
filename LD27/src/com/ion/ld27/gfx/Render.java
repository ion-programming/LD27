package com.ion.ld27.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.ion.ld27.Game;
import com.ion.ld27.hud.GPS;
import com.ion.ld27.hud.HUD;
import com.ion.ld27.hud.Journal;
import com.ion.ld27.hud.TopBar;
import com.ion.ld27.map.Map;
import com.ion.ld27.map.StageManager;

public class Render {
	
	public static void update(Graphics g){
		if(StageManager.end){
			Static.render(g);
		}
		else{
			Map.draw(g);
			for(int n = 0; n < Game.entities.size(); n++){
				Game.entities.get(n).draw(g);
			}
			
			if(Map.isUnderGround){
				if(StageManager.hasLantern){
					g.drawImage(Images.dark, 0, 0, null);
				}
				else{
					g.setColor(new Color(0, 0, 0, 250));
					g.fillRect(0, 0, Game.width, Game.height);
				}
				GPS.stat = true;
			}
			else{
				GPS.stat = false;
			}
			TopBar.update(g);
			HUD.update(g);
			GPS.draw(g);
			Journal.render(g);
		}
	}
}
