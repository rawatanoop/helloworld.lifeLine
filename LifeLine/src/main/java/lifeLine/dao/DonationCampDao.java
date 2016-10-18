package lifeLine.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 

  public DonationCamp getById(int id) {
    return (DonationCamp) getSession().load(DonationCamp.class, id);
  }

  public void update(DonationCamp camp) {
    getSession().update(camp);
    return;
  }

}
