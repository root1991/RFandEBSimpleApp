package com.example.eventbususingtest.callbacks;

import com.example.eventbususingtest.events.RequestEvent;
import com.example.eventbususingtest.model.RequestModel;

import de.greenrobot.event.EventBus;

import retrofit.client.Response;

public class JSONRequest extends MainCallBack<RequestModel> {

	@Override
	public void success(RequestModel model, Response response) {
		EventBus.getDefault().post(new RequestEvent(model));
	}

}
