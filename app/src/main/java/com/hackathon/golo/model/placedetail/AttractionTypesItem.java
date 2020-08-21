package com.hackathon.golo.model.placedetail;

import com.google.gson.annotations.SerializedName;

public class AttractionTypesItem{

	@SerializedName("code")
	private String code;

	@SerializedName("description")
	private String description;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"AttractionTypesItem{" + 
			"code = '" + code + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}