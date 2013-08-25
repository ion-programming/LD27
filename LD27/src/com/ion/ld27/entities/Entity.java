package com.ion.ld27.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ion.ld27.Game;
import com.ion.ld27.entities.items.CavePortal;
import com.ion.ld27.entities.mobs.Bear;
import com.ion.ld27.entities.mobs.Rat;
import com.ion.ld27.entities.mobs.Spider;
import com.ion.ld27.entities.mobs.Tiger;

public class Entity {

	public static int baseHealth = 0;
	public static int baseAttack = 0;
	public int attack;
	public int speed = 4;
	public int xpos;
	public int ypos;
	public int health;
	public int healthRange;
	public String type;
	public BufferedImage[] imgs;
	public int currentImage;
	public int timer = 0;
	public int tick = 0;
	public boolean newPath = false;
	public int punch = 0;
	public int canPunch = 0;;
	
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
		timer++;
		if(timer > 10){
			timer = 0;
			if(tick > 0){
				tick = 0;
			}
			else{
				tick++;
			}
		}
		ai();
	}
	
	public void ai(){
		
	}
	
	public void destroy(){
		int e = Game.entities.indexOf(this);
		Game.entities.remove(e);
	}
	public void collideWith(){
		
	}
	
	public void check(Entity ent, boolean isPlayer){
		boolean hit = false;
		boolean nd = true;
		boolean nu = true;
		boolean nr = true;
		boolean nl = true;
		boolean inx = false;
		boolean iny = false;
		if(punch > 0){
			punch--;
		}
		if(isPlayer && ent.getClass() == Rat.class){
			if(Math.abs(xpos - ent.xpos) + Math.abs(ypos - ent.ypos) <= 256){
				ent.newPath = true;
			}
			if(ent.canPunch == 0){
				if(Math.abs(xpos - ent.xpos) + Math.abs(ypos - ent.ypos) <= 64){
					ent.punch();
				}
			}
		}
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
		if(isPlayer){
			if(hit && ent.getClass() == CavePortal.class){
				nd = true;
				nu = true;
				nr = true;
				nl = true;
				int e = Game.entities.indexOf(ent);
				int d = Math.abs(Game.entities.get(e).xpos - xpos) + Math.abs(Game.entities.get(e).ypos - ypos);
				if(d < 8){
					//go through entrance
				}
			}
		}
		if(hit && punch == 1 && (ent.getClass() == Rat.class || ent.getClass() == Player.class || ent.getClass() == Bear.class || ent.getClass() == Spider.class || ent.getClass() == Tiger.class)){
			if(!nd && (currentImage == 0 || currentImage == 1)){
				ent.hurt(attack);
			}
			else if(!nu && (currentImage == 6 || currentImage == 7)){
				ent.hurt(attack);
			}
			else if(!nl && (currentImage == 2 || currentImage == 3)){
				ent.hurt(attack);
			}
			else if(!nr && (currentImage == 4 || currentImage == 5)){
				ent.hurt(attack);
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
		if(isPlayer){
			if(hit){
				ent.collideWith();
			}
		}
	}
	public void punch(){
		punch = 5;
		canPunch = 25;
	}
	public void hurt(int strength){
		health-= strength;
	}
}
