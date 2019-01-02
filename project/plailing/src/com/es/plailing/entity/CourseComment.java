package com.es.plailing.entity;

import java.util.Date;
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
@Table(name="tbl_courseComment")
public class CourseComment {
	private int courseCommentId;
	private String text;
	private Date commentTime;
	private int top;
	//������
	private Set<CourseComment> courseComments=new HashSet<CourseComment>();
	//������
	private CourseComment courseComment;
	//�û�
	private User user;
	//�γ�
	private Course course;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourseCommentId() {
		return courseCommentId;
	}
	public void setCourseCommentId(int courseCommentId) {
		this.courseCommentId = courseCommentId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	
	@OneToMany(mappedBy="courseComment",targetEntity=CourseComment.class,cascade={CascadeType.ALL})
	public Set<CourseComment> getCourseComments() {
		return courseComments;
	}
	public void setCourseComments(Set<CourseComment> courseComments) {
		this.courseComments = courseComments;
	}
	@ManyToOne
	@JoinColumn(name="courseCommentPid")
	@NotFound(action=NotFoundAction.IGNORE)
	public CourseComment getCourseComment() {
		return courseComment;
	}
	public void setCourseComment(CourseComment courseComment) {
		this.courseComment = courseComment;
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
