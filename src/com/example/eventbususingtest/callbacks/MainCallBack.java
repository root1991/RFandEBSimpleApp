package com.example.eventbususingtest.callbacks;

import com.example.eventbususingtest.events.RetrofitErrorEvent;

import de.greenrobot.event.EventBus;
import retrofit.RetrofitError;

public abstract class MainCallBack<E> implements retrofit.Callback<E> {
	@Override
	public void failure(RetrofitError error) {
		EventBus.getDefault().post(new RetrofitErrorEvent(error));
	}
}
