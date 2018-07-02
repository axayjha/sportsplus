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
public class Athelete implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="id")
    private long id;
	@NotNull
	@Column(name="firstName")
    private String firstName;
	@NotNull
	@Column(name="lastName")
    private String lastName;
	@NotNull
	@Column(name="DOB")
    private String  dob;
	@Column(name="Age")
    private long age;
	@NotNull
	@Column(name="Gender")
    private char gender;
	@NotNull
	@Column(name="Contact No")
    private long contactNo;
	@Column(name="Address")
    private String address;
	@NotNull
	@Column(name="city")
	private String city;
	@NotNull
	@Column(name="pincode")
	private long pincode;
	@Column(name="ParentFullName")
    private String parentFullName;
	@Column(name="ParentAddress")
    private String parentAddress;
	@NotNull
	@Column(name="ParentContact")
    private long parentContact;
	@NotNull
	@Column(name="PrimarySport")
    private String primarySport;
	@Column(name="TrainigBase")
    private String trainingBase;
	@Column(name="College")
    private String college;
    //private ArrayList<Integer> groupId;
    
	private long coachId;
	@Column(name="PlayerLevel")
    private String level;
	@Column(name="ResidentStatus")
    private String residentStatus;
    @Column(name="AthleteStatus")
	private String athleteStatus;
    @Column(name="BloodGroup")
    private String bloodGroup;

    

    public Athelete(long id, @NotNull String firstName, @NotNull String lastName, @NotNull String dob, long age,
			@NotNull char gender, @NotNull long contactNo, String address, @NotNull String city, @NotNull long pincode,
			String parentFullName, String parentAddress, @NotNull long parentContact, @NotNull String primarySport,
			String trainingBase, String college, long coachId, String level, String residentStatus,
			String athleteStatus, String bloodGroup) {
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
		this.level = level;
		this.residentStatus = residentStatus;
		this.athleteStatus = athleteStatus;
		this.bloodGroup = bloodGroup;
	}

	public Athelete() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public long getParentContact() {
        return parentContact;
    }

    public void setParentContact(long parentContact) {
        this.parentContact = parentContact;
    }

    public String getTrainingBase() {
        return trainingBase;
    }

    public void setTrainingBase(String trainingBase) {
        this.trainingBase = trainingBase;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


//    public ArrayList<Integer> getGroupId() {
//        return groupId;
//    }
//
//    public void setGroupId(ArrayList<Integer> groupId) {
//        this.groupId = groupId;
//    }

    public long getCoachId() {
        return coachId;
    }

    public void setCoachId(long coachId) {
        this.coachId = coachId;
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

    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
}
