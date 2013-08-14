package com.example.eventbususingtest;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;

import com.example.eventbususingtest.events.RetrofitErrorEvent;
import com.example.eventbususingtest.rest.RestAdapterCreator;

import de.greenrobot.event.EventBus;

public abstract class MainActivity extends Activity {
	private RestAdapterCreator creator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		creator = ((TestAplication) getApplication()).getCreator();
	}

	public RestAdapterCreator getCreator() {
		return creator;
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

	public void onEventMainThread(RetrofitErrorEvent event) {
		String errText = "network";
		if (event.getError() == null || event.getError().isNetworkError()) {
			errText = "network";
		} else if (event.getError().getResponse() != null
				&& event.getError().getResponse().getReason() != null) {
			errText = event.getError().getResponse().getReason().toUpperCase();
		} else if (!TextUtils.isEmpty(event.getError().getMessage())) {
			errText = event.getError().getMessage().toUpperCase();
		}
		Log.e("RETROFIT ERROR", errText);

	}

}
