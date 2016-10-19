package lifeLine.controller;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate4.HibernateObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lifeLine.model.DonationCampModel;
import lifeLine.model.DonationCampVolunteerModel;
import lifeLine.orm.entity.DonationCamp;
import lifeLine.service.DonationCampService;
import lifeLine.service.DonationCampVolunteerService;

@Controller
@RequestMapping(value="/donationCampVolunteer")
@ComponentScan("lifeLine.service")
public class DonationCampVolunteerController {

	  @Autowired
	  private DonationCampVolunteerService dcVolunteerService;
	  
	  @Autowired
	  private DonationCampService dcService;
	  
	  @RequestMapping(value="/deregister/{campId}",method = RequestMethod.DELETE)
	  @ResponseBody
	  public String delete(@PathVariable("campId") int campId) {
	    try {
	      dcVolunteerService.delete(campId);
	    }
	    catch(Exception ex) {
	      return ex.getMessage();
	    }
	    return "User succesfully deregister!";
	  }
	  
	@RequestMapping(value="/{campId}",method = RequestMethod.GET)
	  @ResponseBody
	  public ResponseEntity<DonationCampModel> getByCampID(@PathVariable("campId") int campId){

		DonationCampModel camp = dcService.getByID(campId);
			
		
		  return new ResponseEntity<DonationCampModel>(camp, HttpStatus.FOUND);
	    
	  }

	  @RequestMapping(value="/save",method = RequestMethod.POST)
	  @ResponseBody
	  @ResponseStatus(HttpStatus.CREATED)
	  public String create(@RequestBody DonationCampVolunteerModel camp) {
	      dcVolunteerService.create(camp);
	    return "User succesfully saved!";
	  }
	  
	  @RequestMapping(value="/update/{id}",method = RequestMethod.PATCH)
	  @ResponseBody
	  @ResponseStatus(HttpStatus.CREATED)
	  public String update(@PathVariable("id") int id,@RequestBody DonationCampVolunteerModel camp) {
	      dcVolunteerService.update(id,camp);
	    return "User succesfully updated!";
	  }
	  
	  @RequestMapping(value="/myCamps")
	  @ResponseBody
	  public List<DonationCampVolunteerModel> getByUSerID() {
		  int userID = 1;
	      return dcVolunteerService.getByUserID(userID);
	  }

}
