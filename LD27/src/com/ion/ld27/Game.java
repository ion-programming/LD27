package com.ion.ld27;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javafx.embed.swing.JFXPanel;

import com.ion.ld27.entities.Entity;
import com.ion.ld27.entities.Player;
import com.ion.ld27.gfx.Images;
import com.ion.ld27.gfx.Render;
import com.ion.ld27.gfx.Update;
import com.ion.ld27.input.Keys;
import com.ion.ld27.map.Map;
import com.ion.ld27.sfx.Sounds;


public class Game extends Applet implements Runnable, KeyListener{
		
		private static final long serialVersionUID = 1L;
		
		JFXPanel FX = new JFXPanel();
		
		private Image dbImage;
		private Graphics dbg;
	
		public static int width = 1250;
		public static int height = 750;
		
		
		public static ArrayList<Entity> entities = new ArrayList<Entity>();
		
		public void init(){
			addKeyListener(this);
			setSize(width, height);
			setFocusable(true);
			setBackground(Color.black);
			try {
				Images.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Sounds.load();
			entities.add(new Player(getWidth()/2 - 32, getHeight()/2 - 32));
			Map.load();
		}
		
		
		public void start(){
			Thread th = new Thread(this);
			th.start();
//			Sounds.play(Sounds.sound);
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
		
