package lifeLine.service;

import java.util.List;

import inti.ws.spring.exception.client.BadRequestException;
import lifeLine.model.VolunteerModel;
public interface IVolunteerService {

	public String delete(int campID) throws BadRequestException;

	public String create(VolunteerModel volunteer) throws BadRequestException;

	public List<VolunteerModel> getByUserID(int userID) throws BadRequestException;

	public List<VolunteerModel> getByCampID(int campID) throws BadRequestException;

	public void update(int id, VolunteerModel volunteer) throws BadRequestException; 

}
