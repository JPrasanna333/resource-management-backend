package org.arm.resource.mngt.repository;

import org.arm.resource.mngt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

}
