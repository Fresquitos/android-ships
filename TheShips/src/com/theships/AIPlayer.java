package com.theships;

import android.view.View;

public class AIPlayer extends Player {

	public AIPlayer(int[] parsedGrid, View[] rids, boolean fake) {
		super(parsedGrid, rids, fake);

	}

	public AIPlayer(View[] views2) {
		super(views2);
	}

}
