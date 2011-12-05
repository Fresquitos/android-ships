package com.theships;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class TheShipsActivity extends Activity {
	static int currentview = R.layout.main;
	static int stan = 0;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.main);
	}
	
	
	/**
	 * £atwy       =  1
	 * Trudny      =  2
	 * Stykaja     = 10
	 * Nie stykaja = 20
	 */
	
	public void koniecgry() {
		AlertDialog.Builder bilder = new AlertDialog.Builder(this);
		bilder.setMessage("Are you sure you want to exit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				TheShipsActivity.this.finish();
			}
		}).setNegativeButton("No", new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});
		AlertDialog alert = bilder.create();
		alert.show();
	}

	public void main_to_choose(View w) {
		currentview = R.layout.gamerchoose;
		setContentView(currentview);
		
	}

	public void singleplayer_to_difficulty(View w) {
		currentview = R.layout.difficultychoose;
		setContentView(currentview);
	}

	public void statistics(View w) {
		currentview = R.layout.statistics;
		setContentView(currentview);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem Item) {
		switch(Item.getItemId()) {
		case R.id.m_koniec :
			koniecgry();
			return true;
		default:
			return super.onOptionsItemSelected(Item);
		}
	}
	
	@Override
	public void onBackPressed() {
		switch(currentview) {
		case R.layout.gamerchoose :
			currentview = R.layout.main;
			setContentView(currentview);
			break;
		case R.layout.difficultychoose :
			currentview = R.layout.gamerchoose;
			setContentView(currentview);
			break;
		case R.layout.statistics :
			currentview = R.layout.main;
			setContentView(currentview);
			break;
		case R.layout.main :
			koniecgry();
			break;
		}
		return;
	}
}
 


/**
Intent myIntent = new Intent(TheShipsActivity.this, BattleShipsGame.class);
TheShipsActivity.this.startActivity(myIntent);
*/