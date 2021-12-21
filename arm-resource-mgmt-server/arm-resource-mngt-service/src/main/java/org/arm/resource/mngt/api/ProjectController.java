package org.arm.resource.mngt.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.entity.Project;
import org.arm.resource.mngt.exception.IDNotFoundException;
import org.arm.resource.mngt.exception.ProjectNotFoundException;
import org.arm.resource.mngt.service.IProjectService;
import org.arm.resource.mngt.vo.ProjectVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	@Autowired
	private IProjectService projectService;

	/**
	 * gets project by id
	 * @param id
	 * @return Project object as response entity 
	 */
	@GetMapping("/projects/{project-id}")
	Project getById(@PathVariable("project-id") int id) {
		return projectService.getById(id);
	}
	
	@GetMapping("/projects/campaignId/{campaign-id}")
	List<Project> getProjectsOfCampaign(@PathVariable("campaign-id") int campaignId) {
		return projectService.getProjectsOfOneCampiagn(campaignId);
	}

	/**
	 * gets all projects with task,resource(if available) 
	 * and filtering unwanted columns i.e., using ProjectVO
	 * @GetMapping("/projects")
	 * @return list of ProjectVO objects as response entity
	 * @throws IDNotFoundException
	 */
	@GetMapping("/projects")
	public List<ProjectVO> allProjectVO() throws ProjectNotFoundException {
		List<ProjectVO> projectVOs = new ArrayList<ProjectVO>();
		List<Project> allProjects = projectService.getAllProject();
		for (Project project : allProjects) {
			DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
			dozerBeanMapper.setMappingFiles(Arrays.asList("mapping\\mapper.xml"));
			ProjectVO projectVO = dozerBeanMapper.map(project, ProjectVO.class);
			projectVOs.add(projectVO);

		}
		return projectVOs;
	}
	

	
	
	@PostMapping({"/projects/{campaignId}","/projects"})
	public ResponseEntity<Project> addProject(@PathVariable(required = false,value ="campaignId") Integer campaignId, @RequestBody Project project) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Adding a Project");
		return ResponseEntity.ok().headers(headers).body(projectService.addProject(campaignId, project));
	}

}
