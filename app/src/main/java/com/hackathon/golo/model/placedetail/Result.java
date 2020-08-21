package com.hackathon.golo.model.placedetail;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result{

	@SerializedName("mobile_picture_urls")
	private List<String> mobilePictureUrls;

	@SerializedName("place_name")
	private String placeName;

	@SerializedName("place_information")
	private PlaceInformation placeInformation;

	@SerializedName("how_to_travel")
	private String howToTravel;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("destination")
	private String destination;

	@SerializedName("services")
	private String services;

	@SerializedName("thumbnail_url")
	private String thumbnailUrl;

	@SerializedName("update_date")
	private String updateDate;

	@SerializedName("tags")
	private String tags;

	@SerializedName("payment_methods")
	private String paymentMethods;

	@SerializedName("map_code")
	private String mapCode;

	@SerializedName("contact")
	private Contact contact;

	@SerializedName("opening_hours")
	private OpeningHours openingHours;

	@SerializedName("location")
	private Location location;

	@Expose
	@SerializedName("facilities")
	private List<Facilities> facilities;

	@SerializedName("hit_score")
	private String hitScore;

	@SerializedName("place_id")
	private String placeId;

	@SerializedName("longitude")
	private double longitude;

	@SerializedName("web_picture_urls")
	private List<String> webPictureUrls;

	public void setMobilePictureUrls(List<String> mobilePictureUrls){
		this.mobilePictureUrls = mobilePictureUrls;
	}

	public List<String> getMobilePictureUrls(){
		return mobilePictureUrls;
	}

	public void setPlaceName(String placeName){
		this.placeName = placeName;
	}

	public String getPlaceName(){
		return placeName;
	}

	public void setPlaceInformation(PlaceInformation placeInformation){
		this.placeInformation = placeInformation;
	}

	public PlaceInformation getPlaceInformation(){
		return placeInformation;
	}

	public void setHowToTravel(String howToTravel){
		this.howToTravel = howToTravel;
	}

	public String getHowToTravel(){
		return howToTravel;
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

	public void setServices(String services){
		this.services = services;
	}

	public String getServices(){
		return services;
	}

	public void setThumbnailUrl(String thumbnailUrl){
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getThumbnailUrl(){
		return thumbnailUrl;
	}

	public void setUpdateDate(String updateDate){
		this.updateDate = updateDate;
	}

	public String getUpdateDate(){
		return updateDate;
	}

	public void setTags(String tags){
		this.tags = tags;
	}

	public String getTags(){
		return tags;
	}

	public void setPaymentMethods(String paymentMethods){
		this.paymentMethods = paymentMethods;
	}

	public String getPaymentMethods(){
		return paymentMethods;
	}

	public void setMapCode(String mapCode){
		this.mapCode = mapCode;
	}

	public String getMapCode(){
		return mapCode;
	}

	public void setContact(Contact contact){
		this.contact = contact;
	}

	public Contact getContact(){
		return contact;
	}

	public void setOpeningHours(OpeningHours openingHours){
		this.openingHours = openingHours;
	}

	public OpeningHours getOpeningHours(){
		return openingHours;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setFacilities(List<Facilities> facilities){
		this.facilities = facilities;
	}

	public List<Facilities> getFacilities(){
		return facilities;
	}

	public void setHitScore(String hitScore){
		this.hitScore = hitScore;
	}

	public String getHitScore(){
		return hitScore;
	}

	public void setPlaceId(String placeId){
		this.placeId = placeId;
	}

	public String getPlaceId(){
		return placeId;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	public void setWebPictureUrls(List<String> webPictureUrls){
		this.webPictureUrls = webPictureUrls;
	}

	public List<String> getWebPictureUrls(){
		return webPictureUrls;
	}

	@Override
 	public String toString(){
		return 
			"Result{" + 
			"mobile_picture_urls = '" + mobilePictureUrls + '\'' + 
			",place_name = '" + placeName + '\'' + 
			",place_information = '" + placeInformation + '\'' + 
			",how_to_travel = '" + howToTravel + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",destination = '" + destination + '\'' + 
			",services = '" + services + '\'' + 
			",thumbnail_url = '" + thumbnailUrl + '\'' + 
			",update_date = '" + updateDate + '\'' + 
			",tags = '" + tags + '\'' + 
			",payment_methods = '" + paymentMethods + '\'' + 
			",map_code = '" + mapCode + '\'' + 
			",contact = '" + contact + '\'' + 
			",opening_hours = '" + openingHours + '\'' + 
			",location = '" + location + '\'' + 
			",facilities = '" + facilities + '\'' + 
			",hit_score = '" + hitScore + '\'' + 
			",place_id = '" + placeId + '\'' + 
			",longitude = '" + longitude + '\'' + 
			",web_picture_urls = '" + webPictureUrls + '\'' + 
			"}";
		}
}