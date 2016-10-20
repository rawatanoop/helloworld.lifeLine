package lifeLine.service;

import java.util.List;

import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.NotFoundException;
import lifeLine.model.DonationCampModel;

public interface IDonationCampService {

	public void delete(int id) throws BadRequestException;

	public void create(DonationCampModel campModel) throws BadRequestException;

	public DonationCampModel getByID(int id) throws BadRequestException,NotFoundException;

	public List<DonationCampModel> getAll() throws BadRequestException,NotFoundException;

	public void update(int id, DonationCampModel campModel) throws BadRequestException;

	public List<DonationCampModel> getByAddress(String address)throws BadRequestException,NotFoundException;

}
