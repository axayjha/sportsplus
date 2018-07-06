package com.cse.sportsplus.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "group_tbl")
public class Group implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long groupID;

	@Column(name = "groupName")
	private String groupName;
	
	@Column(name = "groupDescription")
	private String groupDescription;
	
	@Column(name = "groupStatus")
	private String groupStatus;
	
	@OneToMany(mappedBy="group_id")
	private List<Coach> coach;

	
	public Group() {
		super();
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


	public List<Coach> getCoach() {
		return coach;
	}


	public void setCoach(List<Coach> coach) {
		this.coach = coach;
	}

	

	
	
	

}
