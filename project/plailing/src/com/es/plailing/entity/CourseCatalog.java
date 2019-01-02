package com.es.plailing.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity
@Table(name="tbl_coursecatalog")
public class CourseCatalog {
	private int catalogId;
	private String catalogName;
	private String courseFile;
	//子目录
	private Set<CourseCatalog> courseCatalogs=new HashSet<CourseCatalog>();
	//父类型
	private CourseCatalog courseCatalog;
	//课程
	private Course course;
	//评论
	private Set<Comment> comments=new HashSet<Comment>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	@OneToMany(mappedBy="courseCatalog",targetEntity=CourseCatalog.class,cascade={CascadeType.ALL})
	public Set<CourseCatalog> getCourseCatalogs() {
		return courseCatalogs;
	}
	public void setCourseCatalogs(Set<CourseCatalog> courseCatalogs) {
		this.courseCatalogs = courseCatalogs;
	}
	@ManyToOne
	@JoinColumn(name="pId")
	@NotFound(action=NotFoundAction.IGNORE)
	public CourseCatalog getCourseCatalog() {
		return courseCatalog;
	}
	public void setCourseCatalog(CourseCatalog courseCatalog) {
		this.courseCatalog = courseCatalog;
	}
	@ManyToOne
	@JoinColumn(name="courseId")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getCourseFile() {
		return courseFile;
	}
	public void setCourseFile(String courseFile) {
		this.courseFile = courseFile;
	}
	@OneToMany(mappedBy="courseCatalog",targetEntity=Comment.class,cascade={CascadeType.ALL})
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
}
