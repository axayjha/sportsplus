package com.cse.sportsplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cse.sportsplus.models.Athlete;
import com.cse.sportsplus.models.Athlete;
import com.cse.sportsplus.repository.AthleteRepository;
import com.cse.sportsplus.repository.CoachRepository;

@RestController
@RequestMapping("/Athlete") //class level mapping
public class AthleteController {
	
	@Autowired //implements IOC
	private AthleteRepository arepo;
	
	@Autowired
	private CoachRepository coachRepo;
	
	//Display data of existing athletes
	@GetMapping("/getallAthlete")
	public List<Athlete> AthleteList()
	{
	
		List<Athlete> a1=arepo.findAll();
		return a1;
	
	}
	
	//Add new athlete data
	@PostMapping("/addAthlete")
	public Athlete AthleteAdd(@RequestBody Athlete Athlete)
	{
		
		arepo.saveAndFlush(Athlete);
		
		return Athlete;
	}
	
	//Delete specific athlete
	@PostMapping("/deleteAthlete")
	public Athlete AthleteDelete(@RequestBody Athlete athlete)
	{
		arepo.deleteById(athlete.getId());
		return athlete;
	}
	
	//Update records of existing athlete
	@PostMapping("/AthleteUpdate")
	 public Athlete AthleteUpdate(@RequestBody Athlete Athlete)
	 {
		 return Athlete;
		 
	 }
	
	//Get details of athlete by his/her name
	 @GetMapping("/AthleteByName/{name}")
    public Athlete getAthleteByName(@PathVariable(value ="name" ) String name){
	    return arepo.findByFirstName(name);
     }
	 
	//Display Coach by Group ID
	 @GetMapping("/coachByGroupID")
	 public List<java.math.BigInteger> getCoachID(@RequestParam Long group_id){
		 return coachRepo.getAllCoachIDByGroupID(group_id);
	 }
	
	//Display athlete by athlete ID
	 @GetMapping("/athleteByID")
	 public Athlete getByID(@RequestParam Long id) {
		 return arepo.findAth(id);
	 }
	 

}
