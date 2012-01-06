package com.theships;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class Game {
	@SuppressWarnings("unused")
	private Player gracz;
	private AIPlayer pc;
	
	public Game(Player gracz, AIPlayer pc) {
		this.gracz = gracz;
		this.pc = pc;
	}
	
	public void init() {
		pc.randomize();
		Ship[] statki = pc.getShips();
		for(int i = 0; i < statki.length; i++) {
			final Ship statek = statki[i];
			for(int j = 0; j < statek.getLength(); j++) {
				final Field pole = statek.getField(j);
				pole.getButton().setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						pole.getButton().setClickable(false);
						if(pole.getState() == Field._ship){
							pole.setState(Field._shot);
							statek.updateState();
							if(statek.getSinkState()) {
								for(int j = 0; j < statek.getLength(); j++)
									statek.getField(j).setState(Field._sink);
								pc.shipcounter--;
								if(pc.shipcounter == 0) {
									
								}
							}
						}
					}
				});
			}
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(pc.getMatrix()[i][j] == 0)
					new Field(pc.getRids()[i*10 + j], i*10 + j, Field._empty);
			}
		}
	}

	
	public void startGame() {
		
	//	pc.init();
	}
}
