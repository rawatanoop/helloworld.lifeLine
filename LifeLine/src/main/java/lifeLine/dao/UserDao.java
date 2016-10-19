package lifeLine.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import lifeLine.orm.entity.User;

@Repository
@Transactional
public class UserDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(User volunteer) {
    getSession().save(volunteer);
    return;
  }
  
  public void delete(User user) {
    getSession().delete(user);
    return;
  }
  
  @SuppressWarnings("unchecked")
public List<User> getAllUsers() {    
	  return getSession().createQuery("from User").list();
  }
  
  @Transactional
  public User getById(Integer userID) {
	  User user = (User) getSession().load(User.class, userID);
    return user;
  }

  public void update(int userID,User user) {
    getSession().update(user);
    return;
  }

}
