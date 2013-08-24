package com.ion.ld27.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ion.ld27.Game;

public class Entity {

	public int speed = 4;
	public int xpos;
	public int ypos;
	public int health;
	public int healthRange;
	public String type;
	public BufferedImage[] imgs;
	public int currentImage;
	
	public boolean r = true;
	public boolean l = true;
	public boolean u = true;
	public boolean d = true;
	
	public void draw(Graphics g){
		if(ypos - Game.entities.get(0).ypos + Game.height/2 - 32 > -64 && ypos - Game.entities.get(0).ypos + Game.height/2 - 32 < Game.height){
			if(xpos - Game.entities.get(0).xpos + Game.width/2 - 32 >  -64 && xpos - Game.entities.get(0).xpos + Game.width/2 - 32 < Game.width){
				g.drawImage(imgs[currentImage], xpos - Game.entities.get(0).xpos + Game.width/2 - 32, ypos - Game.entities.get(0).ypos + Game.height/2 - 32, null);
			}
		}
	}
	
	public void update(){
		ai();
	}
	
	public void ai(){
		
	}
	
	public void destroy(){
		int e = Game.entities.indexOf(this);
		Game.entities.remove(e);
	}
	
	public void check(Entity ent, boolean isPlayer){
		boolean hit = false;
		boolean nd = true;
		boolean nu = true;
		boolean nr = true;
		boolean nl = true;
		boolean inx = false;
		boolean iny = false;
		if(Math.abs(xpos - ent.xpos) < 64){
			inx = true;
		}
		if(Math.abs(ypos - ent.ypos) < 64){
			iny = true;
		}
		if(inx){
			if(ypos - ent.ypos + 1 > -64 && ypos - ent.ypos + 1 < 0){
				nd = false;
				hit = true;
			}
			if(ypos - ent.ypos - 1 < 64 && ypos - ent.ypos - 1 > 0){
				nu = false;
				hit = true;
			}
		}
		if(iny){
			if(xpos - ent.xpos + 1 > -64 && xpos - ent.xpos + 1 < 0){
				nr = false;
				hit = true;
			}
			if(xpos - ent.xpos - 1 < 64 && xpos - ent.xpos - 1 > 0){
				nl = false;
				hit = true;
			}
		}
		if(!nd){
			d = false;
		}
		if(!nu){
			u = false;
		}
		if(!nl){
			l = false;
		}
		if(!nr){
			r = false;
		}
	}
}
