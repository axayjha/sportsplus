package com.cse.sportsplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cse.sportsplus.models.Academy;


public interface AcademyRepository extends JpaRepository<Academy, Long> {
 @Query
 Academy findByName(String name );
 
 
 
 
 
 
 //Required for Schedule
 @Query(value="select Academy_id from academy_table",nativeQuery=true)
 public List<java.math.BigInteger> getAllAcademyID();
 
}