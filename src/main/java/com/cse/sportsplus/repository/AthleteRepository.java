package com.cse.sportsplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cse.sportsplus.models.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {

}
