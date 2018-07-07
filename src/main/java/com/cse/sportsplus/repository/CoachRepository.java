package com.cse.sportsplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cse.sportsplus.models.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

}
