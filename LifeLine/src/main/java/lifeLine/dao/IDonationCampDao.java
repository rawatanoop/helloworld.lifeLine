package lifeLine.dao;

import java.util.List;

import lifeLine.orm.entity.DonationCamp;

public interface IDonationCampDao<DC> {

	public List<DonationCamp> getByAddress(String address);
}
