package lifeLine.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	    			campModel.getCampCategoryID(),campModel.getAddress(),new Date(campModel.getStartDate()),
	    			new Date(campModel.getEndDate()),campModel.getUnit(),campModel.getUnitLeft());
	    			
	      dcDao.save(camp);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "User succesfully saved!";
	  }

	public DonationCamp getByID(int id) {
		return dcDao.getById(id);
		
	}

	public List<DonationCamp> getAll() {
		
		return dcDao.getAll();
		
	}

	public void update(int id, DonationCampModel campModel) {
		DonationCamp camp = new DonationCamp(campModel.getId(),campModel.getUserID(),
    			campModel.getCampCategoryID(),campModel.getAddress(),new Date(campModel.getStartDate()),
    			new Date(campModel.getEndDate()),campModel.getUnit(),campModel.getUnitLeft());
		dcDao.update(id,camp);
		
	}



}
