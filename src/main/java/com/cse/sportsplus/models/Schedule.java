package com.cse.sportsplus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

enum status {
	UPCOMING,
	COMPLETED,
	MISSED
};

@Entity
@Table(name="tbl_schedule")

public class Schedule implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "date_time")
	private Long date_time;
	// epoch time. get using System.currentTimeMillis()
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "updated_time")
	private Long updated_time;
	
	@Column(name = "status")
	private Byte status;
	
	@Column(name = "group_id")
	private Long group_id;
	
	@Column(name = "academy_id")
	private Long academy_id;
	
	public Schedule() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDate_time() {
		return date_time;
	}

	public void setDate_time(Long date_time) {
		this.date_time = date_time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(Long updated_time) {
		this.updated_time = updated_time;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}

	public Long getAcademy_id() {
		return academy_id;
	}

	public void setAcademy_id(Long academy_id) {
		this.academy_id = academy_id;
	}


	
	

}
