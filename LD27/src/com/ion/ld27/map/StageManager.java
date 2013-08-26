package com.ion.ld27.map;

import com.ion.ld27.Game;
import com.ion.ld27.entities.BombTrig;
import com.ion.ld27.entities.Entity;
import com.ion.ld27.entities.Player;
import com.ion.ld27.entities.items.Canteen;
import com.ion.ld27.entities.items.CavePortal;
import com.ion.ld27.entities.items.JournalPage;
import com.ion.ld27.entities.items.Lantern;
import com.ion.ld27.entities.items.Machete;
import com.ion.ld27.entities.items.Pipe;
import com.ion.ld27.entities.items.Stick;
import com.ion.ld27.entities.mobs.Bear;
import com.ion.ld27.hud.GPS;

public class StageManager {
	public static boolean hasLantern = false;
	public static boolean end = false;
	public static int stage = 1;
	public static void initStage(int newStage){
		if(newStage == 1){
			stage = 1;
			Map.isUnderGround = false;
			Game.entities.clear();
			GPS.targetx = 896;
			GPS.targety = 896;
			Game.entities.add(new Player(768, 640));
			Game.entities.add(new Stick(896, 896));
			Game.entities.add(new JournalPage(1280, 1600, 1));
			Game.entities.add(new Lantern(1728, 3200));
			Game.entities.add(new CavePortal(1728, 4096, false, true, true));
			Game.entities.add(new Bear(900, 640));
			Map.load();
		}
		else if(newStage == 2){
			stage = 2;
			Map.isUnderGround = true;
			Player p = (Player)Game.entities.get(0);
			p.xpos = 1024;
			p.ypos = 3264;
			Game.entities.clear();
			Game.entities.add(p);
			Game.entities.add(new JournalPage(1216, 2432, 2));
			Game.entities.add(new Pipe(1920, 1728));
			Game.entities.add(new CavePortal(1024, 3328, true, false, false));
			Game.entities.add(new CavePortal(1984, 832, true, true, true));
			Map.load();
		}
		else if(newStage == 3){
			stage = 3;
			Entity.baseAttack = 1.5;
			Entity.baseHealth = 1.5;
			Map.isUnderGround = false;
			Player p = (Player)Game.entities.get(0);
			p.xpos = 2048;
			p.ypos = 1152;
			Game.entities.clear();
			Game.entities.add(p);
			GPS.targetx = 2240;
			GPS.targety = 704;
			Game.entities.add(new JournalPage(2240, 704, 3));	
			Game.entities.add(new Machete(2176, 2048));
			Game.entities.add(new CavePortal(2048, 1216, false, false, false));
			Game.entities.add(new CavePortal(5760, 2880, false, true, true));
			Map.load();
		}
		else if(newStage == 4){
			stage = 4;
			Map.isUnderGround = true;
			Player p = (Player)Game.entities.get(0);
			p.xpos = 576;
			p.ypos = 1984;
			Game.entities.clear();
			Game.entities.add(p);
			Game.entities.add(new JournalPage(1024, 1600, 4));	
			Game.entities.add(new Canteen(2368, 1280));	
			Game.entities.add(new JournalPage(3200, 1728, 5));	
			Game.entities.add(new CavePortal(576, 2048, true, false, false));
			Game.entities.add(new CavePortal(3328, 1664, true, true, true));
			Map.load();
		}
		else if(newStage == 5){
			stage = 5;
			Entity.baseAttack = 2;
			Entity.baseHealth = 2;
			Map.isUnderGround = false;
			Player p = (Player)Game.entities.get(0);
			p.xpos = 6912;
			p.ypos = 2880;
			Game.entities.clear();
			Game.entities.add(p);
			GPS.targetx = 11520;
			GPS.targety = 2560;
			Game.entities.add(new JournalPage(11520, 2560, 6));
			Game.entities.add(new JournalPage(7616, 768, 7));
			Game.entities.add(new CavePortal(6912, 2944, false, false, false));
			Game.entities.add(new BombTrig(8512, 2112));

			Map.load();
		}
	}
}
