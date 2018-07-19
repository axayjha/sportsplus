package com.cse.sportsplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import  com.cse.sportsplus.repository.ScheduleRepository;
import com.cse.sportsplus.models.Schedule;
import com.cse.sportsplus.repository.AcademyRepository;
import com.cse.sportsplus.repository.GroupRepository;


@RestController
@RequestMapping("/schedule") 
public class ScheduleController {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private AcademyRepository academyController;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@PostMapping("/add")
	public Schedule addSchedule(@RequestBody Schedule schedule) {
		Schedule persistedSchedule = scheduleRepository.save(schedule); 
		// line above saves the object in database
		// and returns same schedule object with id value updated as in DB  
		return persistedSchedule;
	}
	
	@GetMapping("/getAll")
	public List<Schedule> getAll() {
		List <Schedule> list_of_schedules = scheduleRepository.findAll();
		return list_of_schedules;
	}
	
	@GetMapping("/getAcademyID")
	public List<java.math.BigInteger> getAllAcademyID(){
		return academyController.getAllAcademyID();
	}

	@GetMapping("/getGroupID")
	public List<java.math.BigInteger> getAllGroupID(@RequestParam Long id){
		return groupRepository.getAllID(id);
	}
	
	@PostMapping("/delete")
	public void deleteSchedule(@RequestBody Schedule sh) {
		scheduleRepository.deleteById(sh.getId());
	}
}
