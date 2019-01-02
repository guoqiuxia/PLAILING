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
@Table(name="tbl_comment")
public class Comment {
	private int commentId;
	private String text;
	private Date commentTime;
	private int top;

	//子评论
	private Set<Comment> comments=new HashSet<Comment>();
	//父评论
	private Comment comment;
	//用户
	private User user;
	//课程目录
	private CourseCatalog courseCatalog;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
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
	@OneToMany(mappedBy="comment",targetEntity=Comment.class,cascade={CascadeType.ALL})
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	@ManyToOne
	@JoinColumn(name="pId")
	@NotFound(action=NotFoundAction.IGNORE)
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
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
	@JoinColumn(name="catalogId")
	public CourseCatalog getCourseCatalog() {
		return courseCatalog;
	}
	public void setCourseCatalog(CourseCatalog courseCatalog) {
		this.courseCatalog = courseCatalog;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	
}
