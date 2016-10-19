package lifeLine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate4.HibernateObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lifeLine.model.UserModel;
import lifeLine.service.UserService;

@Controller
@RequestMapping(value="/user")
@ComponentScan("lifeLine.service")
public class UserController {

  @Autowired
  private UserService userService;
  
  @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
  @ResponseBody
  public String delete(@PathVariable("id") int id) {
    try {
      userService.delete(id);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }
  
@RequestMapping(value="/{id}",method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<UserModel> getByID(@PathVariable("id") int id) throws Exception {

	  UserModel user = null;
	  try {
		   user = userService.getByID(id);
		
	}
	  catch (HibernateObjectRetrievalFailureException e) {
		  return new ResponseEntity("Sorry we can not find any donation camp information for you.",HttpStatus.NOT_FOUND);
	}
	  catch (Exception e) {
		e.printStackTrace();
		throw new Exception("Sorry we can not find any donation camp information for you.");
	}
	  if(user == null|user.getId() == null)
		  return new ResponseEntity(HttpStatus.NOT_FOUND);	  
	  return new ResponseEntity<UserModel>(user, HttpStatus.FOUND);
    
  }

  @RequestMapping(value="/save",method = RequestMethod.POST)
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public String create(@RequestBody UserModel user) {
      userService.create(user);
    return "User succesfully saved!";
  }
  
  @RequestMapping(value="/update/{id}",method = RequestMethod.PATCH)
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public String update(@PathVariable("id") int id,@RequestBody UserModel user) {
      userService.update(id,user);
    return "User succesfully updated!";
  }
  
  @RequestMapping(value="/all")
  @ResponseBody
  public List<UserModel> getAll() {

      return userService.getAll();
  }

}
