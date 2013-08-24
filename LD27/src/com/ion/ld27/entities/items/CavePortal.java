package com.ion.ld27.entities.items;

import java.awt.image.BufferedImage;

import com.ion.ld27.entities.Entity;
import com.ion.ld27.gfx.Images;
import com.ion.ld27.map.Map;

public class CavePortal extends Entity{

	public int cavePos = 0; //0 above 1 below
	public int start = 0; //0 start 1 end
	
	public CavePortal(int x, int y, boolean underground, boolean startb){

		if(underground){
			cavePos = 1;
		}
		else{
			cavePos = 0;
		}
		
		if(startb){
			start = 0;
		}
		else{
			start = 1;
		}
		imgs = new BufferedImage[] {Images.caveTiles[0]};
		currentImage = 0;
		xpos = x;
		ypos = y;
		type = "cavePortal";
	}
		
	
	@Override
	public void ai(){
		if(cavePos == 0 && start == 0){
			currentImage = 1;
		}
		else if(cavePos == 0 && start == 1){
			currentImage = 2;
		}
		else if(cavePos == 1 && start == 0){
			currentImage = 3;
		}
		else if(cavePos == 1 && start == 1){
			currentImage = 4;
		}
	}
		
	@Override
	public void collideWith(){
			if(Map.isUnderGround){
				Map.isUnderGround = false;
			}
			else{
				Map.isUnderGround = true;
			}
			
			
	}
}
