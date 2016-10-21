package lifeLine.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inti.ws.spring.exception.client.BadRequestException;
import lifeLine.dao.IUserDao;
import lifeLine.dao.UserDao;
import lifeLine.model.UserModel;
import lifeLine.orm.entity.User;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDao<User> userDao;

	
	public void delete(int id) throws BadRequestException {
		if(!isValidID(id))
			throw new BadRequestException(IService.InvalidID);
		
			User user = new User(id);
			userDao.delete(user);
		
	}

	
	public void create(UserModel user) {
		userDao.save(getEntity(user));
		
	}

	
	public UserModel getByID(int id) throws BadRequestException {
		if(!isValidID(id))
			throw new BadRequestException(IService.InvalidID);
		return getModel(userDao.getById(id));

	}

	
	public void update(int id, UserModel userModel) throws BadRequestException {
		if(!isValidID(id))
			throw new BadRequestException(IService.InvalidID);
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

	private boolean isValidID(int id){
		return true;
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
