package lifeLine.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lifeLine.dao.DonationCampDao;
import lifeLine.dao.DonationCampVolunteerDao;
import lifeLine.model.DonationCampModel;
import lifeLine.model.DonationCampVolunteerModel;
import lifeLine.orm.entity.DonationCamp;
import lifeLine.orm.entity.DonationCampVolunteerPK;
import lifeLine.orm.entity.DonationCampVolunteer;

@Service
public class DonationCampVolunteerService {


	  @Autowired
	  private DonationCampVolunteerDao dcVolunteerDao;
	  
	  public String delete(int campID) {
	    try {
	      DonationCampVolunteer volunteer = new DonationCampVolunteer(new DonationCampVolunteerPK());
	      dcVolunteerDao.delete(volunteer);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "User succesfully deleted!";
	  }

	  private DonationCampVolunteerModel getModel(DonationCampVolunteer entity){
		  DonationCampVolunteerModel model = new DonationCampVolunteerModel();
		  model.setUserID(entity.getDonationCampVolenteerPK().getUserID());
		  model.setCampID(entity.getDonationCampVolenteerPK().getCampID());
		  model.setRequestStatus(entity.getRequestStatus());
		return model;
		  
	  }
	  
	  private DonationCampVolunteer getEntity(DonationCampVolunteerModel model){
		  DonationCampVolunteer entity = new DonationCampVolunteer(new DonationCampVolunteerPK(model.getUserID(), model.getCampID()));
		  entity.setRequestStatus(model.getRequestStatus());	  
			return entity;			  
		  }
	  
	  public String create(DonationCampVolunteerModel volunteer) {
  	    			
	      dcVolunteerDao.save(getEntity(volunteer));

	    return "User succesfully saved!";
	  }

	public List<DonationCampVolunteerModel>  getByUserID(int userID) {
		List<DonationCampVolunteerModel> list = new ArrayList<DonationCampVolunteerModel>();
		List<DonationCampVolunteer> entitylist = dcVolunteerDao.getAllByCampID(userID);
		for (Iterator iterator = entitylist.iterator(); iterator.hasNext();) {
			list.add(getModel((DonationCampVolunteer) iterator.next()));
			
		}
		return list;
	}

	public List<DonationCampVolunteerModel> getByCampID(int campID) {		
		List<DonationCampVolunteerModel> list = new ArrayList<DonationCampVolunteerModel>();
		List<DonationCampVolunteer> entitylist = dcVolunteerDao.getAllByCampID(campID);
		return list;	
	}
	

	public void update(int id, DonationCampVolunteerModel volunteer) {
		DonationCampVolunteer volunteerEntity = getEntity(volunteer);
		dcVolunteerDao.update(id,volunteerEntity);
		
	}


}
