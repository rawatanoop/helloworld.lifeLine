package lifeLine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lifeLine.orm.entity.DonationCampVolunteer;

@Repository
public class VolunteerDao implements IVolunteerDao<DonationCampVolunteer> {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	@Transactional
	public void save(DonationCampVolunteer volunteer) {
		getSession().save(volunteer);
		return;
	}

	@Transactional
	public void delete(DonationCampVolunteer volunteer) {
		getSession().delete(volunteer);
		return;
	}

	@Transactional
	public DonationCampVolunteer getById(Integer id) {
		DonationCampVolunteer volunteer = (DonationCampVolunteer) getSession().load(DonationCampVolunteer.class, id);
		return volunteer;
	}

	@Transactional
	public void update(int id, DonationCampVolunteer volunteer) {
		getSession().update(volunteer);
		return;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<DonationCampVolunteer> getAllByCampID(int campID) {
		List<DonationCampVolunteer> volunteers = (List<DonationCampVolunteer>) getSession()
				.getNamedQuery("DonationCampVolunteer.findByCampID").setInteger("campID", campID).list();
		return volunteers;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<DonationCampVolunteer> getAllByUserID(int userID) {
		List<DonationCampVolunteer> volunteers = (List<DonationCampVolunteer>) getSession()
				.getNamedQuery("DonationCampVolunteer.findByUserID").setInteger("userID", userID).list();
		return volunteers;
	}

	@Deprecated
	public List<DonationCampVolunteer> getAll() {

		return null;
	}

}
