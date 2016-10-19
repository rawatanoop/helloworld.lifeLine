package lifeLine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lifeLine.model.DonationCampModel;
import lifeLine.model.VolunteerModel;
import lifeLine.service.DonationCampService;
import lifeLine.service.VolunteerService;

@Controller
@RequestMapping(value="/search")
@ComponentScan("lifeLine.service")
public class SearchController {
	  
	  @Autowired
	  private DonationCampService dcService;
	  
	  @RequestMapping(value="/all")
	  @ResponseBody
	  public List<DonationCampModel> getAll() {

	      return dcService.getAll();
	  }
	  
	  @RequestMapping(value="/address/{address}")
	  @ResponseBody
	  public List<DonationCampModel> getByAddress(@PathVariable("address") String address) {
	      return dcService.getByAddress(address);
	  }

}
