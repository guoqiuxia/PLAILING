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
@Table(name="tbl_userDemand")
public class UserDemand {
	private int userDemandId;
	private User user;
	private Demand demand;
	private Date demandTime;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUserDemandId() {
		return userDemandId;
	}
	public void setUserDemandId(int userDemandId) {
		this.userDemandId = userDemandId;
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
	@JoinColumn(name="demandId")
	public Demand getDemand() {
		return demand;
	}
	public void setDemand(Demand demand) {
		this.demand = demand;
	}
	public Date getDemandTime() {
		return demandTime;
	}
	public void setDemandTime(Date demandTime) {
		this.demandTime = demandTime;
	}
	
	
}
