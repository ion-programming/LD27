package com.ion.ld27.gfx;

import java.awt.Graphics;

import com.ion.ld27.hud.GPS;

public class Render {
	
	public static void update(Graphics g){
			
		GPS.draw(g);
//		Static.render(g);
	}
}
