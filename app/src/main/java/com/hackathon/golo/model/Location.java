package com.hackathon.golo.model;

import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("address")
	private String address;

	@SerializedName("sub_district")
	private String subDistrict;

	@SerializedName("province")
	private String province;

	@SerializedName("district")
	private String district;

	@SerializedName("postcode")
	private String postcode;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setSubDistrict(String subDistrict){
		this.subDistrict = subDistrict;
	}

	public String getSubDistrict(){
		return subDistrict;
	}

	public void setProvince(String province){
		this.province = province;
	}

	public String getProvince(){
		return province;
	}

	public void setDistrict(String district){
		this.district = district;
	}

	public String getDistrict(){
		return district;
	}

	public void setPostcode(String postcode){
		this.postcode = postcode;
	}

	public String getPostcode(){
		return postcode;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"address = '" + address + '\'' + 
			",sub_district = '" + subDistrict + '\'' + 
			",province = '" + province + '\'' + 
			",district = '" + district + '\'' + 
			",postcode = '" + postcode + '\'' + 
			"}";
		}
}