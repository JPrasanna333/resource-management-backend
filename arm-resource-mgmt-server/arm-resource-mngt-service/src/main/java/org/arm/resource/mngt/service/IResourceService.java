package org.arm.resource.mngt.service;

import java.util.List;
import org.arm.resource.mngt.entity.Resource;
import org.arm.resource.mngt.exception.IDNotFoundException;
import org.arm.resource.mngt.exception.ResourceNotFoundException;

public interface IResourceService {
	public void save(Resource resource);

	public List<Resource> findAll() throws ResourceNotFoundException;

	Resource getById(int id) throws IDNotFoundException ;

	List<Resource> findResourceWithoutTaskAssigned() throws ResourceNotFoundException;
}
