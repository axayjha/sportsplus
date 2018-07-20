package com.cse.sportsplus.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "group_tbl")
public class Group implements Serializable{
	
	@Id //Denotes primary key
	@GeneratedValue //Denotes primary key is auto-generated
	@Column(name="group_id")
	private Long groupID;

	
	@ManyToOne
	@JoinColumn(name="academy_id")
	private Academy academy;

	@Column(name = "groupName")
	private String groupName;
	
	@Column(name = "groupDescription")
	private String groupDescription;
	
	@Column(name = "groupStatus")
	private String groupStatus;
	
	@ManyToMany(targetEntity=Coach.class)
	private Set<Coach> coach;

	
	public Group() {
		super();
	}

	
	public Group(Long groupID, Academy academy, String groupName, String groupDescription, String groupStatus,
			Set<Coach> coach) {
		super();
		this.groupID = groupID;
		this.academy = academy;
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.groupStatus = groupStatus;
		this.coach = new HashSet<>(coach);
	}


	public Long getGroupID() {
		return groupID;
	}


	public void setGroupID(Long groupID) {
		this.groupID = groupID;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getGroupDescription() {
		return groupDescription;
	}


	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}


	public String getGroupStatus() {
		return groupStatus;
	}


	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus;
	}


	public Set<Coach> getCoach() {return coach; }


	public void setCoach(Set<Coach> coach) {
		this.coach = coach;
	}

	
	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	

	
	
	

}
