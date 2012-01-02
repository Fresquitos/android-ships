package com.theships;

import java.util.Random;

import android.view.View;
import android.widget.Button;

public class Grid {
	protected Ship[] ships;
	protected View[] rids;
	protected int[][] matrix;
	protected int shipcounter;
	private boolean ready = false;
	protected boolean isAbstract;
	
	public static final int _free = 0;
	public static final int _used = 1;
	
	public Grid(View[] rids, boolean isAbstract) { 
		this.rids = rids;
		this.matrix = new int[11][11];
		this.ships = new Ship[10];
		this.shipcounter = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++)
				matrix[i][j] = Grid._free;
		}
		this.isAbstract = isAbstract;
	}
	
	
	public Grid(View[] rids) {
		this(rids, false);
	}
	
	
	public Grid() {
		this(null, true);
	}
	
	public Grid(int[] parsedGrid) {
		this.ships = new Ship[10];
		this.matrix = new int[11][11];
		this.shipcounter = 10;
		for(int i = 0; i < 10; i++) 
			ships[i] = new Ship(parsedGrid[i*3], parsedGrid[i*3 + 1], parsedGrid[i*3 +2]);
	}
	
	public Grid(int[] parsedGrid, View[] rids) {
		this.ships = new Ship[10];
		this.shipcounter = 10;
		this.matrix = new int[11][11];
		this.rids = rids;
		this.isAbstract = false;
		for(int i = 0; i < 10; i++) 
			ships[i] = new Ship(parsedGrid[i*3], parsedGrid[i*3 + 1], parsedGrid[i*3 +2], rids);
	}
	
	public Grid(int[] parsedGrid, View[] rids, boolean fake) {
		this.ships = new Ship[10];
		this.shipcounter = 10;
		this.matrix = new int[11][11];
		this.rids = rids;
//		String msg = new String();
		this.isAbstract = true;
		for(int i = 0; i < 10; i++){ 
//			msg = parsedGrid[i*3] + " " + parsedGrid[i*3 + 1] + " " + parsedGrid[i*3 + 2]+ " ";
//			Log.v("Statek "+i, msg);
			ships[i] = new Ship(parsedGrid[i*3], parsedGrid[i*3 + 1], parsedGrid[i*3 +2], rids, true);
		}
	}
	
	public int[] getParsedGrid() {
		int[] temp = new int[30];
		int k = 0;
		for(int i = 0; i < 10; i++) {
			int[] t = this.ships[i].getParsedShip();
			for(int j = 0; j < 3; j++) {
				temp[k++] = t[j];
			}
		}
		return temp;
	}
	
	public void clearGrid() {
		for(int i = 0; i < 100; i++) {
				Button temp = (Button)rids[i];
				temp.setBackgroundResource(R.drawable.button_field);
				temp = null;
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++)
				matrix[i][j] = Grid._free;
		}
		shipcounter = 0;
	}
	
	public int[][] getMatrix() {
		return matrix;
	}
	
	public int getShipCounter() {
		return shipcounter;
	}
	
	public boolean isEmpty(int x, int y) {
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				if(this.matrix[Math.abs(x + i)][Math.abs(y + j)] == Grid._used)
					return false;
			}
		}
		return true;
	}
	
	
	public boolean insertShip(int nr) {
		boolean inserted = false, direction;
		int x, y;
		while(!inserted) {
			direction = new Random().nextBoolean();
			inserted = true;
			x = new Random().nextInt(10);
			y = new Random().nextInt(11 - nr);
			//true - pion, false - poziom
			for(int i = 0; i < nr; i++) {
				if(direction) {
					if(isEmpty(x, y + i) == false) {
						inserted = false;
						break;
					}
				} else {
					if(isEmpty(y + i, x) == false) {
						inserted = false;
						break;
					}
				}
			}
			if(inserted) {
				View[] temp = new View[nr];
				int[] temp2 = new int[nr];
				for(int i = 0; i < nr; i++) {
					if(direction) {
						temp[i] = rids[x + y*10 + i*10];
						temp2[i] = x + y*10 + i*10;
						this.matrix[x][y + i] = 1;
					} else {
						temp[i] = rids[y + i + x*10];
						temp2[i] = y + i + x*10;
						this.matrix[y + i][x] = 1;
					}
				}
				if(isAbstract)
					ships[shipcounter] = new Ship(nr, temp, temp2, true);
				else
					ships[shipcounter] = new Ship(nr, temp, temp2);
				shipcounter++;
			}
		}
		return inserted;
	}
	
	public void randomize() {
		clearGrid();
		for(int i = 4; i > 0; i--) {
			for(int j = i; j < 5; j++)
				insertShip(i);
		}
		this.ready = true;
	}
	
	public boolean isReady() {
		return this.ready; 
	}
	
	
}
