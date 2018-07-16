package com.cse.sportsplus.controller;


import java.math.BigInteger;
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
import com.cse.sportsplus.repository.GroupRepository;


@RestController
@RequestMapping("/coach")
public class CoachController {
	
	@Autowired
	private CoachRepository coachRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@PostMapping("/create")
	public Coach coachCreate(@RequestBody Coach coach) {
		Coach coh = coachRepository.save(coach);
		groupRepository.addGroupAndCoach(BigInteger.valueOf(coach.getGroup_id()), BigInteger.valueOf(coach.getCoach_id()));
		return coh;
	}
	
	@GetMapping("/all")
	public List<Coach> coachList() {
		List<Coach> coaches = coachRepository.findAll();
		return coaches;
	}
	
	@PostMapping("/delete")
	public void coachDelete(@RequestParam("coach_id") Long cid) {
		coachRepository.deleteById(cid);
	}
	
	@PostMapping("/update")
	public Coach coachUpdate(@RequestBody Coach coach) {
		Coach coh = coachRepository.save(coach); // note that given coach_id must be present
		return coh;
	}
	
}
