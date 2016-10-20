package lifeLine.service;

import java.util.List;

import inti.ws.spring.exception.client.BadRequestException;
import lifeLine.model.UserModel;

public interface IUserService {

	public void delete(int campID) throws BadRequestException;

	public void create(UserModel user);

	public UserModel getByID(int userID) throws BadRequestException;

	public void update(int id, UserModel userModel) throws BadRequestException;

	public List<UserModel> getAll();

}
