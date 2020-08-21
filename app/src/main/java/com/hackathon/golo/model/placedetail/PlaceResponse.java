package com.hackathon.golo.model.placedetail;

import com.google.gson.annotations.SerializedName;

public class PlaceResponse{

	@SerializedName("result")
	private Result result;

	public void setResult(Result result){
		this.result = result;
	}

	public Result getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"PlaceResponse{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}