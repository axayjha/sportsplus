package com.cse.sportsplus.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Athelete implements Serializable{
    private long id;
    private String firstName;
    private String lastName;
    private String  dob;
    private long age;
    private char gender;
    private long contactNo;
    private String address;
    private String parentFullName;
    private String parentAddress;
    private long parentContact;
    //primary sports check for implementation...
    private String trainingBase;
    private String college;
    private ArrayList<Integer> groupId;
    private long coachId;
    private String level;
    private String residentStatus;
    private ArrayList<String> athleteStatus;
    private String bloodGroup;

    public Athelete(long id, String firstName, String lastName, String dob, long age, char gender, long contactNo, String address, String parentFullName, String parentAddress, long parentContact, String trainingBase, String college, ArrayList<Integer> groupId,
                    long coachId, String level, String residentStatus, ArrayList<String> athleteStatus, String bloodGroup) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.contactNo = contactNo;
        this.address = address;
        this.parentFullName = parentFullName;
        this.parentAddress = parentAddress;
        this.parentContact = parentContact;
        this.trainingBase = trainingBase;
        this.college = college;
        this.groupId = groupId;
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

    public ArrayList<Integer> getGroupId() {
        return groupId;
    }

    public void setGroupId(ArrayList<Integer> groupId) {
        this.groupId = groupId;
    }

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

    public ArrayList<String> getAthleteStatus() {
        return athleteStatus;
    }

    public void setAthleteStatus(ArrayList<String> athleteStatus) {
        this.athleteStatus = athleteStatus;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
