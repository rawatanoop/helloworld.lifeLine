package lifeLine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lifeLine.orm.entity.DonationCampCategory;

@Repository
public class CategoryDao implements ICategoryDao<DonationCampCategory> {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	public void save(DonationCampCategory category) {
		getSession().save(category);
		return;
	}

	public void delete(DonationCampCategory category) {
		getSession().delete(category);
		return;
	}

	@SuppressWarnings("unchecked")
	public List<DonationCampCategory> getAll() {
		return getSession().createQuery("from DonationCampCategory").list();
	}

	public DonationCampCategory getById(Integer categoryID) {
		DonationCampCategory category = (DonationCampCategory) getSession().load(DonationCampCategory.class,
				categoryID);
		if (category.getId() == categoryID)
			return category;
		return null;
	}

	public void update(int categoryID, DonationCampCategory category) {
		getSession().update(category);
		return;
	}

}
