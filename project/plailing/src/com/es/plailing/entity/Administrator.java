package com.es.plailing.entity;

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
@Table(name="tbl_administrator")
public class Administrator {
	private int adminId;
	private String adminName;
	private String password;
	//…Û∫À
	private Set<Auditing> Auditings=new HashSet<Auditing>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(mappedBy="administrator",targetEntity=Auditing.class,cascade={CascadeType.ALL})
	public Set<Auditing> getAuditings() {
		return Auditings;
	}
	public void setAuditings(Set<Auditing> auditings) {
		Auditings = auditings;
	}
	
}
