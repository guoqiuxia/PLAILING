package com.es.plailing.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_inform")
public class Inform {
	private int informId;
	private String informText;
	private Date informTime;
	private int state;
	//¿Î³ÌºÅ
	private Course course;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getInformId() {
		return informId;
	}
	public void setInformId(int informId) {
		this.informId = informId;
	}
	public String getInformText() {
		return informText;
	}
	public void setInformText(String informText) {
		this.informText = informText;
	}
	public Date getInformTime() {
		return informTime;
	}
	public void setInformTime(Date informTime) {
		this.informTime = informTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@ManyToOne
	@JoinColumn(name="courseId")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
