package com.cse.sportsplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cse.sportsplus.models.Academy;


public interface AcademyRepository extends JpaRepository<Academy, Long> {
 
 Academy findByAcademy_Name(String name );
 
}