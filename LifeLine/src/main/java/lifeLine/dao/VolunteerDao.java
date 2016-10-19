package lifeLine.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lifeLine.orm.entity.DonationCampVolunteer;

@Repository
@Transactional
public class VolunteerDao  {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	public void save(DonationCampVolunteer volunteer) {
		getSession().save(volunteer);
		return;
	}

	public void delete(DonationCampVolunteer volunteer) {
		getSession().delete(volunteer);
		return;
	}

	@Transactional
	public DonationCampVolunteer getById(Integer id) {
		DonationCampVolunteer volunteer = (DonationCampVolunteer) getSession().load(DonationCampVolunteer.class, id);
		return volunteer;
	}

	public void update(int id, DonationCampVolunteer volunteer) {
		getSession().update(volunteer);
		return;
	}

	@SuppressWarnings("unchecked")
	public List<DonationCampVolunteer> getAllByCampID(int campID) {
		List<DonationCampVolunteer> volunteers = (List<DonationCampVolunteer>) getSession()
				.getNamedQuery("DonationCampVolunteer.findByCampID").setInteger("campID", campID).list();
		return volunteers;
	}

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
