package com.ion.ld27.astar;


public class Node {
	
	public int x;
	public int y;
	public double f;
	public double g;
	public double h;
	public Node parent;
	
	public Node(int cx, int cy, int gx, int gy, Node p){
		x = cx;
		y = cy;
		if(p != null){
			parent = p;
			g = parent.g + 1;
		}
		h = Math.abs(cx - gx) + Math.abs(cy - gy);
		//h = new Point(cx, cy).distance(new Point(gx, gy));
		f = g + h;
	}
}
