package com.cse.sportsplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cse.sportsplus.models.Athlete;
import com.cse.sportsplus.models.Athlete;
import com.cse.sportsplus.repository.AthleteRepository;
import com.cse.sportsplus.repository.CoachRepository;

@RestController
@RequestMapping("/Athlete")
public class AthleteController {
	
	@Autowired
	private AthleteRepository arepo;
	
	@Autowired
	private CoachRepository coachRepo;
	
	
	@GetMapping("/getallAthlete")
	public List<Athlete> AthleteList()
	{
	
		List<Athlete> a1=arepo.findAll();
		return a1;
	
	}
	

	@PostMapping("/addAthlete")
	public Athlete AthleteAdd(@RequestBody Athlete Athlete)
	{
		
		arepo.saveAndFlush(Athlete);
		
		return Athlete;
	}
	@PostMapping("/deleteAthlete")
	public Athlete AthleteDelete(@RequestBody Athlete athlete)
	{
		arepo.deleteById(athlete.getId());
		return athlete;
	}
	@PostMapping("/AthleteUpdate")
	 public Athlete AthleteUpdate(@RequestBody Athlete Athlete)
	 {
		 return Athlete;
		 
	 }
	 @GetMapping("/AthleteByName/{name}")
    public Athlete getAthleteByName(@PathVariable(value ="name" ) String name){
	    return arepo.findByFirstName(name);
     }
	 
	 @GetMapping("/coachByGroupID")
	 public List<java.math.BigInteger> getCoachID(@RequestParam Long group_id){
		 return coachRepo.getAllCoachIDByGroupID(group_id);
	 }
	 @GetMapping("/athleteByID")
	 public Athlete getByID(@RequestParam Long id) {
		 return arepo.findAth(id);
	 }
	 

}
