package com.theships;

import android.view.View;
import android.view.View.OnClickListener;

public class Ship {
	private Field[] fields;
	private int length;
	private boolean isSink;
	
	public Ship(int l, View[] v, int[] nr) {
		this.length= l;
		this.fields = new Field[this.length];
		for(int i = 0; i < this.length; i++) {
			fields[i] = new Field(v[i], nr[i], Field._ship);
		}
		this.isSink = false;
		for(int i = 0; i < length; i++) {
			final Field temp = fields[i];
			temp.getButton().setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					temp.getButton().setClickable(false);
					if(temp.getState() == Field._ship) {
						temp.setState(Field._shot);
						updateState();
						if(isSink)
							for(int j = 0; j < length; j++)
								fields[j].setState(Field._sink);
					}
				}
			});
		}
	}
	
	public Ship(int l, View[] v, int[] nr, boolean fake) {
		this.length = l;
		this.fields = new Field[this.length];
		for(int i = 0; i < this.length; i++) {
			fields[i] = new Field(v[i], nr[i], true);
		}
		this.isSink = false;
	}
	
	public Ship(int l, int[] nr) {
		this.length = l;
		this.isSink = false;
		this.fields = new Field[this.length];
		for(int i = 0; i < this.length; i++)
			fields[i] = new Field(nr[i], Field._ship);
	}
	
	public Ship(int l, int xs, int xe) {
		this.length = l;
		this.isSink = false;
		this.fields = new Field[this.length];
		for(int i = 0; i < this.length; i++) {
			if(xe - xs == l - 1) 
				fields[i] = new Field(xs + i, Field._ship);
			if(xe - xs == (l - 1)*10)
				fields[i] = new Field(xs + i*10, Field._ship);
		}
	}
	
	public Ship(int l, int xs, int xe, View[] v) {
		this.length = l;
		this.isSink = false;
		this.fields = new Field[this.length];
		for(int i = 0; i < this.length; i++) {
			if(xe - xs == l - 1) 
				fields[i] = new Field(v[xs + i], xs + i, Field._ship);
			if(xe - xs == (l - 1)*10)
				fields[i] = new Field(v[xs + i*10], xs + i*10, Field._ship);
		}
	}
	
	public Ship(int l, int xs, int xe, View[] v, boolean fake) {
		this.length = l;
		this.isSink = false;
		this.fields = new Field[l];
//		String msg = new String();
//		msg = l + " " + xs + " " + xe;
//		Log.v("Ship"+l,msg);
		for(int i = 0; i < l; i++) {
			if(xe - xs == l - 1) {
//				msg = i + " ";
				fields[i] = new Field(v[xs + i], xs + i, true);
//				Log.v("l-1",msg);
			}
			if(xe - xs == (l - 1)*10) {
//				msg = i + " ";
				fields[i] = new Field(v[xs + i*10], xs + i*10, true);
//				Log.v("l-1*10",msg);
			}
		}
	}
	
	public int[] getParsedShip() {
		return new int[]{this.length, this.fields[0].getnr(), this.fields[this.length-1].getnr()};
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void updateState() {
		for(int i = 0; i < this.length; i++) {
			if(fields[i].getState() != Field._shot) { 
				this.isSink = false;
				return;
			}
		}
		this.isSink = true;
	}
	
	public boolean getSinkState() {
		return isSink;
	}
	
	public void setFakeShipState(int bg) {
		for(int i = 0; i < this.length; i++) {
			this.fields[i].getButton().setBackgroundResource(bg);
		}
	}
	
	public void setShipState() {
		for(int i = 0; i < this.length; i++)
			this.fields[i].setState(Field._ship);
	}
	
	public Field getField(int nr) {
		return this.fields[nr];
	}
}
