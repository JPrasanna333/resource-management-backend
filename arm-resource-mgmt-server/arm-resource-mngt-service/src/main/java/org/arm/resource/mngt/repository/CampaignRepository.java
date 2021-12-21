package org.arm.resource.mngt.repository;

import java.sql.Timestamp;
import java.util.List;

import org.arm.resource.mngt.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

	@Query(value = ("select * from campaign c left join project p on p.campaign_id=c.campaign_id left join task t on t.project_id=p.project_id right join resource r on t.resource_id=r.resource_id"),nativeQuery=true)
	List<Campaign> findAllResourcesCampaignDetails();
	
	@Query(value=("SELECT * from arm.campaign where\r\n"
			+ "(start_date BETWEEN ?1 AND ?2) OR \r\n"
			+ "(end_date BETWEEN ?1 AND ?2) OR \r\n"
			+ "(start_date <= ?1 AND end_date >= ?2);"),nativeQuery=true)
	List<Campaign> getCamapignOfMonth(Timestamp startDate, Timestamp endDate);
//	List<Campaign> findByStartDateGreaterThanAndEndDateLessThan()
}
