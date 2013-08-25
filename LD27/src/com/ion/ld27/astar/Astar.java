package com.ion.ld27.astar;

import java.util.ArrayList;

import com.ion.ld27.Game;
import com.ion.ld27.map.Map;
import com.ion.ld27.map.StageManager;


public class Astar extends Thread{
	
	public ArrayList<Node> open = new ArrayList<Node>();
	public ArrayList<Node> closed = new ArrayList<Node>();
	public boolean done = false;
	public int gx;
	public int gy;
	public int ci;
	public boolean stop = false;
	public int[] pts = null;
	public ArrayList<Integer> nPath;
	public boolean timeOut = false;
	
	public void run(){
		while(!stop){
			if(pts != null){
				nPath = path(pts[0], pts[1], pts[2], pts[3]);
				pts = null;
			}
			try {
				sleep(20);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public ArrayList<Integer> path(int x1, int y1, int x2, int y2){
		timeOut = false;
		open.clear();
		closed.clear();
		done = false;
		gx = x2;
		gy = y2;
		open.add(new Node(x1, y1, x2, y2, null));
		while(!done && open.size() > 0 && !timeOut){
			ci = 0;
			double f = open.get(ci).f;
			for(int n = 0; n < open.size(); n ++){
				if(open.get(n).f < f){
					ci = n;
				}
			}
			closed.add(open.get(ci));
			if(closed.get(closed.size() - 1).x == gx && closed.get(closed.size() - 1).y == gy){
				done = true;
			}
			open.remove(ci);
			ci = closed.size() - 1;
			check(closed.get(ci).x + 1, closed.get(ci).y);
			check(closed.get(ci).x - 1, closed.get(ci).y);
			check(closed.get(ci).x, closed.get(ci).y + 1);
			check(closed.get(ci).x, closed.get(ci).y - 1);
			if(open.size() <= 0 || ci > 5000){
				timeOut = true;
			}
		}
		return result();
	}
	
	public void check(int x, int y){
		boolean go = true;
		for(int n = 0; n < closed.size(); n++){
			if(closed.get(n).x == x && closed.get(n).y == y){
				go = false;
				if(x == gx && y == gy){
					go = true;
				}
			}
		}
		if(go){
			if(StageManager.stage == 1 || StageManager.stage == 3 || StageManager.stage == 5){
				if(x < 0 || x > Map.mainMap[0][0].length - 1 || y < 0 || y > Map.mainMap[0].length - 1){
					go = false;
					if(x == gx && y == gy){
						go = true;
					}
				}
			}
			else if(StageManager.stage == 2){
				if(x < 0 || x > Map.underMap1[0][0].length - 1 || y < 0 || y > Map.underMap1[0].length - 1){
					go = false;
					if(x == gx && y == gy){
						go = true;
					}
				}
			}
			else{
				if(x < 0 || x > Map.underMap2[0][0].length - 1 || y < 0 || y > Map.underMap2[0].length - 1){
					go = false;
					if(x == gx && y == gy){
						go = true;
					}
				}
			}
		}
		if(go){
			for(int n = 0; n < Game.entities.size(); n++){
				if(x == Game.entities.get(n).xpos/64 && y == Game.entities.get(n).ypos/64){
					go = false;
					if(x == gx && y == gy){
						go = true;
					}
				}
			}
		}
		if(go){
			for(int n = 0; n < open.size(); n++){
				if(open.get(n).x == x && open.get(n).y == y){
					if(closed.get(ci).g + 1 < open.get(n).g){
						open.get(n).g = closed.get(ci).g + 1;
						open.get(n).parent = closed.get(ci);
						open.get(n).f = open.get(n).g + open.get(n).h;
						go = false;
					}
				}
			}
		}
		if(go){
			open.add(new Node(x, y, gx, gy, closed.get(ci)));
		}
	}
	
	public ArrayList<Integer> result(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		double x;
		double y;
		double x1;
		double y1;
		boolean made = false;
		int current = closed.size() - 1;	
		if(closed.size() > 0){
			while(!made && closed.get(current).parent != null){
				x = closed.get(current).x;
				y = closed.get(current).y;
				x1 = closed.get(current).parent.x;
				y1 = closed.get(current).parent.y;
				if(x > x1){
					result.add(0, 1);
				}
				else if(x < x1){
					result.add(0, 3);
				}
				else if(y > y1){
					result.add(0, 2);
				}
				else if(y < y1){
					result.add(0, 4);
				}
				boolean found = false;
				for(int n = 0;!found && n < closed.size(); n++){
					if(closed.get(current).parent.x == closed.get(n).x && closed.get(current).parent.y == closed.get(n).y){
						current = n;
						found = true;
					}
				}
				if(closed.get(current).parent == null){
					made = true;
				}
			}
		}
		
		return result;
	}
}