package com.ion.ld27.entities.items;

import java.awt.image.BufferedImage;

import com.ion.ld27.entities.Entity;
import com.ion.ld27.gfx.Images;
import com.ion.ld27.hud.GPS;
import com.ion.ld27.hud.HUD;
import com.ion.ld27.hud.Journal;
import com.ion.ld27.sfx.SoundManager;
import com.ion.ld27.sfx.Sounds;

public class JournalPage extends Entity{
	public int id;

	public JournalPage(int x, int y, int id){
		this.id = id;
		health = 10;
		healthRange = 10;
		speed = 4;
		imgs = new BufferedImage[] {Images.items[5]};
		currentImage = 0;
		xpos = x;
		ypos = y;
		type = "journalpage";
	}
	
	
	@Override
	public void collideWith(){
		if(id == 1){
			Journal.jo.add(Journal.j1);
			GPS.targetx = 1728;
			GPS.targety = 3200;
			GPS.startFlashing = true;
		}
		else if(id == 2){
			Journal.jo.add(Journal.j2);
		}
		else if(id == 3){
			Journal.jo.add(Journal.j3);
			GPS.targetx = 2176;
			GPS.targety = 2048;
			GPS.startFlashing = true;
		}
		else if(id == 4){
			Journal.jo.add(Journal.j4);
		}
		else if(id == 5){
			Journal.jo.add(Journal.j5);
		}
		else if(id == 6){
			Journal.jo.add(Journal.j6);
			GPS.targetx = 7616;
			GPS.targety = 768;
			GPS.startFlashing = true;
		}
		else if(id == 7){
			Journal.jo.add(Journal.j7);
			GPS.startFlashing = true;
			SoundManager.farBombsPlaying = false;
			SoundManager.music = false;
			Journal.show = true;
			Sounds.play(Sounds.finalBomb);
			Sounds.update();
			Sounds.endGame = true;
			
		}
		Journal.j = Journal.jo.size() - 1;
		HUD.storyText(new String[]{"Journal entry found",  "Press j to open"},new int[]{2, 2}, true);
		
		destroy();
	}
}
