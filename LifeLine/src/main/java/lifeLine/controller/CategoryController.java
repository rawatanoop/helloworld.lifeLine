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

import lifeLine.model.CategoryModel;
import lifeLine.model.DonationCampModel;
import lifeLine.service.CategoryService;

@Controller
@RequestMapping(value = "/category")
@ComponentScan("lifeLine.service")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("id") int id) {
		try {
			categoryService.delete(id);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "User succesfully deregister!";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CategoryModel> getByCampID(@PathVariable("id") int id) {

		CategoryModel camp = categoryService.getByID(id);
		return new ResponseEntity<CategoryModel>(camp, HttpStatus.FOUND);

	}
	
	@RequestMapping(value="/all")
	  @ResponseBody
	  public List<CategoryModel> getAll() {

	      return categoryService.getAll();
	  }

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody CategoryModel model) {
		categoryService.create(model);
		return "Category succesfully saved!";
	}

}
