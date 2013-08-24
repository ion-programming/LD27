package com.ion.ld27.sfx;

import com.sun.media.jfxmedia.Media;

public class SoundManager {

	public static boolean farBombsPlaying = false;
	static int minDelay = 5;
	static int maxDelay = 20; 
	static boolean farBomb = false;
	static Media[] farBombsMedia;
	static long time = System.nanoTime() / 1000000000;
	static long lastTime = System.nanoTime() / 1000000000;
	
	public static void update(){
		time = System.nanoTime() / 1000000000;
		if(farBombsPlaying){
			if(farBomb){
				lastTime = System.nanoTime() / 1000000000;
				//play random sound
			}
			
			
		}
	}
}
