package com.ion.ld27.hud;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.ion.ld27.gfx.ImageHandler;
import com.ion.ld27.gfx.Images;

public class Journal {

	static BufferedImage jback;
	public static ArrayList<BufferedImage> jo = new ArrayList<BufferedImage>();
	public static BufferedImage j1;
	public static BufferedImage j2;
	public static BufferedImage j3;
	public static BufferedImage j4;
	public static BufferedImage j5;
	public static BufferedImage j6;
	public static BufferedImage j7;
	
	public static boolean show = false;
	public static int j = 0;
	
	
	public static void load() throws IOException{
		jback = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/jback.png"));
		jback = ImageHandler.resizeImage(jback, jback.getWidth() * 2, jback.getHeight() * 2);
		j1 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/j1.png"));
		j1 = ImageHandler.resizeImage(j1, j1.getWidth() * 2, j1.getHeight() * 2);
		j2 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/j2.png"));
		j2 = ImageHandler.resizeImage(j2, j2.getWidth() * 2, j2.getHeight() * 2);
		j3 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/j3.png"));
		j3 = ImageHandler.resizeImage(j3, j3.getWidth() * 2, j3.getHeight() * 2);
		j4 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/j4.png"));
		j4 = ImageHandler.resizeImage(j4, j4.getWidth() * 2, j4.getHeight() * 2);
		j5 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/j5.png"));
		j5 = ImageHandler.resizeImage(j5, j5.getWidth() * 2, j5.getHeight() * 2);
		j6 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/j6.png"));
		j6 = ImageHandler.resizeImage(j6, j6.getWidth() * 2, j6.getHeight() * 2);
		j7 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/j7.png"));
		j7 = ImageHandler.resizeImage(j7, j7.getWidth() * 2, j7.getHeight() * 2);
	}
	
	public static void render(Graphics g){
		if(show){
			if(jo.size() > 0){
				g.drawImage(jback, 0, 0, null);
				BufferedImage cur = null;
				cur = jo.get(j);
				g.drawImage(cur, 0, 0, null);
			}
			else{
				show = false;
			}
		}
	}
}
