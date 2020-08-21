package com.hackathon.golo.model.placedetail;

import com.google.gson.annotations.SerializedName;

public class Fee{

	@SerializedName("thai_adult")
	private String thaiAdult;

	@SerializedName("foreigner_child")
	private String foreignerChild;

	@SerializedName("foreigner_adult")
	private String foreignerAdult;

	@SerializedName("thai_child")
	private String thaiChild;

	public void setThaiAdult(String thaiAdult){
		this.thaiAdult = thaiAdult;
	}

	public String getThaiAdult(){
		return thaiAdult;
	}

	public void setForeignerChild(String foreignerChild){
		this.foreignerChild = foreignerChild;
	}

	public String getForeignerChild(){
		return foreignerChild;
	}

	public void setForeignerAdult(String foreignerAdult){
		this.foreignerAdult = foreignerAdult;
	}

	public String getForeignerAdult(){
		return foreignerAdult;
	}

	public void setThaiChild(String thaiChild){
		this.thaiChild = thaiChild;
	}

	public String getThaiChild(){
		return thaiChild;
	}

	@Override
 	public String toString(){
		return 
			"Fee{" + 
			"thai_adult = '" + thaiAdult + '\'' + 
			",foreigner_child = '" + foreignerChild + '\'' + 
			",foreigner_adult = '" + foreignerAdult + '\'' + 
			",thai_child = '" + thaiChild + '\'' + 
			"}";
		}
}