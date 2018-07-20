package com.cse.sportsplus.repository;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cse.sportsplus.models.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

	@Query(value="select coach_id from tbl_coach", nativeQuery=true)
	public List<java.math.BigInteger>getAllCoachID();
	
	@Query(value="select coach_coach_id from group_tbl_coach where groups_group_id = ?", nativeQuery=true)
	public List<java.math.BigInteger> getAllCoachIDByGroupID(Long group_id);
	
	@Modifying
	@Query(value="delete from group_tbl_coach where groups_group_id in ?",nativeQuery=true)
	@Transactional
	public void deleteJoinData(Set<Long> gid);
	
	@Modifying
	@Query(value="delete from tbl_coach where coach_id in ?" , nativeQuery=true)
	@Transactional
	public void deleteCoach(Set<Long> c_id);
	
	
}
