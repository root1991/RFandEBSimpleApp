package com.example.eventbususingtest;

import android.os.Bundle;
import android.util.Log;

import com.example.eventbususingtest.callbacks.JSONRequest;
import com.example.eventbususingtest.events.RequestEvent;
import com.example.eventbususingtest.rest.RestAdapterCreator;

public class ResultActivity extends MainActivity{
	RestAdapterCreator creatror = new RestAdapterCreator();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		creatror.getmJSONInterFace().getJSON("title", new JSONRequest());
	}
	
	

	public void onEventMainThread(RequestEvent event) {
		Log.d("REQUEST", event.getModel().title);
	}
	
	
	
}
