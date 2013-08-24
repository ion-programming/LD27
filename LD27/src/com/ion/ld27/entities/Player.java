package com.ion.ld27.entities;

import com.ion.ld27.gfx.Images;
import com.ion.ld27.input.Keys;

public class Player extends Entity {
	
	public Player(int x, int y){
		health = 10;
		healthRange = 10;
		imgs = Images.playerTiles;
		currentImage = 0;
		xpos = x;
		ypos = y;
		type = "player";
	}

	
	@Override
	public void ai(){
		currentImage = 0;
		if(Keys.down){
			ypos++;
		}
		if(Keys.up){
			ypos--;
		}
		if(Keys.right){
			xpos++;
		}
		if(Keys.left){
			xpos--;
		}
	}
}
