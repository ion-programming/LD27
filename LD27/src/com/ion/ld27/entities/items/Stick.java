package com.ion.ld27.entities.items;

import java.awt.image.BufferedImage;

import com.ion.ld27.Game;
import com.ion.ld27.entities.Entity;
import com.ion.ld27.gfx.Images;
import com.ion.ld27.hud.GPS;
import com.ion.ld27.hud.HUD;

public class Stick extends Entity{

	public Stick(int x, int y){
		health = 10;
		healthRange = 10;
		speed = 4;
		imgs = new BufferedImage[] {Images.items[1]};
		currentImage = 0;
		xpos = x;
		ypos = y;
		type = "stick";
	}
	
	
	@Override
	public void collideWith(){
		HUD.storyText(new String[]{"Stick found!", "Your attack power increases."}, new int[]{2, 2}, true);
		Game.entities.get(0).attack++;
		GPS.targetx = 1280;
		GPS.targety = 1600;
		GPS.startFlashing = true;
		destroy();
	}
}
