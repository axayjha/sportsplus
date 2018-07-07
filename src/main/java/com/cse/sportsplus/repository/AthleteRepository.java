package com.cse.sportsplus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cse.sportsplus.models.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
	Optional<Athlete> findById(Long id);
	Athlete findByFirstName(String s);
}
