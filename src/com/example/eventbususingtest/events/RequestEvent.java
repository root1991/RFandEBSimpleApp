package com.example.eventbususingtest.events;

import com.example.eventbususingtest.model.Data;

public class RequestEvent {
	private final Data model;

	public Data getModel() {
		return model;
	}

	public RequestEvent(Data model) {
		this.model = model;
	}
}
