package lifeLine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lifeLine.orm.entity.DonationCamp;

@Repository
public class DonationCampDao /*implements IDonationCampDao<DonationCamp> */{

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	@Transactional
	public void save(DonationCamp camp) {
		try {
			Session session = getSession();
			
			//session.beginTransaction();
			session.save(camp);
			//session.flush();
			//session.close();
			//session.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error ....");
		}
		// Transaction txn = getSession().beginTransaction();
		
		//txn.commit();
		//getSession().flush();
//		getSession().refresh(camp);
		//getSession().close();
		return ;
	}

	@Transactional
	public void delete(DonationCamp camp) {
		getSession().delete(camp);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<DonationCamp> getAll() {
		return getSession().createQuery("from DonationCamp").list();
	}

	@Transactional
	public DonationCamp getById(Integer id) {
		DonationCamp camp = (DonationCamp) getSession().load(DonationCamp.class, id);
		if(camp.getId()==id)
			return camp;
		return null;
	}

	@Transactional
	public void update(int id, DonationCamp camp) {
		getSession().update(camp);
		return;
	}

	@Transactional
	public List<DonationCamp> getByAddress(String address) {
		@SuppressWarnings("unchecked")
		List<DonationCamp> camps = (List<DonationCamp>) getSession().getNamedQuery("DonationCamp.findByAddress")
				.setString("address", address).list();
		return camps;
	}

}
