package com.theships;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Editor extends Grid {
	private Button[] sets;
	private int[] shipcounters;
	private int currentShipToAdd;

	public Editor(View[] rids, boolean isAbstract, View[] sets) {
		super(rids, isAbstract);
		shipcounters = new int[4];
		this.sets = new Button[4];
		for(int i = 0 ; i < 4; i++) {
			final int temp = i + 1;
			this.sets[i] = (Button)sets[i];
			this.sets[i].setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					currentShipToAdd = temp;
				}
			});
		}
	}
	
	
	public Editor(View[] rids, boolean isAbstract) {
		super(rids, isAbstract);
		shipcounters = new int[4];
	}
	
	public void init() {
		
		for(int i = 0; i < 100; i++) {
			
		}
	}
	
	public boolean insertShip(int x, int y, int l, boolean direction) {
		boolean inserted = true;
		for(int i = 0; i < l; i++) {
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
			View[] temp = new View[l];
			int[] temp2 = new int[l];
			for(int i = 0; i < l; i++) {
				if(direction) {
					temp[i] = rids[x*10 + y + i];
					temp2[i] = x*10 + y + i;
					this.matrix[x][y + i] = 1;
				} else {
					temp[i] = rids[y*10 + i*10 + x];
					temp2[i] = y*10 + i*10 + x;
					this.matrix[y + i][x] = 1;
				}
			}
			if(isAbstract)
				ships[shipcounter] = new Ship(l, temp, temp2, true);
			else
				ships[shipcounter] = new Ship(l, temp, temp2);
			shipcounter++;
			shipcounters[l-1]++;
		}
		
		return inserted;
	}

}
