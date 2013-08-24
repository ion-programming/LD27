package com.ion.ld27.input;

import java.awt.event.KeyEvent;

import com.ion.ld27.hud.GPS;
import com.ion.ld27.hud.Journal;

public class Keys {
	
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	
	public static void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W){
			if(!Journal.show){
				up = true;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			if(!Journal.show){
				down = true;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			if(Journal.show){
				if(Journal.j > 0){
					Journal.j--;
				}
			}
			else{
				left = true;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			if(Journal.show){
				if(Journal.j < Journal.jo.size() - 1){
					Journal.j++;
				}
			}
			else{
				right = true;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_Q){
			GPS.startFlashing = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_L){
			if(GPS.bkgrnd.getRGB() == GPS.bkgrndln.getRGB()){
				GPS.bkgrnd = GPS.bkgrndly;
			}
			else{
				GPS.bkgrnd = GPS.bkgrndln;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_J){
			if(Journal.show){
				Journal.show = false;
			}
			else{
				Journal.show = true;
			}
		}
		
	}


	public static void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W){
			up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			right = false;
		}
	
	}


	public static void keyTyped(KeyEvent e) {
		
	}
}
