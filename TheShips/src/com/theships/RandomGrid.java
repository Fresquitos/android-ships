package com.theships;

import java.util.Random;

import android.view.View;
import android.widget.Button;

public class RandomGrid {
	private Ship[] ships;
	private final View[] rids;
	private int[][] matrix;
	private int count;
	
	private static final int _free = 0;
	private static final int _used = 1;
	
	public RandomGrid(View[] rids) { 
		this.rids = rids;
		this.matrix = new int[11][11];
		this.ships = new Ship[10];
		this.count = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++)
				matrix[i][j] = _free;
		}
	}
	
	public void clearGrid() {
		for(int i = 0; i < 100; i++) {
			Button temp = (Button)rids[i];
			temp.setBackgroundResource(R.drawable.regular);
			temp = null;
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++)
				matrix[i][j] = _free;
		}
		count = 0;
	}
	
	public boolean isEmpty(int x, int y) {
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				if(this.matrix[Math.abs(x + i)][Math.abs(y + j)] == RandomGrid._used)
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
				ships[count] = new Ship(nr, temp, temp2, true);
				count++;
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
	}
	
	
}
