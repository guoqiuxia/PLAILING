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
@Table(name="tbl_follow")
public class Follow {
	private int followId;
	private int state;
	private Date followDate;
	private User teacherUser;
	private User studentUser;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getFollowId() {
		return followId;
	}
	public void setFollowId(int followId) {
		this.followId = followId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getFollowDate() {
		return followDate;
	}
	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}
	@ManyToOne
	@JoinColumn(name="teacherId")
	public User getTeacherUser() {
		return teacherUser;
	}
	public void setTeacherUser(User teacherUser) {
		this.teacherUser = teacherUser;
	}
	@ManyToOne
	@JoinColumn(name="studentId")
	public User getStudentUser() {
		return studentUser;
	}
	public void setStudentUser(User studentUser) {
		this.studentUser = studentUser;
	}
}
