package com.theships;

import android.view.View;
import android.widget.Button;

public class Field {
	private int nr;
	private int state;
	private Button button;
	
	public static final int _empty = 0;
	public static final int _ship = 1;
	public static final int _missed = 2;
	public static final int _shot = 3;
	
	public Field(View v, int nr, int state) {
		this.button = (Button)v;
		this.nr = nr;
		this.state = state;
	}
	
	public Field(View v, int nr) {
		this.button = (Button)v;
		this.nr = nr;
		this.state = _empty;
	}
}
