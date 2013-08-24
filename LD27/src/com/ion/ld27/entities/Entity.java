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
		g.drawImage(imgs[currentImage], xpos, ypos, null);
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
	
}
