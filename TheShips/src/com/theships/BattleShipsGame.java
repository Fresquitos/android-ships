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

public class BattleShipsGame extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		int[] parsedGrid = extras.getIntArray("ParsedGrid");

		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		setContentView(R.layout.gamegrid);
		
		int[] rids = {R.id.b0 , R.id.b1 , R.id.b2 , R.id.b3 , R.id.b4 , R.id.b5 , R.id.b6 , R.id.b7 , R.id.b8 , R.id.b9
				, R.id.b10, R.id.b11, R.id.b12, R.id.b13, R.id.b14, R.id.b15, R.id.b16, R.id.b17, R.id.b18, R.id.b19
				, R.id.b20, R.id.b21, R.id.b22, R.id.b23, R.id.b24, R.id.b25, R.id.b26, R.id.b27, R.id.b28, R.id.b29
				, R.id.b30, R.id.b31, R.id.b32, R.id.b33, R.id.b34, R.id.b35, R.id.b36, R.id.b37, R.id.b38, R.id.b39
				, R.id.b40, R.id.b41, R.id.b42, R.id.b43, R.id.b44, R.id.b45, R.id.b46, R.id.b47, R.id.b48, R.id.b49
				, R.id.b50, R.id.b51, R.id.b52, R.id.b53, R.id.b54, R.id.b55, R.id.b56, R.id.b57, R.id.b58, R.id.b59
				, R.id.b60, R.id.b61, R.id.b62, R.id.b63, R.id.b64, R.id.b65, R.id.b66, R.id.b67, R.id.b68, R.id.b69
				, R.id.b70, R.id.b71, R.id.b72, R.id.b73, R.id.b74, R.id.b75, R.id.b76, R.id.b77, R.id.b78, R.id.b79
				, R.id.b80, R.id.b81, R.id.b82, R.id.b83, R.id.b84, R.id.b85, R.id.b86, R.id.b87, R.id.b88, R.id.b89
				, R.id.b90, R.id.b91, R.id.b92, R.id.b93, R.id.b94, R.id.b95, R.id.b96, R.id.b97, R.id.b98, R.id.b99};
	final View[] views = new View[100];
	for(int i = 0; i < 100; i++)
		views[i] = findViewById(rids[i]);
	
	Grid rGrid = new Grid(parsedGrid, views, true);
		
		
	}
	
	
	public void koniecgry() {
		AlertDialog.Builder bilder = new AlertDialog.Builder(this);
		bilder.setMessage("Are you sure you want to exit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				BattleShipsGame.this.finish();
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
		koniecgry();
	}
	
	
}
