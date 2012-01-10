package com.theships;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


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
		button_stats.setBackgroundResource(R.drawable.button_inactive);
	/*	button_stats.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				previousview = 1;
				setContentView(R.layout.statistics);
			}
		});*/
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
		Button button_multi = (Button)findViewById(R.id.button_multiplayer);
		button_multi.setBackgroundResource(R.drawable.button_inactive);
		/*button_multi.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				previousview = 2;
				setContentView(R.layout.multiplayer);
			}
		});*/
		
	}
	
	public void mysetContentViewDifficultychoose() {
		previousview = 2;
		setContentView(R.layout.difficultychoose);
		Button button_easy = (Button)findViewById(R.id.button_easy);
		button_easy.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				stan = 1;
				previousview = 3;
				mysetContentViewShipmode();
			}
		});
		Button button_hard = (Button)findViewById(R.id.button_hard);
		/*button_hard.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				stan = 2;
				previousview = 3;
				mysetContentViewShipmode();
			}
		});*/
		button_hard.setBackgroundResource(R.drawable.button_inactive);
	}
	
	public void mysetContentViewShipmode() {
		previousview = 3;
		setContentView(R.layout.shipmodechoose);
		Button button_styk = (Button)findViewById(R.id.button_styk);
		button_styk.setBackgroundResource(R.drawable.button_inactive);
		Button button_nstyk = (Button)findViewById(R.id.button_nstyk);
		/*button_styk.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(stan<10)
					stan += 10;
				previousview = 3;
				mysetContentViewGridship();
			}
		});*/
		button_nstyk.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(stan<10)
					stan += 20;
				previousview = 3;
				mysetContentViewGridship();
			}
		});
	}
	
	public void mysetContentViewGridship() {
		previousview = 3;
		setContentView(R.layout.shipgridchoose);
		int[] rids = {R.id.a0 , R.id.a1 , R.id.a2 , R.id.a3 , R.id.a4 , R.id.a5 , R.id.a6 , R.id.a7 , R.id.a8 , R.id.a9
					, R.id.a10, R.id.a11, R.id.a12, R.id.a13, R.id.a14, R.id.a15, R.id.a16, R.id.a17, R.id.a18, R.id.a19
					, R.id.a20, R.id.a21, R.id.a22, R.id.a23, R.id.a24, R.id.a25, R.id.a26, R.id.a27, R.id.a28, R.id.a29
					, R.id.a30, R.id.a31, R.id.a32, R.id.a33, R.id.a34, R.id.a35, R.id.a36, R.id.a37, R.id.a38, R.id.a39
					, R.id.a40, R.id.a41, R.id.a42, R.id.a43, R.id.a44, R.id.a45, R.id.a46, R.id.a47, R.id.a48, R.id.a49
					, R.id.a50, R.id.a51, R.id.a52, R.id.a53, R.id.a54, R.id.a55, R.id.a56, R.id.a57, R.id.a58, R.id.a59
					, R.id.a60, R.id.a61, R.id.a62, R.id.a63, R.id.a64, R.id.a65, R.id.a66, R.id.a67, R.id.a68, R.id.a69
					, R.id.a70, R.id.a71, R.id.a72, R.id.a73, R.id.a74, R.id.a75, R.id.a76, R.id.a77, R.id.a78, R.id.a79
					, R.id.a80, R.id.a81, R.id.a82, R.id.a83, R.id.a84, R.id.a85, R.id.a86, R.id.a87, R.id.a88, R.id.a89
					, R.id.a90, R.id.a91, R.id.a92, R.id.a93, R.id.a94, R.id.a95, R.id.a96, R.id.a97, R.id.a98, R.id.a99};
		final View[] views = new View[100];
		for(int i = 0; i < 100; i++)
			views[i] = findViewById(rids[i]);
		int[] rids2 = {R.id.ship4, R.id.ship3, R.id.ship2, R.id.ship1};
		final View[] sets = new View[4];
		for(int i = 0; i < 4; i++)
			sets[i] = findViewById(rids2[i]);
	/*	Button batman = new Button(getApplicationContext());
		batman.setBackgroundResource(R.drawable.button_small);
		batman.setText("test");
		addContentView(batman, new ViewGroup.LayoutParams(100,100));*/
		Button button_random = (Button)findViewById(R.id.button_random);
		Button button_clear = (Button)findViewById(R.id.button_clear);
		final Editor rGrid = new Editor(views, true, sets);
		rGrid.init();
		button_clear.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				rGrid.clearGrid();
			}
		});
		button_random.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				rGrid.randomize();
			}
		});
		
		Button button_play = (Button)findViewById(R.id.button_next);
		button_play.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(rGrid.isReady()) {
					Intent myIntent = new Intent(TheShipsActivity.this, BattleShipsGame.class);
					myIntent.putExtra("ParsedGrid", rGrid.getParsedGrid());
					TheShipsActivity.this.startActivity(myIntent);
				} else {
					message();
				}
			}
		});
		
	}
	
	public void message() {
		Toast toast = Toast.makeText(getApplicationContext(), "Aby rozpoczac gre, wylosuj ustawienie statkow na planszy", Toast.LENGTH_SHORT);
		toast.show();
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