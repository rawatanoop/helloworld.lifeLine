package lifeLine.controller;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate4.HibernateObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lifeLine.orm.entity.DonationCamp;
import lifeLine.service.DonationCampService;

@Controller
@RequestMapping(value="/donationCamp")
@ComponentScan("lifeLine.service")
public class DonationCampController {

  @Autowired
  private DonationCampService dcService;
  
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(int id) {
    try {
      dcService.delete(id);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }
  
@RequestMapping(value="/{id}", 
		  method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<DonationCamp> getByID(@PathVariable("id") int id) throws Exception {

	  DonationCamp camp = null;
	  try {
		   camp = dcService.getByID(id);
		
	}
	  catch (HibernateObjectRetrievalFailureException e) {
		  return new ResponseEntity("Sorry we can not find any donation camp information for you.",HttpStatus.NOT_FOUND);
	}
	  catch (Exception e) {
		e.printStackTrace();
		throw new Exception("Sorry we can not find any donation camp information for you.");
	}
	  if(camp == null|camp.getId() == null)
		  return new ResponseEntity(HttpStatus.NOT_FOUND);
	  
	  
	  return new ResponseEntity<DonationCamp>(camp, HttpStatus.FOUND);
    
  }

  @RequestMapping(
		  value="/save"
		  
		  )
  @ResponseBody
  public String create() {

      dcService.create();
    return "User succesfully saved!";
  }
  
  @RequestMapping(value="/all")
  @ResponseBody
  public List<DonationCamp> getAll() {

      return dcService.getAll();
  }

}
