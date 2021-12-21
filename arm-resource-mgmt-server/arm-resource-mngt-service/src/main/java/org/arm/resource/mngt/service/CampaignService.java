package org.arm.resource.mngt.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.exception.CampaignNotFoundException;
import org.arm.resource.mngt.exception.IDNotFoundException;
import org.arm.resource.mngt.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService implements ICampaignService {
	@Autowired
	CampaignRepository campaignRepository;

	public List<Campaign> getAllCampaign() throws CampaignNotFoundException {
		 List<Campaign> allCampaign= campaignRepository.findAll();
			if(allCampaign.isEmpty()) {
				throw new CampaignNotFoundException("No campaign found");
			}
			return allCampaign;

	}

	@Override
	public void createCampaign(Campaign campaign) {
		campaignRepository.save(campaign); 
	}

	@Override
	public Campaign getById(int id) throws IDNotFoundException{
		Optional<Campaign> campaignById=campaignRepository.findById(id);
		if(campaignById==null) {
			throw new IDNotFoundException("Id not found");
		}
		return campaignById.get();
	}
	
	@Override
	public List<Campaign> getAllResourcesCampaignDetails()throws CampaignNotFoundException {
		List<Campaign> campaignList= campaignRepository.findAllResourcesCampaignDetails();
		if(campaignList.isEmpty())
		{
			throw new CampaignNotFoundException("No campaign found");
		}
		return campaignList;
	}
	public Campaign addCampaign(Campaign campaign){
		Campaign campaignAdded= campaignRepository.save(campaign);
		if(campaignAdded==null)
			throw new RuntimeException("campaign cannot be added");
		return campaignAdded;
	}
	public List<Campaign> getCamapignOfMonth(Timestamp startDate, Timestamp endDate){
		return campaignRepository.getCamapignOfMonth(startDate, endDate);
	}
}
