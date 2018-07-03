package com.cse.sportsplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cse.sportsplus.models.Athlete;
import com.cse.sportsplus.models.Athlete;
import com.cse.sportsplus.repository.AthleteRepository;

@RestController
@RequestMapping("/Athlete")
public class AthleteController {
	
	@Autowired
	private AthleteRepository arepo;
	@GetMapping("/getallAthlete")
	public List<Athlete> AthleteList()
	{
	
		return arepo.findAll();
	
	}
	

	@PostMapping("/addAthlete")
	public Athlete AthleteAdd(@RequestBody Athlete Athlete)
	{
		arepo.saveAndFlush(Athlete);
		
		return Athlete;
	}
	@PostMapping("/deleteAthlete")
	public Athlete AthleteDelete(@RequestBody Athlete Athlete)
	{
		
		
		return Athlete;
	}
	@PostMapping("/AthleteUpdate")
	 public Athlete AthleteUpdate(@RequestBody Athlete Athlete)
	 {
		 return Athlete;
		 
	 }

}
