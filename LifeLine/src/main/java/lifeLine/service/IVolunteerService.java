package lifeLine.service;

import java.util.List;

import javax.management.BadAttributeValueExpException;

import inti.ws.spring.exception.client.BadRequestException;
import lifeLine.model.VolunteerModel;
public interface IVolunteerService {

	public void delete(int campID) throws BadRequestException, BadAttributeValueExpException;

	public void create(VolunteerModel volunteer) throws BadRequestException;

	public List<VolunteerModel> getByUserID(int userID) throws BadRequestException;

	public List<VolunteerModel> getByCampID(int campID) throws BadRequestException;

	public void update(int id, VolunteerModel volunteer) throws BadRequestException; 

}
