package com.theships;

import android.view.View;

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
	
	public int getLength() {
		return this.length;
	}
	
	public void updateState() {
		for(int i = 0; i < this.length; i++) {
			if(fields[i].getState() != Field._shot) 
				this.isSink = false;
		}
		this.isSink = true;
	}
	
	public boolean getLiveState() {
		return !isSink;
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
