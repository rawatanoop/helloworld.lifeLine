package lifeLine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
  
  @RequestMapping(value="/one")
  @ResponseBody
  public String getByID(int id) {
	  dcService.getByID(id);
    return "The user id is: " + id;
  }

  @RequestMapping(value="/save")
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
