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
@Table(name="tbl_coursetype")
public class CourseType {
	private Integer typeId;
	private String typeName;
	//�γ�����
	private Set<Course> courses=new HashSet<Course>();
	//������
	private Set<CourseType> courseTypes=new HashSet<CourseType>();
	//������
	private CourseType courseType;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@OneToMany(mappedBy="courseType",targetEntity=CourseType.class,cascade={CascadeType.ALL})
	public Set<CourseType> getCourseTypes() {
		return courseTypes;
	}
	public void setCourseTypes(Set<CourseType> courseTypes) {
		this.courseTypes = courseTypes;
	}
	@ManyToOne
	@JoinColumn(name="pTypeId")
	@NotFound(action=NotFoundAction.IGNORE)
	public CourseType getCourseType() {
		return courseType;
	}
	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}
	@OneToMany(mappedBy="courseType",targetEntity=Course.class,cascade={CascadeType.ALL})
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	} 
	
}
