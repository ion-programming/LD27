package com.ion.ld27.entities.items;

import java.awt.image.BufferedImage;

import com.ion.ld27.entities.Entity;
import com.ion.ld27.gfx.Images;

public class Lantern extends Entity{

	public Lantern(int x, int y){
		health = 10;
		healthRange = 10;
		speed = 4;
		imgs = new BufferedImage[] {Images.items[0]};
		currentImage = 0;
		xpos = x;
		ypos = y;
		type = "lantern";
	}
	
	
	@Override
	public void collideWith(){
		
		
		
		destroy();
	}
}
