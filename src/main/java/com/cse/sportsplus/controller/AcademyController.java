package com.cse.sportsplus.controller;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cse.sportsplus.models.Academy;
import com.cse.sportsplus.repository.AcademyRepository;
import com.cse.sportsplus.repository.AthleteRepository;
import com.cse.sportsplus.repository.CoachRepository;
import com.cse.sportsplus.repository.GroupRepository;


@RestController
@RequestMapping("/academy") 
public class AcademyController {
	
	@Autowired
	private AcademyRepository academyRepository;
	
	@Autowired
	private CoachRepository coachRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private AthleteRepository athleteRepository;
	
	
	@PostMapping("/add")
	public Academy addAcademy(@RequestBody Academy academy) {
		return academyRepository.save(academy);
	}
	
	@GetMapping("/getAll")
	public List<Academy> getAll() {
		return academyRepository.findAll();
	}
	@PostMapping("/delete")
	public void deleteAcademy(@RequestBody Academy academy) {
		Long aid = academy.getId();
		athleteRepository.deleteAth(aid);
		List<java.math.BigInteger> g_id = groupRepository.getAllID(aid);
		List<BigInteger> c_id = new ArrayList<BigInteger>();
		for(BigInteger i : g_id) {
			System.out.println(i);
			c_id.addAll((coachRepository.getAllCoachIDByGroupID(i.longValue())));
		}
		System.out.println("Out of loop");
		coachRepository.deleteJoinData(g_id);
		coachRepository.deleteCoach(c_id);
		groupRepository.deleteGrp(g_id);
		academyRepository.deleteById(aid);
		
	}

	@PostMapping("/update")
	public List<Academy> updateAcademy(@RequestBody Academy academy) {
		academyRepository.save(academy);
		List <Academy> list_of_academies = academyRepository.findAll();
		return list_of_academies;	
		
	}
	
	
	
	

}
