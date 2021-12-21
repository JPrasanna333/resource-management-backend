package org.arm.resource.mngt.repository;

import java.util.List;

import org.arm.resource.mngt.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	List<Project> findByCampaignCampaignId(int campaignId);
}
