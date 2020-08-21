package com.hackathon.golo.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TATPlace{

	@SerializedName("result")
	private List<ResultItem> result;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"TATPlace{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}