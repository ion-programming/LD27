package com.ion.ld27.hud;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;
import java.util.Random;

import com.ion.ld27.Game;
import com.ion.ld27.gfx.Images;

public class GPS {
	public static int[][] screen = new int[50][31];
	
	static int xoffset = 16;
	static int yoffset = Game.height - 216;
	
	public static Color bkgrnd = new Color(0x637041);
	public static Color bkgrndly = new Color(0xB2AE2B);
	public static Color bkgrndln = new Color(0x637041);
	
	public static int targetx = 0;
	public static int targety = 0;
	
	
	public static boolean stat = false;
	static Random r = new Random();
	
	static Color fr = new Color(0x4C0000);
	static Color fg = new Color(0x004C00);
	
	
	
	public static void update(int x, int y, int tx, int ty){
		for(int n = 0; n < screen.length; n++){
			Arrays.fill(screen[n], 0);
		}
		screen[14][14] = 1;
		screen[14][15] = 1;
		screen[14][16] = 1;
		screen[15][14] = 1;
		screen[15][15] = 1;
		screen[15][16] = 1;
		screen[16][14] = 1;
		screen[16][15] = 1;
		screen[16][16] = 1;
		if((tx != x) || (ty != y)){
			double theta = Math.atan((double)Math.abs(tx - x)/(double)Math.abs(ty - y));
			int cx = (int)(14*Math.sin(theta));
			int cy = (int)(14*Math.cos(theta));
			if(tx - x < 0){
				cx = -cx;
			}
			if(ty - y < 0){
				cy = -cy;
			}
			BufferedImage img = new BufferedImage(31, 31, BufferedImage.TYPE_INT_RGB);
			Graphics g = img.createGraphics();
			g.setColor(Color.black);
			g.drawLine(15, 15, cx + 15, cy + 15);
			g.dispose();
			int[] pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
			int n = 0;
			for(int yp = 0; yp < 31; yp++){
				for(int xp = 0; xp < 31; xp++){
					if(pixels[n] == Color.black.getRGB()){
						screen[yp][xp] = 1;
					}
					n++;
				}
			}
		}
		
		char[] xco = ("" + x).toCharArray();
		char[] yco = ("" + y).toCharArray();
		for(int n = 0; n < xco.length; n++){
			int[][] num;
			if(xco[n] == '0'){
				num = SevenSeg.numbers[0];
			}
			else if(xco[n] == '1'){
				num = SevenSeg.numbers[1];
			}
			else if(xco[n] == '2'){
				num = SevenSeg.numbers[2];		
			}
			else if(xco[n] == '3'){
				num = SevenSeg.numbers[3];
			}
			else if(xco[n] == '4'){
				num = SevenSeg.numbers[4];
			}
			else if(xco[n] == '5'){
				num = SevenSeg.numbers[5];
			}
			else if(xco[n] == '6'){
				num = SevenSeg.numbers[6];
			}
			else if(xco[n] == '7'){
				num = SevenSeg.numbers[7];
			}
			else if(xco[n] == '8'){
				num = SevenSeg.numbers[8];
			}
			else if(xco[n] == '9'){
				num = SevenSeg.numbers[9];
			}
			else{
				num = SevenSeg.numbers[10];
			}
			for(int yp = 0; yp < num.length; yp++){
				for(int xp = 0; xp < num[yp].length; xp++){
					if(num[yp][xp] == 1){
						screen[32 + yp][n*5 + 1 + xp] = 1;
					}
				}
			}
		}
		for(int n = 0; n < yco.length; n++){
			int[][] num;
			if(yco[n] == '0'){
				num = SevenSeg.numbers[0];
			}
			else if(yco[n] == '1'){
				num = SevenSeg.numbers[1];
			}
			else if(yco[n] == '2'){
				num = SevenSeg.numbers[2];		
			}
			else if(yco[n] == '3'){
				num = SevenSeg.numbers[3];
			}
			else if(yco[n] == '4'){
				num = SevenSeg.numbers[4];
			}
			else if(yco[n] == '5'){
				num = SevenSeg.numbers[5];
			}
			else if(yco[n] == '6'){
				num = SevenSeg.numbers[6];
			}
			else if(yco[n] == '7'){
				num = SevenSeg.numbers[7];
			}
			else if(yco[n] == '8'){
				num = SevenSeg.numbers[8];
			}
			else if(yco[n] == '9'){
				num = SevenSeg.numbers[9];
			}
			else{
				num = SevenSeg.numbers[10];
			}
			for(int yp = 0; yp < num.length; yp++){
				for(int xp = 0; xp < num[yp].length; xp++){
					if(num[yp][xp] == 1){
						screen[42 + yp][n*5 + 1 + xp] = 1;
					}
				}
			}
		}
	}
	
	public static boolean startFlashing = false;
	static boolean doingStuff = false;
	static int tl = 2;
	static long startTime;
	
	public static void draw(Graphics g){
		g.drawImage(Images.gps, 3, Game.height - Images.gps.getHeight() - 5, null);
		
		if(startFlashing){
			startFlashing = false;
			startTime = System.nanoTime() / 1000000000;
			doingStuff = true;
		}
		
		long time = System.nanoTime() / 1000000000;
		
		if(doingStuff){
			int a = r.nextInt(2);
			if(a == 0){
				g.setColor(Color.red);
				g.fillOval(125, Game.height - 235, 7, 7);
				
			}
			else{
				g.setColor(Color.green);
				g.fillOval(125, Game.height - 250, 7, 7);
			}
		}
		else{
			g.setColor(fg);
			g.fillOval(125, Game.height - 250, 7, 7);
			g.setColor(fr);
			g.fillOval(125, Game.height - 235, 7, 7);
		}
		

		if(time - startTime > tl && doingStuff){
			doingStuff = false;
		}
		
		
		for(int y = 0; y < screen.length; y++){
			for(int x = 0; x < screen[y].length; x++){
				if(!stat){
					if(screen[y][x] == 0){
						g.setColor(bkgrnd);
					}
					else{
						g.setColor(Color.black);
					}
					g.fillRect(x*4 + xoffset, y*4 + yoffset, 4, 4);
				}
				else{
					int a = r.nextInt(2);
					if(a == 0){
						g.setColor(bkgrnd);
					}
					else{
						g.setColor(Color.black);
					}
					g.fillRect(x*4 + xoffset, y*4 + yoffset, 4, 4);
				}
			}
		}
	}
}
