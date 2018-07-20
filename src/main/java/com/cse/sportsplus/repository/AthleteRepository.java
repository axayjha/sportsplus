package com.cse.sportsplus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cse.sportsplus.models.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
	@Query(value="select * from athlete_tbl where id=?", nativeQuery=true)
	Athlete findAth(Long id);
	
	Athlete findByFirstName(String s);
}
