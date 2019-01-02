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
@Table(name="tbl_userbalance")
public class UserBalance {
	private int userBalanceId;
	private Date balanceTime;
	private double money;
	private double totleMoney;
	private int balanceState;
	//�û�
	private User user;
	private Course course;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUserBalanceId() {
		return userBalanceId;
	}
	public void setUserBalanceId(int userBalanceId) {
		this.userBalanceId = userBalanceId;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getBalanceTime() {
		return balanceTime;
	}
	public void setBalanceTime(Date balanceTime) {
		this.balanceTime = balanceTime;
	}
	public double getTotleMoney() {
		return totleMoney;
	}
	public void setTotleMoney(double totleMoney) {
		this.totleMoney = totleMoney;
	}
	public int getBalanceState() {
		return balanceState;
	}
	public void setBalanceState(int balanceState) {
		this.balanceState = balanceState;
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
	
}
