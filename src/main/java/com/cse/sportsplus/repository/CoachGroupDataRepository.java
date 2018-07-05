package com.cse.sportsplus.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cse.sportsplus.models.CoachGroupData;



public interface CoachGroupDataRepository extends JpaRepository<CoachGroupData, Long> {
	List<CoachGroupData> findByGroupId(long id);
	
	@Transactional
	void deleteByGroupId(long groupId);
}
