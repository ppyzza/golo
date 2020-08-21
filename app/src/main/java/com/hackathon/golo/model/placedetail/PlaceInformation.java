package com.hackathon.golo.model.placedetail;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceInformation{

	@Expose
	@SerializedName("activities")
	private List<String> activities;

	@SerializedName("fee")
	private Fee fee;

	@SerializedName("detail")
	private String detail;

	@SerializedName("attraction_types")
	private List<AttractionTypesItem> attractionTypes;

	@Expose
	@SerializedName("targets")
	private List<String> targets;

	@SerializedName("introduction")
	private String introduction;

	public void setActivities(List<String> activities){
		this.activities = activities;
	}

	public List<String> getActivities(){
		return activities;
	}

	public void setFee(Fee fee){
		this.fee = fee;
	}

	public Fee getFee(){
		return fee;
	}

	public void setDetail(String detail){
		this.detail = detail;
	}

	public String getDetail(){
		return detail;
	}

	public void setAttractionTypes(List<AttractionTypesItem> attractionTypes){
		this.attractionTypes = attractionTypes;
	}

	public List<AttractionTypesItem> getAttractionTypes(){
		return attractionTypes;
	}

	public void setTargets(List<String> targets){
		this.targets = targets;
	}

	public List<String> getTargets(){
		return targets;
	}

	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}

	public String getIntroduction(){
		return introduction;
	}

	@Override
 	public String toString(){
		return 
			"PlaceInformation{" + 
			"activities = '" + activities + '\'' + 
			",fee = '" + fee + '\'' + 
			",detail = '" + detail + '\'' + 
			",attraction_types = '" + attractionTypes + '\'' + 
			",targets = '" + targets + '\'' + 
			",introduction = '" + introduction + '\'' + 
			"}";
		}
}