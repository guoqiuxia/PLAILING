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
@Table(name="tbl_userJoinCourse")
public class UserJoinCourse {
	private int joinCourseId;
	private User user;
	private Course course;
	private Date joinTime;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getJoinCourseId() {
		return joinCourseId;
	}
	public void setJoinCourseId(int joinCourseId) {
		this.joinCourseId = joinCourseId;
	}
	
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="courseId")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	
	
}
