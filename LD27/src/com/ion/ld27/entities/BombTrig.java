package com.ion.ld27.entities;

import java.awt.Graphics;

import com.ion.ld27.sfx.SoundManager;

public class BombTrig extends Entity{
	
	public BombTrig(int x, int y){
		xpos = x;
		ypos = y;
	}
	
	@Override
	public void draw(Graphics g){
	}
	@Override
	public void update(){
	}
	@Override
	public void collideWith(){
		SoundManager.farBombsPlaying = true;
		destroy();
	}
}
