package lifeLine.dao;

import java.util.List;

public interface IVolunteerDao<V> extends IDao<V> {

	public List<V> getAllByCampID(int campID);

	public List<V> getAllByUserID(int userID);

}
