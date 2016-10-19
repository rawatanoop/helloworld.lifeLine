package lifeLine.dao;

import java.util.List;

import lifeLine.orm.entity.DonationCampVolunteer;

public interface IVolunteer<V> {
	
	public List<DonationCampVolunteer> getAllByCampID(int campID) ;
	  
	public List<DonationCampVolunteer> getAllByUserID(int userID);
	  

}
