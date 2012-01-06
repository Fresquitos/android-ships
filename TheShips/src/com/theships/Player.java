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
	
	
}
