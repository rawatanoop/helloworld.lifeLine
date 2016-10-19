package lifeLine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lifeLine.model.DonationCampModel;

@Service
public class SearchService {
	  
	  @Autowired
	  private DonationCampService donationCampService;
	  
	 public List<DonationCampModel>getAllDonationCamps(){
		 return donationCampService.getAll();
	 }
	 
	 public List<DonationCampModel>getDonationCampByArea(String area){
		 return donationCampService.getByAddress(area);
	 }
	 
	 @Deprecated
	 public List<DonationCampModel>getDonationCampNearBy(String address){
		 return null;
	 }

}
