package com.theships;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class TheShipsActivity extends Activity {
	static int previousview = 0;
	static int stan = 0;
	
	/** PreviousView stany:
	 * 0 - brak poprzedniego ekranu (wyjscie)
	 * 1 - main
	 * 2 - Gamerchoose
	 * 3 - Difficultychoose
	 */
	/** Stan: 
	 * £atwy       =  1
	 * Trudny      =  2
	 * Stykaja     = 10
	 * Nie stykaja = 20
	 */
	
	public void mysetContentViewMain() {
		setContentView(R.layout.main);
		previousview = 0;
		Button button_start = (Button)findViewById(R.id.buttonstart);
		button_start.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				previousview = 1;
				mysetContentViewGamerchoose();
			}
		});
		Button button_stats = (Button)findViewById(R.id.button_statystyki);
		button_stats.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				previousview = 1;
				setContentView(R.layout.statistics);
			}
		});
	}
	
	public void mysetContentViewGamerchoose() {
		previousview = 1;
		setContentView(R.layout.gamerchoose);
		Button button_single = (Button)findViewById(R.id.button_oneplayer);
		button_single.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				previousview = 2;
				mysetContentViewDifficultychoose();
			}
		});
	}
	
	public void mysetContentViewDifficultychoose() {
		previousview = 2;
		setContentView(R.layout.difficultychoose);
		Button button_easy = (Button)findViewById(R.id.button_easy);
		button_easy.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				previousview = 3;
			}
		});
		Button button_hard = (Button)findViewById(R.id.button_hard);
		button_hard.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				previousview = 3;
			}
		});
	}
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		mysetContentViewMain();

	}
	

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
		switch(previousview) {
		case 1 :
			mysetContentViewMain();
			break;
		case 2 :
			mysetContentViewGamerchoose();
			break;
		case 3:
			mysetContentViewDifficultychoose();
			break;
		case 0 :
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