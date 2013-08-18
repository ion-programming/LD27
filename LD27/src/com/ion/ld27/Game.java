package com.ion.ld27;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.ion.ld27.gfx.Images;
import com.ion.ld27.gfx.Render;
import com.ion.ld27.gfx.Update;
import com.ion.ld27.input.Keys;


public class Game extends Applet implements Runnable, KeyListener{
		
		private static final long serialVersionUID = 1L;
		
		private Image dbImage;
		private Graphics dbg;
	
		public static int width = 512;
		public static int height = 512;
		
		public void init(){
			addKeyListener(this);
			setSize(width, height);
			setFocusable(true);
			setBackground(Color.black);
//			SFX.portal = getAudioClip(getCodeBase(), "res/sounds/activatePortal.au");
			Images.load();
		}
		
		
		public void start(){
			Thread th = new Thread(this);
			th.start();
		}
		
		public void run(){
			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
			while(true){
				repaint();
						
				try{
					Thread.sleep(20);
				} 
				catch(InterruptedException ex){
					ex.printStackTrace();
				}
				Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
			}
		}
		
		public void paint(Graphics g){
			Render.update(g);
		}
		
		public void update (Graphics g){
			if (dbImage == null){
		        dbImage = createImage (this.getSize().width, this.getSize().height);
		        dbg = dbImage.getGraphics ();
		    }
		    dbg.setColor (getBackground ());
		    dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);
		    dbg.setColor (getForeground());	    
		    paint (dbg);
		    g.drawImage (dbImage, 0, 0, this);
		    Update.update();
		}


		@Override
		public void keyPressed(KeyEvent e) {
			Keys.keyPressed(e);			
		}


		@Override
		public void keyReleased(KeyEvent e) {
			Keys.keyReleased(e);		
		}


		@Override
		public void keyTyped(KeyEvent e) {
			Keys.keyTyped(e);
		}
		
}
		
