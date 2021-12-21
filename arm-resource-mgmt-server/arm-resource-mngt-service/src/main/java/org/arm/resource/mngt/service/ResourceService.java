package org.arm.resource.mngt.service;

import java.util.List;
import java.util.Optional;

import org.arm.resource.mngt.entity.Resource;
import org.arm.resource.mngt.exception.IDNotFoundException;
import org.arm.resource.mngt.exception.ResourceNotFoundException;
import org.arm.resource.mngt.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService implements IResourceService {

	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public void save(Resource resource) {
		resourceRepository.save(resource);
	}

	public List<Resource> findAll() throws ResourceNotFoundException{
		List<Resource> resourceList = resourceRepository.findAll();
		if (resourceList.isEmpty())
			throw new ResourceNotFoundException("Resource Not Available.. ");
		return resourceList;
	}

	@Override
	public List<Resource> findResourceWithoutTaskAssigned() throws ResourceNotFoundException {

		List<Resource> allResource = resourceRepository.getResourceWithoutTaskAssigned();
		if (allResource.isEmpty())
			throw new ResourceNotFoundException("No resource Available.. ");
		return allResource;
	}

	@Override
	public Resource getById(int id)  throws IDNotFoundException{
		Optional<Resource> resourceById= resourceRepository.findById(id);
		if(resourceById==null) {
			throw new IDNotFoundException("No Id Found");
		}
		return resourceById.get();
	}
}
