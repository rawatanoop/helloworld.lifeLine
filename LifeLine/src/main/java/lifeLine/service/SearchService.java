package lifeLine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inti.ws.spring.exception.client.NotFoundException;
import lifeLine.model.DonationCampModel;

@Service
public class SearchService implements ISearchService{
	  
	  @Autowired
	  private DonationCampService donationCampService;
	  
	 public List<DonationCampModel>getAllDonationCamps() throws NotFoundException{
		 return donationCampService.getAll();
	 }
	 
	 public List<DonationCampModel>getDonationCampByArea(String area) throws NotFoundException{
		 return donationCampService.getByAddress(area);
	 }
	 
	 @Deprecated
	 public List<DonationCampModel>getDonationCampNearBy(String address){
		 return null;
	 }

}
