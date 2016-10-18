package lifeLine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lifeLine.dao.DonationCampDao;
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

	  public String create() {
	    try {
	    	DonationCamp user = new DonationCamp();
	      dcDao.save(user);
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



}
