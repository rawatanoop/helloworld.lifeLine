package lifeLine.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lifeLine.dao.CategoryDao;
import lifeLine.dao.ICategoryDao;
import lifeLine.model.CategoryModel;
import lifeLine.orm.entity.DonationCampCategory;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryDao<DonationCampCategory> categoryDao;

	public String delete(int campID) {
		try {
			DonationCampCategory user = new DonationCampCategory(campID);
			categoryDao.delete(user);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "User succesfully deleted!";
	}

	public String create(CategoryModel user) {
		categoryDao.save(getEntity(user));
		return "User succesfully saved!";
	}

	public CategoryModel getByID(int userID) {
		return getModel(categoryDao.getById(userID));

	}

	public void update(int id, CategoryModel categoryModel) {
		DonationCampCategory category = getEntity(categoryModel);
		categoryDao.update(id, category);
	}

	public List<CategoryModel> getAll() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		List<DonationCampCategory> entitylist = categoryDao.getAll();
		for (Iterator<DonationCampCategory> iterator = entitylist.iterator(); iterator.hasNext();) {
			list.add(getModel(iterator.next()));

		}
		return list;
	}

	private CategoryModel getModel(DonationCampCategory entity) {
		CategoryModel model = new CategoryModel();
		model.setSubCategory(entity.getSubCategory());
		model.setId(entity.getId());
		model.setCategory(entity.getCategory());
		return model;

	}

	private DonationCampCategory getEntity(CategoryModel model) {
		DonationCampCategory entity = new DonationCampCategory();
		entity.setId(model.getId());
		entity.setSubCategory(model.getSubCategory());
		entity.setCategory(model.getCategory());
		return entity;

	}

}
