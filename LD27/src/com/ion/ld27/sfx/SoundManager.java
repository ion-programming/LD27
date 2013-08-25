package com.ion.ld27.sfx;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.media.Media;

public class SoundManager {
	
	static Random r = new Random();
	public static boolean farBombsPlaying = false;
	static int minDelay = 1;
	static int maxDelay = 5; 
	static boolean farBomb = false;
	static ArrayList<Media> farBombsMedia = new ArrayList<Media>();
	static long time = System.nanoTime() / 1000000000;
	static long lastTime = System.nanoTime() / 1000000000;
	static int rTime = r.nextInt(maxDelay-minDelay)+ minDelay;;
	
	
	public static void update(){
		time = System.nanoTime() / 1000000000;
		if(farBombsPlaying){
			if(farBomb){
				lastTime = System.nanoTime() / 1000000000;
				rTime = r.nextInt(maxDelay-minDelay)+ minDelay;
				//play random sound
				int s = r.nextInt(farBombsMedia.size());
				Sounds.play(farBombsMedia.get(s));
				farBomb = false;
			}
			if(time - lastTime > rTime){
				farBomb = true;
			}
			
		}
	}
}
