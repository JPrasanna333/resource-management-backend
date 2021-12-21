package org.arm.resource.mngt.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.arm.resource.mngt.ArmRMSApplication;
import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ArmRMSApplication.class)
public class CampaignRepositoryTest {

	@Autowired
	private CampaignRepository campaignRepository;

	@Test
	@DisplayName("campaignRepoSave Testing")
	public void testSaveMethod() {
		Campaign campaign= campaignRepository.save(new Campaign(1, "Acheron", "Manager", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2020-03-27 09:03:01"), Timestamp.valueOf("2020-03-27 09:03:01"), 0, "Prasanna",
				"Naveen","IMEA", null));
		assertNotNull(campaign);
	}

	@Test
	@DisplayName("getAllCampaignRepo Testing")
	public void testGetAllResource() {
		List<Campaign> exp = campaignRepository.findAll();
		assertEquals(exp.size(), 4);
	}
}

