package com.cse.sportsplus.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cse.sportsplus.models.Academy;
import com.cse.sportsplus.repository.AcademyRepository;


@RestController
@RequestMapping("/academy") 
public class AcademyController {
	
	@Autowired
	private AcademyRepository academyRepository;
	
	
	@PostMapping("/add")
	public Academy addAcademy(@RequestBody Academy academy) {
		return academyRepository.save(academy);
	}
	
	@GetMapping("/getAll")
	public List<Academy> getAll() {
		return academyRepository.findAll();
	}
	@PostMapping("/delete")
	public List<Academy> deleteAcademy(@RequestBody Academy academy) {
		String name=academy.getName();
		Academy d= academyRepository.findByName( name);
		academyRepository.delete(d);
		List <Academy> list_of_academies = academyRepository.findAll();
		return list_of_academies;
		
	}
	@PostMapping("/update")
	public List<Academy> updateAcademy(@RequestBody Academy academy) {
		Academy d ;
		d=academyRepository.findByName(academy.getName());
		academyRepository.delete(d);
		academyRepository.save(academy);
		List <Academy> list_of_academies = academyRepository.findAll();
		return list_of_academies;
		
		
	}
	
	
	
	

}

