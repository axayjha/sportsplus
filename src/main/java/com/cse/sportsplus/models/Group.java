package com.cse.sportsplus.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "group_tbl")
public class Group implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "groupID",unique=true)
	private Long groupID;

	@Column(name = "groupName")
	private String groupName;
	
	@Column(name = "groupDescription")
	private String groupDescription;
	
	@Column(name = "groupStatus")
	private String groupStatus;
	
	@Column(name = "coachId")
	private Long coachId;

	public Group() {
		super();
	}

	public Group(String groupName, Long groupID, String groupDescription, String groupStatus, Long coachId) {
		super();
		this.groupName = groupName;
		this.groupID = groupID;
		this.groupDescription = groupDescription;
		this.groupStatus = groupStatus;
		this.coachId = coachId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Long getGroupID() {
		return groupID;
	}

	public void setGroupID(Long groupID) {
		this.groupID = groupID;
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

	public Long getCoachId() {
		return coachId;
	}

	public void setCoachId(Long coachId) {
		this.coachId = coachId;
	}
	
	

}
