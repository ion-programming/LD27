package com.ion.ld27.entities;

import com.ion.ld27.Game;
import com.ion.ld27.gfx.Images;
import com.ion.ld27.input.Keys;

public class Player extends Entity {
	
	public Player(int x, int y){
		health = 10;
		healthRange = 10;
		speed = 4;
		imgs = Images.playerTiles;
		currentImage = 0;
		xpos = x;
		ypos = y;
		type = "player";
	}

	
	@Override
	public void ai(){
		currentImage = 0;
		if(Keys.down && d){
			ypos+= speed;
		}
		if(Keys.up && u){
			ypos-= speed;
		}
		if(Keys.right && r){
			xpos+= speed;
		}
		if(Keys.left && l){
			xpos-= speed;
		}
		r = true;
		l = true;
		u = true;
		d = true;
		for(int n = 0; n < Game.entities.size(); n++){
			if(!Game.entities.get(n).equals(this)){
				check(Game.entities.get(n), true);
			}
		}
	}
}
