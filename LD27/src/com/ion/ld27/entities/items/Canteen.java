package com.ion.ld27.entities.items;

import java.awt.image.BufferedImage;

import com.ion.ld27.Game;
import com.ion.ld27.entities.Entity;
import com.ion.ld27.gfx.Images;
import com.ion.ld27.hud.GPS;
import com.ion.ld27.hud.HUD;

public class Canteen extends Entity{

	public Canteen(int x, int y){
		health = 10;
		healthRange = 10;
		speed = 4;
		imgs = new BufferedImage[] {Images.items[4]};
		currentImage = 0;
		xpos = x;
		ypos = y;
		type = "canteen";
	}
	
	
	@Override
	public void collideWith(){
		HUD.storyText(new String[]{"Canteen found!", "Your health increases."}, new int[]{2, 2}, true);
		Game.entities.get(0).healthRange+= 2;
		Game.entities.get(0).health+= 2;
		GPS.startFlashing = true;
		destroy();
	}
}
