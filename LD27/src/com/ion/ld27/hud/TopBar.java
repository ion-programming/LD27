package com.ion.ld27.hud;

import java.awt.Color;
import java.awt.Graphics;

import com.ion.ld27.Game;

public class TopBar {

	public static void update(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.width, 35);
		
		int gn;
		int h = 25;
		int WIDTH = 400;
		int s = Game.width / 2 - WIDTH / 2;
		
		gn = (WIDTH /Game.entities.get(0).healthRange) * Game.entities.get(0).health;
		
		g.setColor(new Color(0x00FF00));
		g.fillRect(s, 5, gn, h);
		g.setColor(new Color(0xFF0000));
		g.fillRect(s+gn, 5, WIDTH - gn, h);
		g.setColor(new Color(0x63004C));
		g.drawRect(s - 1, 4, WIDTH + 1, h + 1);
	}
}
