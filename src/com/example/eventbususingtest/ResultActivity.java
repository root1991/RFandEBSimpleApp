package com.example.eventbususingtest;

import android.os.Bundle;
import android.util.Log;

import com.example.eventbususingtest.callbacks.JSONRequest;
import com.example.eventbususingtest.events.RequestEvent;
import com.example.eventbususingtest.rest.GetJSONInterface;

public class ResultActivity extends MainActivity {
	GetJSONInterface jface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		jface = getCreator().getmJSONInterFace();
		jface.getJSON(1, new JSONRequest());
	}

	public void onEventMainThread(RequestEvent event) {
		Log.e("REQ", event.getModel().title);
	}
}
