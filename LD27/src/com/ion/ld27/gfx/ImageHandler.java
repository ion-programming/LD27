package com.ion.ld27.gfx;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageHandler {
	
	public static BufferedImage[] all(BufferedImage in, int columns, int rows, int scale){
		
		BufferedImage resized = resizeImage(in, in.getWidth()*scale, in.getHeight()*scale);
		BufferedImage[] out = splitImage(resized, columns, rows, scale);
		return out;
	}
	
	public static BufferedImage[] splitImage(BufferedImage pictures, int columns, int rows, int lineWidth){
		int imgW = (pictures.getWidth()-(columns-1)*lineWidth)/columns;
		int imgH = (pictures.getHeight()-(rows-1)*lineWidth)/rows;
		int imgNum = 0;
		BufferedImage[] pics = new BufferedImage[columns*rows];		
		for(int y=0; y < rows; y++){
			for(int x=0; x < columns; x++){
				pics[imgNum] = new BufferedImage(imgW, imgH, pictures.getType());	
				Graphics2D g = pics[imgNum].createGraphics();  
                g.drawImage(pictures, 0, 0, imgW, imgH, imgW*x+x*lineWidth, imgH*y+y*lineWidth, imgW*x+imgW+x*lineWidth, imgH*y+imgH+y*lineWidth, null);  
                g.dispose(); 
	            imgNum++;  
			}
		}	
		return pics;
	}
	
	public static BufferedImage resizeImage(BufferedImage img, int newW, int newH) {  
        int w = img.getWidth();  
        int h = img.getHeight();  
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());  
        Graphics2D g = dimg.createGraphics();  
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
        g.dispose();  
        return dimg;  
    }
}
