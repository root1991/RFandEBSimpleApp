package com.example.eventbususingtest.rest;


import com.example.eventbususingtest.constants.ApiConstants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import retrofit.RestAdapter;

public class RestAdapterCreator {
	private GetJSONInterface mJSONInterFace;
	
	public RestAdapterCreator() {
		onCreateRestAdapter();
	}
	
	public void onCreateRestAdapter() {
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setServer(ApiConstants.MAIN_URL)
				.setConverter(
						new retrofit.converter.GsonConverter(
								new GsonBuilder()
										.setFieldNamingPolicy(
												FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
										.setFieldNamingStrategy(
												FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
										.setLongSerializationPolicy(
												LongSerializationPolicy.STRING)
										.create())).build();
		
		mJSONInterFace = restAdapter.create(GetJSONInterface.class);
	}
	public GetJSONInterface getmJSONInterFace() {
		return mJSONInterFace;
	}
	
}
