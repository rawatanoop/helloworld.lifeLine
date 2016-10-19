package lifeLine.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lifeLine.dao.UserDao;
import lifeLine.model.UserModel;
import lifeLine.orm.entity.User;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserDao userDao;

	public String delete(int campID) {
		try {
			User user = new User(campID);
			userDao.delete(user);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "User succesfully deleted!";
	}

	public String create(UserModel user) {
		userDao.save(getEntity(user));
		return "User succesfully saved!";
	}

	public UserModel getByID(int userID) {
		return getModel(userDao.getById(userID));

	}

	public void update(int id, UserModel userModel) {
		User user = getEntity(userModel);
		userDao.update(id, user);
	}

	public List<UserModel> getAll() {
		List<UserModel> list = new ArrayList<UserModel>();
		List<User> entitylist = userDao.getAll();
		for (Iterator<User> iterator = entitylist.iterator(); iterator.hasNext();) {
			list.add(getModel(iterator.next()));

		}
		return list;
	}

	private UserModel getModel(User entity) {
		UserModel model = new UserModel();
		model.setName(entity.getName());
		model.setId(entity.getId());
		model.setEmail(entity.getEmail());
		model.setMobile(entity.getMobile());
		return model;

	}

	private User getEntity(UserModel model) {
		User entity = new User();
		entity.setName(model.getName());
		entity.setId(model.getId());
		entity.setEmail(model.getEmail());
		entity.setMobile(model.getMobile());
		return entity;

	}

}
