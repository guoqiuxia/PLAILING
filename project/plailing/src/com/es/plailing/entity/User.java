package com.es.plailing.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User {
	private int userId;
	private String email;
	private String sex;
	private String nativeProvince;
	private String nativeCity;
	private String phoneNumber;
	private String password;
	private String photo;
	private String nickName;
	private String birthday;
	private String identityNumber;
	private double balance;
	private String introduction;
	private String school;
	private String major;
	private String tag;
	private Set<Money> moneys = new HashSet<Money>();
	// 锟斤拷锟�
	private Set<UserBalance> userBalances = new HashSet<UserBalance>();
	// 锟较达拷锟轿筹拷
	private Set<Course> uploadCourses = new HashSet<Course>();
	// 锟斤拷锟斤拷纬锟�
	private Set<UserJoinCourse> joinCourses = new HashSet<UserJoinCourse>();
	// 锟秸藏课筹拷
	private Set<UserCollectionCourse> collectCourses = new HashSet<UserCollectionCourse>();
	// 锟斤拷锟斤拷
	private Set<Comment> comments = new HashSet<Comment>();
	// 锟轿筹拷锟斤拷锟斤拷
	private Set<CourseComment> courseComments = new HashSet<CourseComment>();
	// 锟斤拷锟斤拷
	private Set<Grade> grades = new HashSet<Grade>();
	// 锟斤拷师
	private Set<Follow> teacherFollows = new HashSet<Follow>();
	// 学锟斤拷
	private Set<Follow> studentFollows = new HashSet<Follow>();
	//审核
	private Set<Auditing> auditings = new HashSet<Auditing>();
	//发布需求
	private Set<UserDemand> demands=new HashSet<UserDemand>();
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNativeProvince() {
		return nativeProvince;
	}

	public void setNativeProvince(String nativeProvince) {
		this.nativeProvince = nativeProvince;
	}

	public String getNativeCity() {
		return nativeCity;
	}

	public void setNativeCity(String nativeCity) {
		this.nativeCity = nativeCity;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@OneToMany(mappedBy = "user", targetEntity = Money.class, cascade = { CascadeType.ALL })
	public Set<Money> getMoneys() {
		return moneys;
	}

	public void setMoneys(Set<Money> moneys) {
		this.moneys = moneys;
	}

	@OneToMany(mappedBy = "user", targetEntity = UserBalance.class, cascade = { CascadeType.ALL })
	public Set<UserBalance> getUserBalances() {
		return userBalances;
	}

	public void setUserBalances(Set<UserBalance> userBalances) {
		this.userBalances = userBalances;
	}

	@OneToMany(mappedBy = "user", targetEntity = Course.class, cascade = { CascadeType.ALL })
	public Set<Course> getUploadCourses() {
		return uploadCourses;
	}

	public void setUploadCourses(Set<Course> uploadCourses) {
		this.uploadCourses = uploadCourses;
	}

	@OneToMany(mappedBy="user",targetEntity=UserJoinCourse.class,cascade= {CascadeType.ALL})
	public Set<UserJoinCourse> getJoinCourses() {
		return joinCourses;
	}

	public void setJoinCourses(Set<UserJoinCourse> joinCourses) {
		this.joinCourses = joinCourses;
	}

	@OneToMany(mappedBy = "user", targetEntity = UserCollectionCourse.class, cascade = { CascadeType.ALL },fetch=FetchType.EAGER)
	public Set<UserCollectionCourse> getCollectCourses() {
		return collectCourses;
	}

	public void setCollectCourses(Set<UserCollectionCourse> collectCourses) {
		this.collectCourses = collectCourses;
	}

	@OneToMany(mappedBy = "user", targetEntity = Comment.class, cascade = { CascadeType.ALL },fetch=FetchType.EAGER)
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(mappedBy = "user", targetEntity = CourseComment.class, cascade = { CascadeType.ALL })
	public Set<CourseComment> getCourseComments() {
		return courseComments;
	}

	public void setCourseComments(Set<CourseComment> courseComments) {
		this.courseComments = courseComments;
	}

	@OneToMany(mappedBy = "user", targetEntity = Grade.class, cascade = { CascadeType.ALL })
	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	@OneToMany(mappedBy = "teacherUser", targetEntity = Follow.class, cascade = { CascadeType.ALL })
	public Set<Follow> getTeacherFollows() {
		return teacherFollows;
	}

	public void setTeacherFollows(Set<Follow> teacherFollows) {
		this.teacherFollows = teacherFollows;
	}

	@OneToMany(mappedBy = "studentUser", targetEntity = Follow.class, cascade = { CascadeType.ALL })
	public Set<Follow> getStudentFollows() {
		return studentFollows;
	}

	public void setStudentFollows(Set<Follow> studentFollows) {
		this.studentFollows = studentFollows;
	}
	
	@OneToMany(mappedBy = "user", targetEntity = Auditing.class, cascade = { CascadeType.ALL })
	public Set<Auditing> getAuditings() {
		return auditings;
	}

	public void setAuditings(Set<Auditing> auditings) {
		this.auditings = auditings;
	}
	@OneToMany(mappedBy="user",targetEntity=UserDemand.class,cascade= {CascadeType.ALL})
	public Set<UserDemand> getDemands() {
		return demands;
	}

	public void setDemands(Set<UserDemand> demands) {
		this.demands = demands;
	}
	

}
