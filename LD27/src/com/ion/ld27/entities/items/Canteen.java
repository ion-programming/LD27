package com.ion.ld27.entities.items;

import java.awt.image.BufferedImage;

import com.ion.ld27.entities.Entity;
import com.ion.ld27.gfx.Images;

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
		
		
		
		destroy();
	}
}