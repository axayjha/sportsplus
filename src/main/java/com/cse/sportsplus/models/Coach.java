package com.cse.sportsplus.models;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Coach Java bean
@Entity
@Table(name = "tbl_coach")
public class Coach implements Serializable {

    @Id     // Denoted primary key
    @GeneratedValue //Denotes primary key is auto-generated
    private Long coach_id;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy="coach")
    private Set<Group> groups;
    
    // Coach name
    @Column(name = "name")
    private String name;

    // Coach qualification
    @Column(name = "qualification")
    private String qualification;

    // Coach's phone number
    @Column(name = "phone")
    private String phone;

    // default constructor
    public Coach() {
        super();
    }

    public Long getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(Long coach_id) {
        this.coach_id = coach_id;
    }

    @JsonIgnore
    public Set<Group> getGroups() { return groups; }

    // Parameterized constructor
    public Coach(String name, String qualification, String phone) {
        this.name = name;
        this.qualification = qualification;
        this.phone = phone;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
