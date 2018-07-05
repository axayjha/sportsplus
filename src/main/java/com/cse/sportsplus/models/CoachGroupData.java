package com.cse.sportsplus.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coach_group_table")
public class CoachGroupData implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="id")
    private long id;
	
	@Column(name="groupId")
	private long groupId;
	
	@Column(name="coachId")
	private long coachId;
	

	public CoachGroupData() {
		super();
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getCoachId() {
		return coachId;
	}

	public void setCoachId(long coachId) {
		this.coachId = coachId;
	}
	
	
}
