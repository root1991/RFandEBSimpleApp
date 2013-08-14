package com.example.eventbususingtest.rest;

import java.util.ArrayList;
import java.util.List;

import retrofit.RequestHeaders;
import retrofit.RestAdapter;
import retrofit.client.Header;
import retrofit.converter.GsonConverter;

import com.example.eventbususingtest.constants.ApiConstants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class RestAdapterCreator {
	private GetJSONInterface mJSONInterFace;

	public RestAdapterCreator() {
		onCreateRestAdapter(null);
	}

	public void onCreateRestAdapter(final ArrayList<Header> headers) {
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setServer(ApiConstants.MAIN_URL)
				.setRequestHeaders(new RequestHeaders() {

					@Override
					public List<Header> get() {
						ArrayList<Header> requestHeaders = new ArrayList<Header>();
						requestHeaders.add(new Header("Accept",
								"application/json"));
						if (headers != null) {
							requestHeaders.addAll(headers);
						}
						return requestHeaders;
					}
				})
				.setConverter(
						new GsonConverter(
								new GsonBuilder()
										.setFieldNamingPolicy(
												FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
										.setFieldNamingStrategy(
												FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
										.setLongSerializationPolicy(
												LongSerializationPolicy.STRING)
										.create())).setDebug(true).build();
		mJSONInterFace = restAdapter.create(GetJSONInterface.class);
	}

	public GetJSONInterface getmJSONInterFace() {
		return mJSONInterFace;
	}

}
