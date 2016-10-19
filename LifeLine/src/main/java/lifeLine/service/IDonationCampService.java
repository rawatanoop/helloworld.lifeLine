package lifeLine.service;

import java.util.List;

import inti.ws.spring.exception.client.BadRequestException;
import lifeLine.model.DonationCampModel;

public interface IDonationCampService {

	public String delete(int id) throws BadRequestException;

	public String create(DonationCampModel campModel) throws BadRequestException;

	public DonationCampModel getByID(int id) throws BadRequestException;

	public List<DonationCampModel> getAll() throws BadRequestException;

	public void update(int id, DonationCampModel campModel) throws BadRequestException;

	public List<DonationCampModel> getByAddress(String address);

}
