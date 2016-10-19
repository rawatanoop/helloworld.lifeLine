package lifeLine.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lifeLine.dao.VolunteerDao;
import lifeLine.model.VolunteerModel;
import lifeLine.orm.entity.DonationCampVolunteer;
import lifeLine.orm.entity.DonationCampVolunteerPK;

@Service
public class VolunteerService {


	  @Autowired
	  private VolunteerDao dcVolunteerDao;
	  
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


	  
	  public String create(VolunteerModel volunteer) {
  	    			
	      dcVolunteerDao.save(getEntity(volunteer));

	    return "User succesfully saved!";
	  }

	public List<VolunteerModel>  getByUserID(int userID) {
		List<VolunteerModel> list = new ArrayList<VolunteerModel>();
		List<DonationCampVolunteer> entitylist = dcVolunteerDao.getAllByCampID(userID);
		for (Iterator iterator = entitylist.iterator(); iterator.hasNext();) {
			list.add(getModel((DonationCampVolunteer) iterator.next()));
			
		}
		return list;
	}

	public List<VolunteerModel> getByCampID(int campID) {		
		return getModelList(dcVolunteerDao.getAllByCampID(campID));	
	}
	

	public void update(int id, VolunteerModel volunteer) {
		DonationCampVolunteer volunteerEntity = getEntity(volunteer);
		dcVolunteerDao.update(id,volunteerEntity);
		
	}
	  private VolunteerModel getModel(DonationCampVolunteer entity){
		  VolunteerModel model = new VolunteerModel();
		  model.setUserID(entity.getDonationCampVolenteerPK().getUserID());
		  model.setCampID(entity.getDonationCampVolenteerPK().getCampID());
		  model.setRequestStatus(entity.getRequestStatus());
		return model;
		  
	  }
	  
	  private DonationCampVolunteer getEntity(VolunteerModel model){
		  DonationCampVolunteer entity = new DonationCampVolunteer(new DonationCampVolunteerPK(model.getUserID(), model.getCampID()));
		  entity.setRequestStatus(model.getRequestStatus());	  
			return entity;			  
		  }
	  
	  private List<VolunteerModel> getModelList(List<DonationCampVolunteer> entityList){
		  	List<VolunteerModel> list = new ArrayList<VolunteerModel>();
			for (Iterator<DonationCampVolunteer> iterator = entityList.iterator(); iterator.hasNext();) {
				list.add(getModel(iterator.next()));
				
			}
			return list;
		  
	  }
}
