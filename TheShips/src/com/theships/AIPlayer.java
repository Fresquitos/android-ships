package com.theships;

import java.util.Random;

import android.view.View;

public class AIPlayer extends Player {
	private int[][] shots = new int[10][10];
	public static final int _easy = 0;
	public static final int _hard = 1;
	
	public AIPlayer(int[] parsedGrid, View[] rids, boolean fake) {
		super(parsedGrid, rids, fake);
	}

	public AIPlayer(View[] views2) {
		super(views2);
	}
	
	public void makeMove(Player p, int mode) {
		int x, y;
		if(mode == _easy) {
			do {
				x = new Random().nextInt(10);
				y = new Random().nextInt(10);
			} while(shots[x][y] == 1);
			shots[x][y] = 1;
			if(p.getMatrix()[x][y] == 0) 
				new Field(p.getRids()[x*10 + y], x*10 + y, Field._missed);
			if(p.getMatrix()[x][y] == 1) {
				for(int i = 0; i < 10; i++) {
					Ship statek = p.getShips()[i];
					for(int j = 0; j < statek.getLength(); j++) {
						if(statek.getField(j).getnr() == x*10 + y) {
							statek.getField(j).setState(Field._shot);
							statek.updateState();
							if(statek.getSinkState()) {
								for(int k = 0; k < statek.getLength(); k++) 
									statek.getField(k).setState(Field._sink);
								p.shipcounter--;
								if(p.shipcounter == 0) {
									
								}
							}
						}
					}
				}
			}
		}
		if(mode == _hard) {
			
		}
	}
	
}
