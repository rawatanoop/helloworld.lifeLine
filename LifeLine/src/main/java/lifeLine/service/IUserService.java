package lifeLine.service;

import java.util.List;

import lifeLine.model.UserModel;

public interface IUserService {

	public String delete(int campID);

	public String create(UserModel user);

	public UserModel getByID(int userID);

	public void update(int id, UserModel userModel);

	public List<UserModel> getAll();

}
