/*
 * This example sets a new wallpaper for the hand set.
 * This wallpaper is used until it is cleared which resets the default.
 * Notice the permission used in the Manifest.
 * Notice the two wallpaper methods may throw a checked exception.
 */
package com.course.example.wallpaper;

import android.app.Activity;
import android.os.Bundle;
import android.app.WallpaperManager;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import java.io.IOException;

public class Wallpaper extends Activity {

	private WallpaperManager paper;
	private Button button1;
	private Button button2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		paper = WallpaperManager.getInstance(this);

		button1 = (Button) findViewById(R.id.button01);
		button2 = (Button) findViewById(R.id.button02);

		//set button to set wallpaper
		button1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Wallpaper Set",
						Toast.LENGTH_LONG).show();
				try {
					paper.setResource(R.raw.android); // set wallpaper
				} catch (IOException e) { Log.e("wallpaper", "wallpaper not set");
				}
			}
		});

		//set button to reset wallpaper to default
		button2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Wallpaper Reset",
						Toast.LENGTH_LONG).show();
				try {
					paper.clear(); // clear any set wallpaper, use default
				} catch (IOException e) {
				}
			}
		});

	}
}