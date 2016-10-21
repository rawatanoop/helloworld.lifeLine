package lifeLine.controller;

import java.util.List;

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
import inti.ws.spring.exception.client.NotFoundException;
import lifeLine.model.DonationCampModel;
import lifeLine.service.DonationCampService;

@Controller
@RequestMapping(value = "/donationCamp")
@ComponentScan("lifeLine.service")
public class DonationCampController {

	@Autowired
	private DonationCampService dcService;

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") int id) throws BadRequestException {

		dcService.delete(id);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public DonationCampModel getByID(@PathVariable("id") int id) throws BadRequestException, NotFoundException {

		return dcService.getByID(id);

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody DonationCampModel camp) throws BadRequestException {
		dcService.create(camp);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PATCH)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") int id, @RequestBody DonationCampModel camp) throws BadRequestException {
		dcService.update(id, camp);
	}

	@RequestMapping(value = "/all")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<DonationCampModel> getAll() throws NotFoundException, BadRequestException {
		return dcService.getAll();
	}

}
