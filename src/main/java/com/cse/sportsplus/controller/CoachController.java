package com.cse.sportsplus.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cse.sportsplus.models.Coach;
import com.cse.sportsplus.repository.CoachRepository;


@RestController
@RequestMapping("/coach") //Class level mapping
public class CoachController {
	
	@Autowired //implements IOC
	private CoachRepository coachRepository;
	
	//Add new Coach
	@PostMapping("/create")
	public Coach coachCreate(@RequestBody Coach coach) {
		Coach coh = coachRepository.save(coach);
		return coh;
	}
	
	//Display details of existing coaches
	@GetMapping("/all")
	public List<Coach> coachList() {
		List<Coach> coaches = coachRepository.findAll();
		return coaches;
	}
	
	//Delete specific coach data
	@PostMapping("/delete")
	public void coachDelete(@RequestBody Coach cid) {
		coachRepository.deleteById(cid.getCoach_id());
	}
	
	//Update existing coach record
	@PostMapping("/update")
	public Coach coachUpdate(@RequestBody Coach coach) {
		Coach coh = coachRepository.save(coach); // note that given coach_id must be present
		return coh;
	}
	
}
