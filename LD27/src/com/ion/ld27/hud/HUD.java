package com.ion.ld27.hud;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.ion.ld27.Game;
import com.ion.ld27.gfx.Images;

public class HUD {
	
	static boolean show = false;
	static int timeLeft = 0;
	static BufferedImage textImg;
	static int h = 4;
	static int w = 10;
	static int th = 32;
	public static int mess = 0;
	static String[] text; 
	static int[] time;
	
	public static void update(Graphics g){
		if(show){
			timeLeft--;
			
			BufferedImage img = new BufferedImage(w * th + th, h * th + th, Images.fontTiles.getType());
			Graphics2D g2 = img.createGraphics();
			g2.drawImage(Images.border[0], 0, 0, null);
			g2.drawImage(Images.border[1], w * th, 0, null);
			g2.drawImage(Images.border[2], 0, h * th, null);
			g2.drawImage(Images.border[3], w * th, h * th, null);
			g2.setColor(new Color(0x637041));
			g2.fillRect(0 + th, 0 + th, w * th - th, h* th - th);
			
			for(int x = 1; x < w; x++){
				g2.drawImage(Images.border[7], x * th, 0, null);
			}
			for(int x = 1; x < w; x++){
				g2.drawImage(Images.border[4], x * th, h * th, null);
			}
			for(int y = 1; y < h; y++){
				g2.drawImage(Images.border[5], 0, y * th, null);	
			}
			for(int y = 1; y < h; y++){
				g2.drawImage(Images.border[6], w * th, y * th, null);	
			}
			
			
			g2.drawImage(textImg, th, th, null);
			
			g.drawImage(img, (Game.width - img.getWidth())/2, 0, null);
			
			if(timeLeft <= 0){
				show = false;
				if(mess >= text.length){
					text = null;
					time = null;
					mess = 0;
				}
				else{
					storyText(text, time, false);
				}
			}
		}
		
		
	}
	
	public static void storyText(String[] txt, int[] tim, boolean n){
		if(n){
			mess = 0;
		}
		text = txt;
		time = tim;
		textImg = DrawString.make(text[mess], text[mess].length(), 1, 0xFFFFFF);
		w = text[mess].length() + 1;
		h = 2;
		timeLeft = time[mess] * 50;
		show = true;
		mess++;
	}
}
