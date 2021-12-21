package org.arm.resource.mngt.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.util.List;

import org.arm.resource.mngt.ArmRMSApplication;
import org.arm.resource.mngt.entity.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ArmRMSApplication.class)
public class ResourceRepositoryTest {
	
	@Autowired
	private ResourceRepository resourceRepository;

	@Test
	@DisplayName("resourceRepoSave Testing")
	public void testSaveMethod() {
		Resource resource=resourceRepository.save(new Resource(1, "Navin", "Manager", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), 0, null, "resource.jpj", "Madras", null, null));
		assertNotNull(resource);
	}

	@Test
	@DisplayName("getAllReourceRepo Testing")
	public void testGetAllResource() {
		List<Resource> exp = resourceRepository.findAll();
		assertEquals(exp.size(), 28);
	}

}
