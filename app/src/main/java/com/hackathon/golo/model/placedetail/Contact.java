package com.hackathon.golo.model.placedetail;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Contact{

	@SerializedName("emails")
	private String emails;

	@SerializedName("urls")
	private List<String> urls;

	@SerializedName("mobiles")
	private List<String> mobiles;

	@SerializedName("phones")
	private List<String> phones;

	@SerializedName("fax")
	private List<String> fax;

	public void setEmails(String emails){
		this.emails = emails;
	}

	public String getEmails(){
		return emails;
	}

	public void setUrls(List<String> urls){
		this.urls = urls;
	}

	public List<String> getUrls(){
		return urls;
	}

	public void setMobiles(List<String> mobiles){
		this.mobiles = mobiles;
	}

	public List<String> getMobiles(){
		return mobiles;
	}

	public void setPhones(List<String> phones){
		this.phones = phones;
	}

	public List<String> getPhones(){
		return phones;
	}

	public void setFax(List<String> fax){
		this.fax = fax;
	}

	public List<String> getFax(){
		return fax;
	}

	@Override
 	public String toString(){
		return 
			"Contact{" + 
			"emails = '" + emails + '\'' + 
			",urls = '" + urls + '\'' + 
			",mobiles = '" + mobiles + '\'' + 
			",phones = '" + phones + '\'' + 
			",fax = '" + fax + '\'' + 
			"}";
		}
}