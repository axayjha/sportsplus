package com.cse.sportsplus.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cse.sportsplus.models.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

	@Query(value="select coach_id from tbl_coach", nativeQuery=true)
	public List<java.math.BigInteger>getAllCoachID();
	
	@Query(value="select DISTINCT(coach_coach_id) from group_tbl_coach where groups_group_id = ?", nativeQuery=true)
	public List<java.math.BigInteger> getAllCoachIDByGroupID(Long group_id);
	
	@Modifying
	@Query(value="delete from group_tbl_coach where groups_group_id in (?1)",nativeQuery=true)
	@Transactional
	public void deleteJoinData(List<BigInteger> c_id);
	
	@Modifying
	@Query(value="delete from tbl_coach where coach_id in (?1)" , nativeQuery=true)
	@Transactional
	public void deleteCoach(List<java.math.BigInteger> c_id);
	
	
}
