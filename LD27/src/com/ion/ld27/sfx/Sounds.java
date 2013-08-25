package com.ion.ld27.sfx;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sounds{
	
	public static Media sound;
	static MediaPlayer music;
	static ArrayList<MediaPlayer> players = new ArrayList<MediaPlayer>();
	
	public static void load(){
		try{
			sound = new Media(Sounds.class.getClassLoader().getResource("res/whynot.mp3").toString());
			SoundManager.farBombsMedia.add(new Media(Sounds.class.getClassLoader().getResource("res/farbomb1.mp3").toString()));
			SoundManager.farBombsMedia.add(new Media(Sounds.class.getClassLoader().getResource("res/farbomb2.mp3").toString()));
			SoundManager.farBombsMedia.add(new Media(Sounds.class.getClassLoader().getResource("res/farbomb3.mp3").toString()));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public static void update(){
		for(int n = 0; n < players.size(); n++){
			if(players.get(n).getStatus() != MediaPlayer.Status.PLAYING && players.get(n).getStatus() != MediaPlayer.Status.PAUSED && players.get(n).getStatus() != MediaPlayer.Status.STALLED){
				players.remove(n);
			}
		}
	}
	
	public static void play(Media m){
		MediaPlayer med = new MediaPlayer(m);
		med.play();
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
