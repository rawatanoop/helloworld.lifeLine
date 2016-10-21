package lifeLine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.NotFoundException;
import lifeLine.model.DonationCampModel;
import lifeLine.service.DonationCampService;

@Controller
@RequestMapping(value = "/search")
@ComponentScan("lifeLine.service")
public class SearchController {

	@Autowired
	private DonationCampService dcService;

	@RequestMapping(value = "/all")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<DonationCampModel> getAll() throws NotFoundException, BadRequestException {

		return dcService.getAll();
	}

	@RequestMapping(value = "/address/{address}")
	@ResponseBody
	public List<DonationCampModel> getByAddress(@PathVariable("address") String address) throws NotFoundException, BadRequestException {
		return dcService.getByAddress(address);
	}

}
