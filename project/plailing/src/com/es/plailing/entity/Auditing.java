package com.es.plailing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="tbl_auditing")
public class Auditing {
	private int auditingId;
	private String personalInfo;
	private String identityPic;
	private String teachVideo;
	private String certificate;
	private int checkState;
	//管理员
	private Administrator administrator;
	//用户
	private User user;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAuditingId() {
		return auditingId;
	}
	public void setAuditingId(int auditingId) {
		this.auditingId = auditingId;
	}
	public String getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(String personalInfo) {
		this.personalInfo = personalInfo;
	}
	public String getIdentityPic() {
		return identityPic;
	}
	public void setIdentityPic(String identityPic) {
		this.identityPic = identityPic;
	}
	public String getTeachVideo() {
		return teachVideo;
	}
	public void setTeachVideo(String teachVideo) {
		this.teachVideo = teachVideo;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public int getCheckState() {
		return checkState;
	}
	public void setCheckState(int checkState) {
		this.checkState = checkState;
	}
	@ManyToOne
	@JoinColumn(name="adminId")
	public Administrator getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
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
