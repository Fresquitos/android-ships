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
	/*	fields[0].getButton().setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				for(int i = 0; i < getLength(); i++) {
					fields[i].setstate(Field._sink)
				}
			}
		});*/
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void updateState() {
		for(int i = 0; i < this.length; i++) {
			if(fields[i].getstate() != Field._shot) 
				this.isSink = false;
		}
		this.isSink = true;
	}
	
	public boolean getLiveState() {
		return !isSink;
	}
	
	public void setShipState(int bg) {
		for(int i = 0; i < this.length; i++) {
			this.fields[i].setstate(Field._ship);
			this.fields[i].getButton().setBackgroundResource(bg);
		}
	}
	
	public void setShipState() {
		setShipState(R.drawable.regular);
	}
}
