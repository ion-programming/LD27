package com.ion.ld27.sfx;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import com.ion.ld27.map.StageManager;

public class Sounds{
	
	static MediaPlayer music;
	static ArrayList<MediaPlayer> players = new ArrayList<MediaPlayer>();
	public static Media finalBomb;
	public static boolean endGame = false;
	
	public static void load(){
		try{
			finalBomb = new Media(Sounds.class.getClassLoader().getResource("res/finalbomb.mp3").toString());
			SoundManager.farBombsMedia.add(new Media(Sounds.class.getClassLoader().getResource("res/farbomb1.mp3").toString()));
			SoundManager.farBombsMedia.add(new Media(Sounds.class.getClassLoader().getResource("res/farbomb2.mp3").toString()));
			SoundManager.farBombsMedia.add(new Media(Sounds.class.getClassLoader().getResource("res/farbomb3.mp3").toString()));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public static void update(){

		if(endGame && players.size() == 0){
			StageManager.end = true;
		}
	}
	
	public static void play(Media m){
		final MediaPlayer med = new MediaPlayer(m);
		med.play();
		med.setOnEndOfMedia(new Runnable() {

		    @Override
		    public void run() {
		        // do stuff
		       players.remove(med);
		    }
		});
		players.add(med);
	}
	
	public static int getPlayerIndex(Media m){
		int i = -1;
		for(int n = 0; n < players.size(); n++){
			if(players.get(n).getMedia() == m){
				i = n;
				break;
			}
		}
		return i;
	}
	
	public static MediaPlayer getPlayer(Media m){
		MediaPlayer p = null;
		for(int n = 0; n < players.size(); n++){
			if(players.get(n).getMedia() == m){
				p = players.get(n);
				break;
			}
		}
		return p;
	}
}
