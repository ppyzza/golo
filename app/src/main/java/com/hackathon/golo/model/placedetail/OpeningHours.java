package com.hackathon.golo.model.placedetail;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OpeningHours{

	@SerializedName("open_now")
	private boolean openNow;

	@SerializedName("special_close_text")
	private String specialCloseText;

	@SerializedName("periods")
	private List<PeriodsItem> periods;

	@SerializedName("weekday_text")
	private WeekdayText weekdayText;

	public void setOpenNow(boolean openNow){
		this.openNow = openNow;
	}

	public boolean isOpenNow(){
		return openNow;
	}

	public void setSpecialCloseText(String specialCloseText){
		this.specialCloseText = specialCloseText;
	}

	public String getSpecialCloseText(){
		return specialCloseText;
	}

	public void setPeriods(List<PeriodsItem> periods){
		this.periods = periods;
	}

	public List<PeriodsItem> getPeriods(){
		return periods;
	}

	public void setWeekdayText(WeekdayText weekdayText){
		this.weekdayText = weekdayText;
	}

	public WeekdayText getWeekdayText(){
		return weekdayText;
	}

	@Override
 	public String toString(){
		return 
			"OpeningHours{" + 
			"open_now = '" + openNow + '\'' + 
			",special_close_text = '" + specialCloseText + '\'' + 
			",periods = '" + periods + '\'' + 
			",weekday_text = '" + weekdayText + '\'' + 
			"}";
		}
}