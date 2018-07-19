package com.cse.sportsplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cse.sportsplus.models.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

	@Query(value="select coach_id from tbl_coach", nativeQuery=true)
	public List<java.math.BigInteger>getAllCoachID();
	
	
}
