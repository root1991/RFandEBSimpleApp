package com.example.eventbususingtest.rest;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;

import com.example.eventbususingtest.model.RequestModel;

public interface GetJSONInterface {
	@GET("/test/?id=1")
	void getJSON(@Header("title") String title,
			Callback<RequestModel> callback);

}
