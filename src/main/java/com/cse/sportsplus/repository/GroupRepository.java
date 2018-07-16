package com.cse.sportsplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cse.sportsplus.models.Group;

public interface GroupRepository extends JpaRepository<Group,Long>
{
	Group findByGroupName(String name);
	
	Group findByGroupID(Long groupId);
	
	
	
	
	
	
	@Query(value= "select groupID from group_tbl", nativeQuery=true)
	List<java.math.BigInteger> getAllID();
	
	@Modifying
	@Query(value = "insert into group_coach values (?, ?)", nativeQuery=true)
	@Transactional
	public void addGroupAndCoach(java.math.BigInteger a, java.math.BigInteger b);
	
}
