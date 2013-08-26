package com.ion.ld27.sfx;

import java.util.ArrayList;
import java.util.Random;

import com.ion.ld27.Game;

import javafx.scene.media.Media;

public class SoundManager {
	
	static Random r = new Random();
	public static boolean farBombsPlaying = false;
	static int minDelay = 1;
	static int maxDelay = 5; 
	static boolean farBomb = false;
	static ArrayList<Media> farBombsMedia = new ArrayList<Media>();
	static long time = System.nanoTime() / 1000000000;
	static long startLoop = 0;
	static long lastTime = System.nanoTime() / 1000000000;
	static int rTime = r.nextInt(maxDelay-minDelay)+ minDelay;;
	public static int mode = 0;
	static Random random = new Random();
	public static boolean music = true;
	
	
	public static void update(){
		time = System.nanoTime() / 1000000000;
		if(farBombsPlaying){
			if(farBomb){
				lastTime = System.nanoTime() / 1000000000;
				rTime = r.nextInt(maxDelay-minDelay)+ minDelay;
				int s = r.nextInt(farBombsMedia.size());
				Sounds.play(farBombsMedia.get(s));
				farBomb = false;
			}
			if(time - lastTime > rTime){
				farBomb = true;
			}
		}
		if(music && System.nanoTime() - startLoop > 10000000000l){
			int oldMode = mode;
			mode = random.nextInt(5);
			if(mode == 0){
				Sounds.play(Sounds.loop1);
			}
			else if(mode == 1){
				Sounds.play(Sounds.loop2);
			}
			else if(mode == 2){
				Sounds.play(Sounds.loop3);
			}
			else if(mode == 3){
				Sounds.play(Sounds.loop4);
			}
			else if(mode == 4){
				Sounds.play(Sounds.loop5);
			}
			for(int n = 0; n < Game.entities.size(); n++){
				Game.entities.get(n).newMode(mode, oldMode);
			}
			startLoop = System.nanoTime();
		}
	}
}
