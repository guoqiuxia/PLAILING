package com.es.plailing.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="tbl_course")
public class Course {
	private int courseId;
	private String name;
	private String photo;
	private double price;
	private String courseInfo;
	private double grade;
	private int joinCount;
	private int state;
	//ï¿½Ï´ï¿½ï¿½Î³ï¿½
	private User user;
	private Set<UserBalance> userBalances=new HashSet<UserBalance>();
	private Set<Money> moneys=new HashSet<Money>();
	//ï¿½ï¿½ï¿½ï¿½
	private Set<UserJoinCourse> joinUsers=new HashSet<UserJoinCourse>();
	//ï¿½Õ²ï¿½
	private Set<UserCollectionCourse> collectUsers=new HashSet<UserCollectionCourse>();
	//ï¿½ï¿½ï¿½ï¿½
	private Set<Grade> grades=new HashSet<Grade>();
	//ï¿½ï¿½ï¿½ï¿½
	private Set<CourseComment>courseComments=new HashSet<CourseComment>();
	//ï¿½Î³ï¿½ï¿½ï¿½ï¿½ï¿½
	private CourseType courseType;
	//ï¿½Î³ï¿½Ä¿Â¼
	private Set<CourseCatalog> courseCatalogs=new HashSet<CourseCatalog>();
	//Í¨Öª
	private Set<Inform> informs=new HashSet<Inform>();
	//ÉêÇë³¡µØÐÅÏ¢
	private Set<ApplicationSite> applicationSites=new HashSet<ApplicationSite>();
	//ÐèÇó
	private Demand demand;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public int getJoinCount() {
		return joinCount;
	}
	public void setJoinCount(int joinCount) {
		this.joinCount = joinCount;
	}
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCourseInfo() {
		return courseInfo;
	}
	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}
	@OneToMany(mappedBy="course",targetEntity=UserJoinCourse.class,cascade= {CascadeType.ALL})
	public Set<UserJoinCourse> getJoinUsers() {
		return joinUsers;
	}
	public void setJoinUsers(Set<UserJoinCourse> joinUsers) {
		this.joinUsers = joinUsers;
	}
	@OneToMany(mappedBy="course",targetEntity=UserCollectionCourse.class,cascade={CascadeType.ALL})
	public Set<UserCollectionCourse> getCollectUsers() {
		return collectUsers;
	}
	public void setCollectUsers(Set<UserCollectionCourse> collectUsers) {
		this.collectUsers = collectUsers;
	}
	@OneToMany(mappedBy="course",targetEntity=Grade.class,cascade={CascadeType.ALL})
	public Set<Grade> getGrades() {
		return grades;
	}
	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}
	@OneToMany(mappedBy="course",targetEntity=CourseComment.class,cascade={CascadeType.ALL})
	public Set<CourseComment> getCourseComments() {
		return courseComments;
	}
	public void setCourseComments(Set<CourseComment> courseComments) {
		this.courseComments = courseComments;
	}
	@ManyToOne
	@JoinColumn(name="typeId")
	public CourseType getCourseType() {
		return courseType;
	}
	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}
	@OneToMany(mappedBy="course",targetEntity=CourseCatalog.class,cascade={CascadeType.ALL})
	public Set<CourseCatalog> getCourseCatalogs() {
		return courseCatalogs;
	}
	public void setCourseCatalogs(Set<CourseCatalog> courseCatalogs) {
		this.courseCatalogs = courseCatalogs;
	}
	@OneToMany(mappedBy="course",targetEntity=Money.class,cascade={CascadeType.ALL})
	public Set<Money> getMoneys() {
		return moneys;
	}
	public void setMoneys(Set<Money> moneys) {
		this.moneys = moneys;
	}
	@OneToMany(mappedBy="course",targetEntity=UserBalance.class,cascade={CascadeType.ALL})
	public Set<UserBalance> getUserBalances() {
		return userBalances;
	}
	public void setUserBalances(Set<UserBalance> userBalances) {
		this.userBalances = userBalances;
	}
	@OneToMany(mappedBy="course",targetEntity=Inform.class,cascade={CascadeType.ALL})
	public Set<Inform> getInforms() {
		return informs;
	}
	public void setInforms(Set<Inform> informs) {
		this.informs = informs;
	}
	@OneToMany(mappedBy="course",targetEntity=ApplicationSite.class,cascade={CascadeType.ALL})
	public Set<ApplicationSite> getApplicationSites() {
		return applicationSites;
	}
	public void setApplicationSites(Set<ApplicationSite> applicationSites) {
		this.applicationSites = applicationSites;
	}
	@ManyToOne
	@JoinColumn(name="demandId")
	public Demand getDemand() {
		return demand;
	}
	public void setDemand(Demand demand) {
		this.demand = demand;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}	
}
