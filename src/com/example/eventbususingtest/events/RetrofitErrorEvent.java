package com.example.eventbususingtest.events;

import retrofit.RetrofitError;


public class RetrofitErrorEvent {
	private final RetrofitError error;

    public RetrofitErrorEvent(RetrofitError error) {
        this.error = error;
    }

    public RetrofitError getError() {
        return error;
    }
}
