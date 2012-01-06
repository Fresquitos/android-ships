package com.theships;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class Player extends Grid {

	public Player(int[] parsedGrid, View[] rids, boolean fake) {
		super(parsedGrid, rids, fake);
	}

	public Player(View[] rids) {
		super(rids);
	}
	
	public void test() {
		String msg = new String();
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++) {
				msg = "i:" + i + " ,j:" + j + " = " + super.matrix[i][j];
				Log.v("Y",msg);
			}
	}
	
	public void init() {
		for(int i = 0; i < super.ships.length; i++) {
			final Ship temp = ships[i];
			for(int j = 0; j < temp.getLength(); j++) {
				final Field temp2 = temp.getField(j);
				temp2.getButton().setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						temp2.getButton().setClickable(false);
						if(temp2.getState() == Field._ship) {
							temp2.setState(Field._shot);
							temp.updateState();
							if(temp.getSinkState())
								for(int j = 0; j < temp.getLength(); j++)
									temp.getField(j).setState(Field._sink);
						}
					}
				});
			}
		}
			
			
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(super.matrix[i][j] == 0) {
					Field temp = new Field(super.rids[i*10 + j], i*10 + j, Field._empty);
				}
			}
		}
	}
	
}
