package com.es.plailing.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_demand")
public class Demand {
	private int demandId;
	private String text;
	private double proportion;
	private int count;
	//根据需求开了哪些课
	private Set<Course> courses=new HashSet<Course>();
	//哪些人有这个需求
	private Set<UserDemand> users=new HashSet<UserDemand>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getDemandId() {
		return demandId;
	}
	public void setDemandId(int demandId) {
		this.demandId = demandId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getProportion() {
		return proportion;
	}
	public void setProportion(double proportion) {
		this.proportion = proportion;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@OneToMany(mappedBy="demand",targetEntity=Course.class,cascade={CascadeType.ALL})
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@OneToMany(mappedBy="demand",targetEntity=UserDemand.class,cascade= {CascadeType.ALL})
	public Set<UserDemand> getUsers() {
		return users;
	}
	public void setUsers(Set<UserDemand> users) {
		this.users = users;
	}
	
	

}
