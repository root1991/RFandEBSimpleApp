package com.example.eventbususingtest.rest;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

import com.example.eventbususingtest.model.Data;

public interface GetJSONInterface {
	@GET("/test/")
	void getJSON(@Query("id") int id, Callback<Data> callback);

}
