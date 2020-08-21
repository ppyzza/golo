package com.hackathon.golo.model;

import com.google.gson.annotations.SerializedName;

public class ResultItem{

	@SerializedName("category_description")
	private String categoryDescription;

	@SerializedName("place_name")
	private String placeName;

	@SerializedName("distance")
	private double distance;

	@SerializedName("category_code")
	private String categoryCode;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("destination")
	private String destination;

	@SerializedName("location")
	private Location location;

	@SerializedName("thumbnail_url")
	private String thumbnailUrl;

	@SerializedName("place_id")
	private String placeId;

	@SerializedName("update_date")
	private String updateDate;

	@SerializedName("longitude")
	private double longitude;

	@SerializedName("tags")
	private String tags;

	public void setCategoryDescription(String categoryDescription){
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryDescription(){
		return categoryDescription;
	}

	public void setPlaceName(String placeName){
		this.placeName = placeName;
	}

	public String getPlaceName(){
		return placeName;
	}

	public void setDistance(double distance){
		this.distance = distance;
	}

	public double getDistance(){
		return distance;
	}

	public void setCategoryCode(String categoryCode){
		this.categoryCode = categoryCode;
	}

	public String getCategoryCode(){
		return categoryCode;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setDestination(String destination){
		this.destination = destination;
	}

	public String getDestination(){
		return destination;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setThumbnailUrl(String thumbnailUrl){
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getThumbnailUrl(){
		return thumbnailUrl;
	}

	public void setPlaceId(String placeId){
		this.placeId = placeId;
	}

	public String getPlaceId(){
		return placeId;
	}

	public void setUpdateDate(String updateDate){
		this.updateDate = updateDate;
	}

	public String getUpdateDate(){
		return updateDate;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	public void setTags(String tags){
		this.tags = tags;
	}

	public String getTags(){
		return tags;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"category_description = '" + categoryDescription + '\'' + 
			",place_name = '" + placeName + '\'' + 
			",distance = '" + distance + '\'' + 
			",category_code = '" + categoryCode + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",destination = '" + destination + '\'' + 
			",location = '" + location + '\'' + 
			",thumbnail_url = '" + thumbnailUrl + '\'' + 
			",place_id = '" + placeId + '\'' + 
			",update_date = '" + updateDate + '\'' + 
			",longitude = '" + longitude + '\'' + 
			",tags = '" + tags + '\'' + 
			"}";
		}
}