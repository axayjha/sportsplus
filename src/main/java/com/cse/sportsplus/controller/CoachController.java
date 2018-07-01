package com.cse.sportsplus.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cse.sportsplus.models.Coach;
import com.cse.sportsplus.repository.CoachRepository;


@RestController
@RequestMapping("/coach")
public class CoachController {
	
	@Autowired
	private CoachRepository coachRepository;
	
	@PostMapping("/create")
	public Coach coachCreate(@RequestBody Coach coach) {
		Coach coh = coachRepository.save(coach);
		return coh;
	}
	
	@GetMapping("/all")
	public List<Coach> coachList() {
		List<Coach> coaches = coachRepository.findAll();
		return coaches;
	}
	
}
