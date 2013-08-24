package com.ion.ld27.entities.items;

import java.awt.image.BufferedImage;

import com.ion.ld27.entities.Entity;
import com.ion.ld27.gfx.Images;

public class Machete extends Entity{

	public Machete(int x, int y){
		health = 10;
		healthRange = 10;
		speed = 4;
		imgs = new BufferedImage[] {Images.items[3]};
		currentImage = 0;
		xpos = x;
		ypos = y;
		type = "machete";
	}
	
	
	@Override
	public void collideWith(){
		
		
		
		destroy();
	}
}
