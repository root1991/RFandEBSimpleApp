package com.example.eventbususingtest.events;

import com.example.eventbususingtest.model.RequestModel;

public class RequestEvent {
	private RequestModel model;
	
	public RequestModel getModel() {
		return model;
	}

	public RequestEvent(RequestModel model) {
		this.model = model;
	}

}
