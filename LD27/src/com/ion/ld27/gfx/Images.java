package com.ion.ld27.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;



public class Images {
	
	public static BufferedImage tileImage;
	public static BufferedImage gps;
	public static BufferedImage[] tiles;
	public static BufferedImage fontTiles;
	public static BufferedImage[] font;
	public static BufferedImage messageBorder;
	public static BufferedImage[] border;
	public static BufferedImage[] player;
	
	public static void load() throws IOException{
		tileImage = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/tiles.png"));
		gps = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/gps.png"));
		tiles = ImageHandler.all(tileImage, 8, 3, 1);
		fontTiles = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/font.png"));
		font = ImageHandler.all(fontTiles, 27, 2, 2);
		messageBorder = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/messageBorder.png"));
		border = ImageHandler.all(messageBorder, 8, 1, 1);
	}
	
}
