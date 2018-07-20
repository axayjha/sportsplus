package com.cse.sportsplus.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cse.sportsplus.models.Coach;
import com.cse.sportsplus.models.Group;
import com.cse.sportsplus.repository.CoachRepository;
import com.cse.sportsplus.repository.GroupRepository;

@RestController
@RequestMapping("/group") //class level mapping
public class GroupController {
	
	@Autowired //implements IOC
	private GroupRepository groupRepository;
	
	@Autowired
	private CoachRepository coachRepository;
	
	//Add details of new group
	@PostMapping("/addGroup")
	public Group addGroup(@RequestBody Group group) {
		Group persistedGroup = groupRepository.save(group);
		return persistedGroup;
	}
	
	//Display details of existing groups
	@GetMapping("/getGroups")
	public List<Group> getGroups(){
		List<Group> listofgroups = groupRepository.findAll();
		return listofgroups;
	}
	
	//Delete specific group
	@PostMapping("/deleteGroup")
	public List<Group> deleteGroup(@RequestBody Group group) {
		long deleteId = group.getGroupID();
		Group deleteGroup = groupRepository.findByGroupID(deleteId);
		if(deleteGroup != null)
			groupRepository.delete(deleteGroup);
		List<Group> remainingGroup = groupRepository.findAll();
		
		return remainingGroup;
	}
	
	//Returns details of specific group
	@PostMapping("/getAGroup")
	public Group getAGroup(@RequestBody Group group) {
		long groupId = group.getGroupID();
		Group fetchGroup = groupRepository.findByGroupID(groupId);
		return fetchGroup;
	}
	
	//Update details of existing group
	@PostMapping("/updateGroup")
	public List<Group> updateGroup(@RequestBody Group group) {
		long groupId = group.getGroupID();
		Group updatedGroup = groupRepository.findByGroupID(groupId);
		updatedGroup.setGroupDescription(group.getGroupDescription());
		updatedGroup.setGroupName(group.getGroupName());
		updatedGroup.setGroupStatus(group.getGroupStatus());
		groupRepository.save(updatedGroup);
		List<Group> allGroups = groupRepository.findAll();
		return allGroups;
	}
	
	//Add coaches to a group
	@PostMapping("/addCoach")
	public Group addCoach(@RequestBody Group group) {
		Group tg = groupRepository.findByGroupID(group.getGroupID());
		Set<Coach> tc = tg.getCoach();
		tc.addAll(group.getCoach());
		tg.setCoach(tc);
		groupRepository.save(tg);
		return groupRepository.findByGroupID(group.getGroupID());
		
	}

	//Get coaches of a group
	@GetMapping("/allCoachID")
	public List<java.math.BigInteger> getAllCoachID(){
		return coachRepository.getAllCoachID();
	}
	
	


	@GetMapping("/testId")
	public BigInteger fetchAid(Long group_id){
		return groupRepository.aid(group_id);
	}

//	@PostMapping("/addCoach")
//	public void addCoach(@RequestBody Coach coach) {
//		CoachGroupData groupCoach;
//		groupCoach.setCoachId(coach.getCoachId());
//		groupCoach.setGroupId(coach.getGroupId());
//		coachGroupRepo.save(groupCoach);
//	}
}
