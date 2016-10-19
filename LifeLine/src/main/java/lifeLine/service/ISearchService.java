package lifeLine.service;

import java.util.List;

import inti.ws.spring.exception.client.BadRequestException;
import lifeLine.model.DonationCampModel;

public interface ISearchService {
	  

	  
	 public List<DonationCampModel>getAllDonationCamps()throws BadRequestException;
	 
	 public List<DonationCampModel>getDonationCampByArea(String area)throws BadRequestException;
	 
	 
	 public List<DonationCampModel>getDonationCampNearBy(String address)throws BadRequestException;

}
