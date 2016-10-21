package lifeLine.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.management.BadAttributeValueExpException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inti.ws.spring.exception.client.BadRequestException;
import lifeLine.dao.IVolunteerDao;
import lifeLine.dao.VolunteerDao;
import lifeLine.model.VolunteerModel;
import lifeLine.orm.entity.DonationCampVolunteer;
import lifeLine.orm.entity.DonationCampVolunteerPK;

@Service
public class VolunteerService implements IVolunteerService {

	@Autowired
	private IVolunteerDao<DonationCampVolunteer> dcVolunteerDao;

	public void delete(int id) throws BadAttributeValueExpException {
		if (!isVAalidID(id))
			throw new BadAttributeValueExpException(IService.InvalidID);

		DonationCampVolunteer volunteer = new DonationCampVolunteer(new DonationCampVolunteerPK());
		dcVolunteerDao.delete(volunteer);
	}

	public void create(VolunteerModel volunteer) {

		dcVolunteerDao.save(getEntity(volunteer));
	}

	public List<VolunteerModel> getByUserID(int id) throws BadRequestException {
		if (!isVAalidID(id))
			throw new BadRequestException(IService.InvalidID);
		return getModelList(dcVolunteerDao.getAllByCampID(id));

	}

	public List<VolunteerModel> getByCampID(int id) throws BadRequestException {
		if (!isVAalidID(id))
			throw new BadRequestException(IService.InvalidID);
		return getModelList(dcVolunteerDao.getAllByCampID(id));
	}

	public void update(int id, VolunteerModel volunteer) throws BadRequestException {
		if (!isVAalidID(id))
			throw new BadRequestException(IService.InvalidID);
		dcVolunteerDao.update(id, getEntity(volunteer));

	}

	private VolunteerModel getModel(DonationCampVolunteer entity) {
		VolunteerModel model = new VolunteerModel();
		model.setUserID(entity.getDonationCampVolenteerPK().getUserID());
		model.setCampID(entity.getDonationCampVolenteerPK().getCampID());
		model.setRequestStatus(entity.getRequestStatus());
		return model;

	}

	private DonationCampVolunteer getEntity(VolunteerModel model) {
		DonationCampVolunteer entity = new DonationCampVolunteer(
				new DonationCampVolunteerPK(model.getUserID(), model.getCampID()));
		entity.setRequestStatus(model.getRequestStatus());
		return entity;
	}

	private List<VolunteerModel> getModelList(List<DonationCampVolunteer> entityList) {
		List<VolunteerModel> list = new ArrayList<VolunteerModel>();
		for (Iterator<DonationCampVolunteer> iterator = entityList.iterator(); iterator.hasNext();) {
			list.add(getModel(iterator.next()));

		}
		return list;

	}

	private boolean isVAalidID(int id) {
		return true;

	}
}
