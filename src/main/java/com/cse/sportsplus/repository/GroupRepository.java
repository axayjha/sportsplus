package com.cse.sportsplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cse.sportsplus.models.Group;

public interface GroupRepository extends JpaRepository<Group,Long>
{
	Group findByGroupName(String name);
	
	Group findByGroupID(Long groupId);
}
