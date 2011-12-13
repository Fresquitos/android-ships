package com.theships;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Field {
	private int nr;
	private int state;
	private Button button;
	
	public static final int _empty = 0;
	public static final int _ship = 1;
	public static final int _missed = 2;
	public static final int _shot = 3;
	public static final int _sink = 4;
	
	public Button getButton() {
		return this.button;
	}
	
	public Field(View v, int nr, int state) {
		this.nr = nr;
		setButton(v);
		setstate(state);
	}
	
	public Field(View v, int nr) {
		setButton(v);
		this.nr = nr;
		setstate(Field._empty);
	}
	
	public void setButton(View v) {
		this.button = (Button)v;
		this.button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(getstate()==Field._empty) {
					setstate(Field._missed);
				}
				if(getstate()==Field._ship) {
					setstate(Field._shot);
				}
			}
		});
	}
	
	public int getstate() {
		return state;
	}
	
	public void setstate(int s) {
		int t = R.drawable.regular;
		this.state = s;
		switch(s) {
		case Field._empty :
			t = R.drawable.regular;
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
		this.button.setBackgroundResource(t);
	}
}
