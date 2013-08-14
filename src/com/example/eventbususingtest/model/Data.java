package com.example.eventbususingtest.model;

import com.google.gson.annotations.SerializedName;



public class Data {
	@SerializedName("id")
	public int id;
	
	@SerializedName("title")
	public String title;
	
//	@SerializedName("data")
//	public String data;
	
	@SerializedName("content")
	public String content;
}
