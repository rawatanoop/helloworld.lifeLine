package lifeLine.model;

import java.util.Date;

public class DonationCampModel {
	private int id;
	private int userID;
	private int campCategoryID;
	private String address;
	private int startDate;
	private int endDate;
	private int unit;
	private int unitLeft;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCampCategoryID() {
		return campCategoryID;
	}
	public void setCampCategoryID(int campCategoryID) {
		this.campCategoryID = campCategoryID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStartDate() {
		return startDate;
	}
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}
	public int getEndDate() {
		return endDate;
	}
	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getUnitLeft() {
		return unitLeft;
	}
	public void setUnitLeft(int unitLeft) {
		this.unitLeft = unitLeft;
	}

}
