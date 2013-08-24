package com.ion.ld27.gfx;

import java.awt.Graphics;

import com.ion.ld27.hud.GPS;
import com.ion.ld27.hud.HUD;
import com.ion.ld27.map.Map;

public class Render {
	
	public static void update(Graphics g){
		Map.draw(g);
		HUD.update(g);
		GPS.draw(g);
//		Static.render(g);
	}
}
