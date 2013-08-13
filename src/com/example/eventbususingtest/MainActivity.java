package com.example.eventbususingtest;

import com.example.eventbususingtest.events.RetrofitErrorEvent;

import de.greenrobot.event.EventBus;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public abstract class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onPause() {
		super.onPause();
		EventBus.getDefault().unregister(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		EventBus.getDefault().registerSticky(this);
	}

	public void onEventMainThread(
			RetrofitErrorEvent event) {
		Log.e("RETROFIT ERROR", "ERROR");

	}

}
