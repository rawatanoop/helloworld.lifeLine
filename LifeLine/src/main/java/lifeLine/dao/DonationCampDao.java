package lifeLine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lifeLine.orm.entity.DonationCamp;

@Repository
public class DonationCampDao implements IDonationCampDao<DonationCamp>{
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(DonationCamp camp) {
    getSession().save(camp);
  }
  
  public void delete(DonationCamp camp) {
    getSession().delete(camp);
  }
  
  @SuppressWarnings("unchecked")
  public List<DonationCamp> getAll() {    
	  return getSession().createQuery("from DonationCamp").list();
  }
 
  public DonationCamp getById(Integer id) {
	  DonationCamp camp = (DonationCamp) getSession().load(DonationCamp.class, id);
	  camp.getUnit();
	  camp.getAddress();
    return camp;
  }

  public void update(int id,DonationCamp camp) {
    getSession().update(camp);
    return;
  }

public List<DonationCamp> getByAddress(String address) {
	@SuppressWarnings("unchecked")
	List<DonationCamp> camps = (List<DonationCamp>) getSession()
			.getNamedQuery("DonationCamp.findByAddress").setString("address", address).list();
	return camps;
}



}
