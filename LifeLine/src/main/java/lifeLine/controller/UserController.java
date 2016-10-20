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
import lifeLine.model.UserModel;
import lifeLine.service.UserService;

@Controller
@RequestMapping(value = "/user")
@ComponentScan("lifeLine.service")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") int id) throws BadRequestException {
		userService.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public UserModel getByID(@PathVariable("id") int id) throws BadRequestException {
		return userService.getByID(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody UserModel user) {
		userService.create(user);

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PATCH)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") int id, @RequestBody UserModel user) throws BadRequestException {
		userService.update(id, user);

	}

	@RequestMapping(value = "/all")
	@ResponseBody
	public List<UserModel> getAll() {

		return userService.getAll();
	}

}
