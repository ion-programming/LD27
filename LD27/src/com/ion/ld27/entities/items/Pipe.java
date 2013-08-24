package com.ion.ld27.entities.items;

import java.awt.image.BufferedImage;

import com.ion.ld27.entities.Entity;
import com.ion.ld27.gfx.Images;

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
		
		
		
		destroy();
	}
}
