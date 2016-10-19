package lifeLine.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import lifeLine.orm.entity.DonationCamp;

@Repository
@Transactional
public class DonationCampDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(DonationCamp camp) {
    getSession().save(camp);
    return;
  }
  
  public void delete(DonationCamp camp) {
    getSession().delete(camp);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<DonationCamp> getAll() {    
	  return getSession().createQuery("from DonationCamp").list();
  }
 
  @Transactional
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

}
