package lifeLine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lifeLine.orm.entity.User;

@Repository
public class UserDao implements IUserDao<User> {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	@Transactional
	public void save(User volunteer) {
		getSession().save(volunteer);
		return;
	}

	@Transactional
	public void delete(User user) {
		getSession().delete(user);
		return;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return getSession().createQuery("from User").list();
	}

	@Transactional
	public User getById(Integer userID) {
		User user = (User) getSession().load(User.class, userID);
		if (user.getId() == userID)
			return user;
		return null;
	}

	@Transactional
	public void update(int userID, User user) {
		getSession().update(user);
		return;
	}

}
