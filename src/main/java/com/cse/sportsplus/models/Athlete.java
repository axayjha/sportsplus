package com.cse.sportsplus.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="athlete_tbl")
public class Athlete implements Serializable{
	@Id
	@GeneratedValue()
	@Column(name="id")
    private Long id;
	
	@NotNull
	@Column(name="firstName")
    private String firstName;
	
	@NotNull
	@Column(name="lastName")
    private String lastName;
	
	@NotNull
	@Column(name="DOB")
    private Long  dob;
	
	@Column(name="Age")
    private Long age;
	
	@NotNull
	@Column(name="Gender")
    private String gender;
	
	@NotNull
	@Column(name="ContactNo")
    private Long contactNo;
	
	@Column(name="Address")
    private String address;
	
	@NotNull
	@Column(name="city")
	private String city;
	
	@NotNull
	@Column(name="pincode")
	private Long pincode;
	
	@Column(name="ParentFullName")
    private String parentFullName;
	
	@Column(name="ParentAddress")
    private String parentAddress;
	
	@NotNull
	@Column(name="ParentContact")
    private Long parentContact;
	
	@NotNull
	@Column(name="PrimarySport")
    private String primarySport;
	

	@Column(name="TrainigBase")
    private Long trainingBase;
	
	@Column(name="College")
    private String college;

    
	@Column(name="CoachID")
	private Long coachId;
	
	@Column(name="GroupID")
	private Long groupid;
	
	@Column(name="PlayerLevel")
    private String level;
	
	@Column(name="ResidentStatus")
    private String residentStatus;
    
	@Column(name="AthleteStatus")
	private String athleteStatus;
    
	@Column(name="BloodGroup")
    private String bloodGroup;

	public Athlete(Long id, @NotNull String firstName, @NotNull String lastName, @NotNull @NotNull Long dob, Long age,
			@NotNull String gender, @NotNull Long contactNo, String address, @NotNull String city,
			@NotNull Long pincode, String parentFullName, String parentAddress, @NotNull Long parentContact,
			@NotNull String primarySport, Long trainingBase, String college, Long coachId, Long groupid, String level,
			String residentStatus, String athleteStatus, String bloodGroup) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.contactNo = contactNo;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.parentFullName = parentFullName;
		this.parentAddress = parentAddress;
		this.parentContact = parentContact;
		this.primarySport = primarySport;
		this.trainingBase = trainingBase;
		this.college = college;
		this.coachId = coachId;
		this.groupid = groupid;
		this.level = level;
		this.residentStatus = residentStatus;
		this.athleteStatus = athleteStatus;
		this.bloodGroup = bloodGroup;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public @NotNull Long getDob() {
		return dob;
	}

	public void setDob(@NotNull Long dob) {
		this.dob = dob;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getParentFullName() {
		return parentFullName;
	}

	public void setParentFullName(String parentFullName) {
		this.parentFullName = parentFullName;
	}

	public String getParentAddress() {
		return parentAddress;
	}

	public void setParentAddress(String parentAddress) {
		this.parentAddress = parentAddress;
	}

	public Long getParentContact() {
		return parentContact;
	}

	public void setParentContact(Long parentContact) {
		this.parentContact = parentContact;
	}

	public String getPrimarySport() {
		return primarySport;
	}

	public void setPrimarySport(String primarySport) {
		this.primarySport = primarySport;
	}

	public Long getTrainingBase() {
		return trainingBase;
	}

	public void setTrainingBase(Long trainingBase) {
		this.trainingBase = trainingBase;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public Long getCoachId() {
		return coachId;
	}

	public void setCoachId(Long coachId) {
		this.coachId = coachId;
	}

	public Long getGroupid() {
		return groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getResidentStatus() {
		return residentStatus;
	}

	public void setResidentStatus(String residentStatus) {
		this.residentStatus = residentStatus;
	}

	public String getAthleteStatus() {
		return athleteStatus;
	}

	public void setAthleteStatus(String athleteStatus) {
		this.athleteStatus = athleteStatus;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Athlete() {
		super();
	}

    
}
