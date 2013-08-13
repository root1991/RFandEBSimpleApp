package com.example.eventbususingtest;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.os.Bundle;
import android.util.Log;

import com.example.eventbususingtest.events.RequestEvent;
import com.example.eventbususingtest.model.RequestModel;
import com.example.eventbususingtest.rest.RestAdapterCreator;

public class ResultActivity extends MainActivity{
	RestAdapterCreator creatror = new RestAdapterCreator();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}

	public void onEventMainThread(RequestEvent event) {
		creatror.getmJSONInterFace().getJSON("title", new Callback<RequestModel>() {

			@Override
			public void success(RequestModel t, Response response) {
				Log.d("REQUEST", t.title);
			}

			@Override
			public void failure(RetrofitError error) {
				Log.e("FAILURE", "fail");
			}
		});
	}
	
	
	
}
