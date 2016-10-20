package lifeLine.controller;

import java.util.List;

import javax.management.BadAttributeValueExpException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import inti.ws.spring.exception.client.BadRequestException;
import lifeLine.model.DonationCampModel;
import lifeLine.model.VolunteerModel;
import lifeLine.service.DonationCampService;
import lifeLine.service.VolunteerService;

@Controller
@RequestMapping(value = "/volunteer")
@ComponentScan("lifeLine.service")
public class VolunteerController {

	@Autowired
	private VolunteerService volunteerService;

	@Autowired
	private DonationCampService dcService;

	@RequestMapping(value = "/deregister/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") int id) throws BadAttributeValueExpException {
		volunteerService.delete(id);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public DonationCampModel getByCampID(@PathVariable("id") int id) throws BadRequestException {
		return dcService.getByID(id);

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody VolunteerModel model) {
		volunteerService.create(model);

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PATCH)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") int id, @RequestBody VolunteerModel model) throws BadRequestException {
		volunteerService.update(id, model);

	}

	@RequestMapping(value = "/myCamps")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<VolunteerModel> getByUSerID() throws BadRequestException {
		int userID = 1;
		return volunteerService.getByUserID(userID);
	}

}
