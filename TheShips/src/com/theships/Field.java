package com.theships;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Field {
	private int nr;
	private int state;
	private Button button = null;
	
	public static final int _empty = 0;
	public static final int _ship = 1;
	public static final int _missed = 2;
	public static final int _shot = 3;
	public static final int _sink = 4;
	
	public Field(View v, int nr, int state) {
		this.nr = nr;
		setButton(v);
		setState(state);
	}
	
	public Field(View v, int nr, boolean fake) {
		this.button = (Button)v;
		this.nr = nr;
		setState(Field._sink);
	}
	
	public Field(int nr, int state) {
		this.nr = nr;
		setState(state);
	}
	
	public void setButton(View v) {
		this.button = (Button)v;
		this.button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(getState()==Field._empty) {
					setState(Field._missed);
					button.setClickable(false);
				}
				if(getState()==Field._ship) {
					setState(Field._shot);
					button.setClickable(false);
				}
			}
		});
	}
	
	public Button getButton() {
		return this.button;
	}
	
	public int getState() {
		return state;
	}
	
	public int getnr() {
		return this.nr;
	}
	
	public void setState(int s) {
		int t = R.drawable.regular;
		this.state = s;
		switch(s) {
		case Field._empty :
			t = R.drawable.button_field;
			break;
		case Field._missed :
			t = R.drawable.pudlo;
			break;
		case Field._shot :
			t = R.drawable.trafiony;
			break;
		case Field._sink :
			t = R.drawable.zatopiony;
			break;
		}
		if(this.button != null)
			this.button.setBackgroundResource(t);
	}
}
