package lifeLine.model;

import java.util.Date;

public class DonationCampVolunteerModel {
	private int userID;
	private int campID;
	private String 	requestStatus;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCampID() {
		return campID;
	}
	public void setCampID(int campID) {
		this.campID = campID;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	
}
