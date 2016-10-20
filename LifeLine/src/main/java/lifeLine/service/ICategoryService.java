package lifeLine.service;

import java.util.List;

import inti.ws.spring.exception.client.BadRequestException;
import lifeLine.model.CategoryModel;
import lifeLine.model.UserModel;

public interface ICategoryService {

	public String delete(int categoryID) ;

	public String create(CategoryModel category);

	public CategoryModel getByID(int categoryID) ;

	public void update(int id, CategoryModel category);

	public List<CategoryModel> getAll();

}
