package lifeLine.dao;

import java.util.List;

public interface IDonationCampDao<DC> extends IDao<DC> {

	public List<DC> getByAddress(String address);
}
