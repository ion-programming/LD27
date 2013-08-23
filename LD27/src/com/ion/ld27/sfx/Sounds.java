package com.ion.ld27.sfx;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sounds{
	
	public static Media sound;
	static MediaPlayer music;
	
	public static void load(){
		try{
			sound = new Media(Sounds.class.getClassLoader().getResource("res/whynot.mp3").toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void play(Media m){
		new MediaPlayer(m).play();
	}
}
