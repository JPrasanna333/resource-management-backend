package org.arm.resource.mngt.api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.entity.Project;
import org.arm.resource.mngt.entity.Resource;
import org.arm.resource.mngt.entity.Task;
import org.arm.resource.mngt.exception.CampaignNotFoundException;
import org.arm.resource.mngt.exception.IDNotFoundException;
import org.arm.resource.mngt.service.ICampaignService;
import org.arm.resource.mngt.service.IResourceService;
import org.arm.resource.mngt.vo.CampaignVO;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampaignController {
	@Autowired
	private ICampaignService campaignService;
	
	@Autowired
	private IResourceService resourceService;

	Logger logger = LoggerFactory.getLogger(CampaignController.class);

	/**
	 * gets all campaigns with project,task,resource(if available) 
	 * and filtering unwanted columns i.e., using CampaignVO
	 * @return list of campaignVO objects as response entity
	 */
	 @GetMapping("/campaigns")
	public ResponseEntity<List<CampaignVO>> allCampaignVO() {
		logger.warn("Inside Campaign Controller");
		logger.info("All Campaign inside controller");
		List<CampaignVO> campaignVOs = new ArrayList<CampaignVO>();
		List<Campaign> allCampaigns = campaignService.getAllCampaign();
		for (Campaign campaign : allCampaigns) {
			DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
			dozerBeanMapper.setMappingFiles(Arrays.asList("mapping\\mapper.xml"));
			CampaignVO campaignVO = dozerBeanMapper.map(campaign, CampaignVO.class);
			campaignVOs.add(campaignVO);

		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get All Campaign List");
		return ResponseEntity.ok().headers(headers).body(campaignVOs);
	}

	/**
	 * gets campaign by id
	 * @param id
	 * @return Campaign object as response entity 
	 * @throws IDNotFoundException
	 */
	@GetMapping("/campaign/{id}")
	public ResponseEntity<Campaign> findById(@PathVariable("id") int id)throws IDNotFoundException{
		Campaign campaignById=campaignService.getById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Campaign By ID");
		return ResponseEntity.ok().headers(headers).body(campaignById);
	}

	/**
	 * gets all resources i.e., allocated and non allocated resources as CampaignVO(top level object) 
	 * and filtering unwanted columns i.e., using CampaignVO
	 * @return list of campaignVO objects as response entity
	 * @throws CampaignNotFoundException
	 */
	@GetMapping("/campaigns/resources")
	public ResponseEntity<List<CampaignVO>> allResources() throws CampaignNotFoundException{

		List<Campaign> allCampaigns = campaignService.getAllCampaign();
		List<CampaignVO> campaignVOs = new ArrayList<CampaignVO>();
		List<Resource> allNotAssignedResource = resourceService.findResourceWithoutTaskAssigned();
		List<Campaign> campaignList = new ArrayList<>();
		
		//setting null to campaign,project,task to all non-allocated resources
		//in order to merge two list and make it as top level CampaignVO object
		allNotAssignedResource.forEach((resource) -> {
			Task task = new Task(0, null, null, null, null, 0, null, null, null, null, 0, null, null, null, resource);
			Set<Task> taskSet = new HashSet<>(Arrays.asList(task));
			Project project = new Project(0, null, null, null, null, null, null, null, null, 0, null, null, null,
					taskSet);
			Set<Project> projectsSet = new HashSet<>(Arrays.asList(project));
			Campaign campaign = new Campaign(0, null, null, null, null, null, null, null, null, 0, null, null,
					null, projectsSet);
			campaignList.add(campaign);
		});
		allCampaigns.addAll(campaignList);
		for (Campaign campaign : allCampaigns) {
			DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
			dozerBeanMapper.setMappingFiles(Arrays.asList("mapping\\mapper.xml"));
			CampaignVO campaignVO = dozerBeanMapper.map(campaign, CampaignVO.class);
			campaignVOs.add(campaignVO);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get All resources with campaign details");
		return ResponseEntity.ok().headers(headers).body(campaignVOs);
	}
	
	
	@PostMapping("/campaigns")
	public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Adding a Campaign");
		return ResponseEntity.ok().headers(headers).body(campaignService.addCampaign(campaign));
		
	}
	
	
	@GetMapping("/campaign/start-date/{start-date}/end-date/{end-date}")
	public ResponseEntity<List<Campaign>> getCampaignDetailsByMonth(@PathVariable("start-date") String startDate, @PathVariable("end-date") String endDate)throws IDNotFoundException{
		System.out.println(startDate);
		Timestamp str= Timestamp.valueOf(startDate);
		Timestamp endD= Timestamp.valueOf(endDate);
		List<Campaign> campaignById=campaignService.getCamapignOfMonth(str, endD);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Campaign By ID");
		return ResponseEntity.ok().headers(headers).body(campaignById);
	}
	
}
