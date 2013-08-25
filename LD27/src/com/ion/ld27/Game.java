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

import com.ion.ld27.astar.Astar;
import com.ion.ld27.entities.Entity;
import com.ion.ld27.gfx.Images;
import com.ion.ld27.gfx.Render;
import com.ion.ld27.gfx.Update;
import com.ion.ld27.hud.Journal;
import com.ion.ld27.input.Keys;
import com.ion.ld27.map.StageManager;
import com.ion.ld27.sfx.Sounds;


public class Game extends Applet implements Runnable, KeyListener{
		
		private static final long serialVersionUID = 1L;
		
		JFXPanel FX = new JFXPanel();
		
		private Image dbImage;
		private Graphics dbg;
	
		public static int width = 1248;
		public static int height = 752;
		
		public static Astar astar = new Astar();
		
		static double time;
		double sleepTime;
		static double FPS = 60;
		
		public static ArrayList<Entity> entities = new ArrayList<Entity>();
		
		public void init(){
			addKeyListener(this);
			setSize(width, height);
			setFocusable(true);
			setBackground(Color.black);
			try {
				Images.load();
				Journal.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Sounds.load();
			StageManager.initStage(1);
		}
		
		
		public void start(){
			astar.start();
			Thread th = new Thread(this);
			th.start();
		}
		
		public void run(){
			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
			while(true){
				repaint();
				time = System.nanoTime();
				sleepTime = 1000/FPS - (System.nanoTime() - time)/1000000;
				try{
					if(sleepTime > 10){
						Thread.sleep((long) sleepTime);
					}
					else{
						Thread.sleep(10);
					}
				} 	
				catch(InterruptedException ex){
					ex.printStackTrace();
				}
				System.out.println("FPS: " + (int)(1000/((System.nanoTime() - time)/1000000)));
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
		
		public void stop(){
			astar.stop = true;
		}
}
		
