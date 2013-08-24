package com.ion.ld27.gfx;

import java.awt.Graphics;

import com.ion.ld27.hud.GPS;
import com.ion.ld27.hud.HUD;

public class Render {
	
	public static void update(Graphics g){
		HUD.update(g);
		GPS.draw(g);
//		Static.render(g);
	}
}
