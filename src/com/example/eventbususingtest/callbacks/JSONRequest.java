package com.example.eventbususingtest.callbacks;

import retrofit.client.Response;

import com.example.eventbususingtest.events.RequestEvent;
import com.example.eventbususingtest.model.Data;

import de.greenrobot.event.EventBus;

public class JSONRequest extends MainCallBack<Data> {

	@Override
	public void success(Data model, Response response) {
		EventBus.getDefault().post(new RequestEvent(model));
	}

}
