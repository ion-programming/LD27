package com.ion.ld27.entities.items;

import com.ion.ld27.entities.Entity;
import com.ion.ld27.gfx.Images;
import com.ion.ld27.hud.GPS;
import com.ion.ld27.map.StageManager;

public class CavePortal extends Entity{

	public int cavePos = 0; //0 above 1 below
	public int start = 0; //0 start 1 end
	boolean works= true;
	
	public CavePortal(int x, int y, boolean underground, boolean startb, boolean w){

		if(!w){
			works = false;
		}
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
		imgs = Images.caveTiles;
		currentImage = 0;
		xpos = x;
		ypos = y;
		health = 5;
		healthRange = 5;
		type = "cavePortal";
	}
		
	
	@Override
	public void ai(){
		if(cavePos == 0 && start == 0){
			currentImage = 0;
		}
		else if(cavePos == 0 && start == 1){
			currentImage = 1;
		}
		else if(cavePos == 1 && start == 0){
			currentImage = 2;
		}
		else if(cavePos == 1 && start == 1){
			currentImage = 3;
		}
	}
		
	@Override
	public void collideWith(){
		if(works){
			StageManager.initStage(StageManager.stage + 1);
			GPS.startFlashing = true;
		}
			
	}	
}
