package com.ion.ld27.entities.items;

import java.awt.image.BufferedImage;

import com.ion.ld27.entities.Entity;
import com.ion.ld27.gfx.Images;
import com.ion.ld27.hud.HUD;

public class Pipe extends Entity{

	public Pipe(int x, int y){
		health = 10;
		healthRange = 10;
		speed = 4;
		imgs = new BufferedImage[] {Images.items[2]};
		currentImage = 0;
		xpos = x;
		ypos = y;
		type = "pipe";
	}
	
	
	@Override
	public void collideWith(){
		HUD.storyText(new String[]{"Pipe found!"}, new int[]{2}, true);
		
		destroy();
	}
}
