package com.ion.ld27.entities;

import com.ion.ld27.gfx.Images;

public class Player extends Entity {
	
	public Player(int x, int y){
		health = 10;
		healthRange = 10;
		imgs = Images.players;
		currentImage = 0;
		xpos = x;
		ypos = y;
		type = "player";
	}

}
