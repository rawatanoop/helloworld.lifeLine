package lifeLine.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lifeLine.dao.DonationCampDao;
import lifeLine.model.DonationCampModel;
import lifeLine.orm.entity.DonationCamp;

@Service
public class DonationCampService {


	  @Autowired
	  private DonationCampDao dcDao;
	  
	  public String delete(int id) {
	    try {
	      DonationCamp camp = new DonationCamp(id);
	      dcDao.delete(camp);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "User succesfully deleted!";
	  }

	  public String create(DonationCampModel campModel) {
	    try {
	    	DonationCamp camp = new DonationCamp(campModel.getId(),campModel.getUserID(),
	    			campModel.getCampCategoryID(),campModel.getAddress(),campModel.getStartDate(),
	    			campModel.getEndDate(),campModel.getUnit(),campModel.getUnitLeft());
	    			
	      dcDao.save(camp);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "User succesfully saved!";
	  }

	  @Transactional
	public DonationCampModel getByID(int id) {
		return getModel(dcDao.getById(id));
		
	}

	private DonationCampModel getModel(DonationCamp entity){
		DonationCampModel model = new DonationCampModel();
		model.setId(entity.getId());
		model.setUserID(entity.getUserID());
		model.setCampCategoryID(entity.getCampCategoryID());
		model.setAddress(entity.getAddress());
		model.setStartDate(entity.getStartDate());
		model.setEndDate(entity.getEndDate());	
    	model.setUnit(entity.getUnit());
    	model.setUnitLeft(entity.getUnitLeft());
		return model;
		
	}
	
	private DonationCamp getEntity(DonationCampModel model){
		DonationCamp entity = new DonationCamp(model.getId(),model.getUserID(),
				model.getCampCategoryID(),model.getAddress(),model.getStartDate(),
    			model.getEndDate(),model.getUnit(),model.getUnitLeft());
		return entity;
		
	}
	
	public List<DonationCamp> getAll() {
		
		return dcDao.getAll();
		
	}

	public void update(int id, DonationCampModel campModel) {
		DonationCamp camp = getEntity(campModel);
		dcDao.update(id,camp);
		
	}



}
