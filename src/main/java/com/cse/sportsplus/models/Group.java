package com.cse.sportsplus.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cse.sportsplus.repository.GroupRepository;

@Entity
@Table(name = "group_tbl")
public class Group implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="groupID")
	private Long groupID;

	@Column(name = "groupName")
	private String groupName;
	
	@Column(name = "groupDescription")
	private String groupDescription;
	
	@Column(name = "groupStatus")
	private String groupStatus;

	@ElementCollection
	@CollectionTable(name="group_coach",
		foreignKey=@ForeignKey(foreignKeyDefinition="FOREIGN KEY(coach) REFERENCES tbl_coach(coach_id)"
	))
	private List<Long> coach;

	public Group(Long groupID, String groupName, String groupDescription, String groupStatus, List<Long> coach) {
		super();
		System.out.println("Constructor called");
		this.groupID = groupID;
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.groupStatus = groupStatus;
		this.coach = new ArrayList<>(coach);
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

	public List<Long> getCoach() {
		return coach;
	}

	public void setCoach(List<Long> coach) {
		this.coach = coach;
	}

	public Group() {
		super();
	}
	
	
	
	

	


}
