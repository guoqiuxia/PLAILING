package com.es.plailing.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="tbl_money")
public class Money {
	private int moneyId;
	private double money;
	private Date moneyTime;
	private Course course;
	private User user;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getMoneyId() {
		return moneyId;
	}
	public void setMoneyId(int moneyId) {
		this.moneyId = moneyId;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getMoneyTime() {
		return moneyTime;
	}
	public void setMoneyTime(Date time) {
		this.moneyTime = time;
	}
	@ManyToOne
	@JoinColumn(name="courseId")
	public Course getCourse() {
		return course;
	}	
	public void setCourse(Course course) {
		this.course = course;
	}
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
