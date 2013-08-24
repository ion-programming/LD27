package com.ion.ld27.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;



public class Images {
	
	public static BufferedImage tileImage;
	public static BufferedImage gps;
	public static BufferedImage[] tiles;
	public static BufferedImage[] player;
	
	public static void load() throws IOException{
		tileImage = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/tiles.png"));
		gps = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/gps.png"));
		tiles = ImageHandler.all(tileImage, 8, 3, 1);

//		youWon = DrawString.make("YOU WON", 7, 3, 0xFFFFFF);

	}
	
}
