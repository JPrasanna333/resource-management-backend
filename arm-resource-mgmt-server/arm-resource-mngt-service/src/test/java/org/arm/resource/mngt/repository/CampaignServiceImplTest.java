package org.arm.resource.mngt.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Status;
import org.arm.resource.mngt.exception.IDNotFoundException;
import org.arm.resource.mngt.service.CampaignService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CampaignServiceImplTest {
	@InjectMocks
	private CampaignService campaignService;

	@Mock
	private CampaignRepository campaignRepository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing get all campaign")
	public void testGetAllCampaign() {
		List<Campaign> campaignList = new ArrayList<>();
		Campaign campaign = (new Campaign(1, "Acheron", "Manager", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2020-03-27 09:03:01"), Timestamp.valueOf("2020-03-27 09:03:01"), 0, "Prasanna",
				"Naveen", "NAC", null));
		campaignList.add(campaign);

		when(campaignRepository.findAll()).thenReturn(campaignList);
		List<Campaign> actual = campaignService.getAllCampaign();
		assertEquals(actual.size(), 1);

	}

	@Test
	@DisplayName("Testing get all campaign when no campaign is present")
	public void testGetAllCampaignWhenListisEmpty() {
		when(campaignRepository.findAll()).thenReturn(new ArrayList<Campaign>());
		assertThrows(RuntimeException.class, () -> {
			campaignService.getAllCampaign();
		});

	}

	@Test
	@DisplayName("Testing create campaign")
	public void testCreateCampaign() {
		Campaign campaign = (new Campaign(1, "Acheron", "Manager", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2020-03-27 09:03:01"), Timestamp.valueOf("2020-03-27 09:03:01"), 0, "Prasanna",
				"Naveen", "NAC", null));
		when(campaignRepository.save(campaign)).thenReturn(campaign);
		campaignService.createCampaign(campaign);
		verify(campaignRepository,times(1)).save(campaign);

	}
	@Test
	@DisplayName("Testing findById campaign")
	public void testCampaignById() {
		Campaign campaign = (new Campaign(1, "Acheron", "Manager", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2020-03-27 09:03:01"), Timestamp.valueOf("2020-03-27 09:03:01"), 0, "Prasanna",
				"Naveen", "NAC", null));
		when(campaignRepository.findById(1)).thenReturn(Optional.of(campaign));
		assertEquals(campaignService.getById(1).getCampaignId(), 1);
	}
	@Test
	@DisplayName("Testing findById campaign when id not present")
	public void testCampaignByIdNotFound() {
		when(campaignRepository.findById(2)).thenReturn(null);
		assertThrows(IDNotFoundException.class, ()->{
			campaignService.getById(2);
		});

	}

}
