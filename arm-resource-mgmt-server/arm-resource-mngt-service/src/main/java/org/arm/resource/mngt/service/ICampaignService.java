package org.arm.resource.mngt.service;

import java.sql.Timestamp;
import java.util.List;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.exception.CampaignNotFoundException;
import org.arm.resource.mngt.exception.IDNotFoundException;

public interface ICampaignService {

	public List<Campaign> getAllCampaign() throws CampaignNotFoundException;

	public void createCampaign(Campaign campaign);

	public Campaign getById(int l) throws IDNotFoundException;
	
	List<Campaign> getAllResourcesCampaignDetails() throws CampaignNotFoundException;
	
	public Campaign addCampaign(Campaign campaign);
	
	List<Campaign> getCamapignOfMonth(Timestamp startDate, Timestamp endDate);
}
