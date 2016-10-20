package lifeLine.dao;

import java.util.List;


public interface IDao<Entity> {
	
	  public void save(Entity entity) ;
	  
	  public void delete(Entity entity);
	  
	  public List<Entity> getAll() ;
	 
	  public Entity  getById(Integer id);

	  public void update(int id,Entity entity) ;

	  

}
