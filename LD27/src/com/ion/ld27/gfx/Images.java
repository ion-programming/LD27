package com.ion.ld27.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ion.ld27.Game;



public class Images {
	
	public static BufferedImage map1;
	public static BufferedImage tileImage;
	public static BufferedImage gps;
	public static BufferedImage[] tiles;
	public static BufferedImage fontTiles;
	public static BufferedImage[] font;
	public static BufferedImage messageBorder;
	public static BufferedImage[] border;
	public static BufferedImage player;
	public static BufferedImage[] playerTiles;
	public static BufferedImage item;
	public static BufferedImage[] items;
	public static BufferedImage end;
	public static BufferedImage dark;
	public static BufferedImage cave;
	public static BufferedImage[] caveTiles;	
	
	public static BufferedImage tiger;
	public static BufferedImage[] tigerTiles;
	public static BufferedImage bear;
	public static BufferedImage[] bearTiles;
	public static BufferedImage rat;
	public static BufferedImage[] ratTiles;
	public static BufferedImage spider;
	public static BufferedImage[] spiderTiles;
	
	public static void load() throws IOException{
		tileImage = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/tiles.png"));
		gps = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/gps.png"));
		tiles = ImageHandler.all(tileImage, 8, 3, 1);
		fontTiles = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/font.png"));
		font = ImageHandler.all(fontTiles, 27, 2, 2);
		messageBorder = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/messageBorder.png"));
		border = ImageHandler.all(messageBorder, 8, 1, 1);
		player = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/player.png"));
		playerTiles = ImageHandler.all(player, 8, 1, 1);
		map1 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/map1.png"));
		dark = ImageHandler.resizeImage(ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dark.png")), Game.width, Game.height);
		item = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/items.png"));
		items = ImageHandler.all(item, 8, 3, 1);
		
		end = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/end.png"));
		end = ImageHandler.resizeImage(end, end.getWidth() * 2, end.getHeight() * 2);
		cave = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/caveTiles.png"));
		caveTiles = ImageHandler.all(cave, 4, 1, 1);
		
		rat = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/rat.png"));
		ratTiles = ImageHandler.all(rat, 8, 1, 1);
		tiger = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/tiger.png"));
		tigerTiles = ImageHandler.all(tiger, 8, 1, 1);
		bear = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/bear.png"));
		bearTiles = ImageHandler.all(bear, 8, 1, 1);
		spider = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/spider.png"));
		spiderTiles = ImageHandler.all(spider, 8, 1, 1);
	}
	
}
