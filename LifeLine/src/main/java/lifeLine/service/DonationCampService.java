package lifeLine.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.NotFoundException;
import lifeLine.dao.DonationCampDao;
import lifeLine.dao.IDonationCampDao;
import lifeLine.model.DonationCampModel;
import lifeLine.orm.entity.DonationCamp;

@Service
public class DonationCampService /*implements IDonationCampService*/{

	@Autowired
	private DonationCampDao dcDao;

	public void delete(int id) throws BadRequestException {
		if (isValidID(id))
			dcDao.delete(new DonationCamp(id));
		throw new BadRequestException(IService.InvalidID);

	}

	public void create(DonationCampModel campModel) {
		DonationCamp camp = getEntity(campModel);
		dcDao.save(camp);
		//System.out.println("");
		int a =0;
	}

	public DonationCampModel getByID(int id) throws BadRequestException {
		if (isValidID(id))
			return getModel(dcDao.getById(id));
		else
			throw new BadRequestException(IService.InvalidID);

	}

	public List<DonationCampModel> getAll() throws NotFoundException {
		List<DonationCamp> list = dcDao.getAll();
		if (list == null)
			throw new NotFoundException(IService.NotFound);

		return getModelList(list);

	}

	public void update(int id, DonationCampModel campModel) throws BadRequestException {
		if (!isValidID(id))
			throw new BadRequestException(IService.InvalidID);
		DonationCamp camp = getEntity(campModel);
		dcDao.update(id, camp);
	}

	private List<DonationCampModel> getModelList(List<DonationCamp> entityList) {
		List<DonationCampModel> list = new ArrayList<DonationCampModel>();
		for (Iterator<DonationCamp> iterator = entityList.iterator(); iterator.hasNext();) {
			list.add(getModel(iterator.next()));

		}
		return list;

	}

	public List<DonationCampModel> getByAddress(String address) throws NotFoundException {
		List<DonationCamp> list = dcDao.getByAddress(address);
		if(list==null)
			throw new NotFoundException(IService.NotFound);
		return getModelList(dcDao.getByAddress(address));
	}

	private DonationCampModel getModel(DonationCamp entity) {
		DonationCampModel model = new DonationCampModel();
		model.setId(entity.getId());
		model.setUserID(entity.getUserID());
		model.setCampCategoryID(entity.getCampCategoryID());
		model.setAddress(entity.getAddress());
		model.setStartDate(entity.getStartDate());
		model.setEndDate(entity.getEndDate());
		model.setUnit(entity.getUnit());
		model.setUnitLeft(entity.getUnitLeft());
		return model;

	}

	private DonationCamp getEntity(DonationCampModel model) {
		DonationCamp entity = new DonationCamp();
		entity.setId(model.getId());
		entity.setUserID(model.getUserID());
		entity.setCampCategoryID(model.getCampCategoryID());
		entity.setStartDate(model.getStartDate());
		entity.setEndDate(model.getEndDate());
		entity.setAddress(model.getAddress());
		entity.setUnit(model.getUnit());
		entity.setUnitLeft(model.getUnitLeft());
		return entity;

	}

	private boolean isValidID(int id) {
		if (id > 0)
			return true;
		return false;

	}

}
