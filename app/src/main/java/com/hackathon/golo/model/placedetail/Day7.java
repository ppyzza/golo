package com.hackathon.golo.model.placedetail;

import com.google.gson.annotations.SerializedName;

public class Day7{

	@SerializedName("time")
	private String time;

	@SerializedName("day")
	private String day;

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setDay(String day){
		this.day = day;
	}

	public String getDay(){
		return day;
	}

	@Override
 	public String toString(){
		return 
			"Day7{" + 
			"time = '" + time + '\'' + 
			",day = '" + day + '\'' + 
			"}";
		}
}