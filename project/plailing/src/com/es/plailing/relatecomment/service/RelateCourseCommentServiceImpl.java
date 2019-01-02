package com.es.plailing.relatecomment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.coursecomment.dao.CommentCourseCommentDaoImpl;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.relatecomment.dao.RelateCourseCommentDaoImpl;
@Service
@Transactional(readOnly=false)
public class RelateCourseCommentServiceImpl implements RelateCourseCommentService {

	@Resource
	private RelateCourseCommentDaoImpl relateCourseCommentDaoImpl;
	
	@Override
	public Page<CourseComment> pageCourseComment(int pageNum, int pageSize, String email) {
		try {
			return relateCourseCommentDaoImpl.pageCourseComment(pageNum, pageSize, email);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean insertCourseComment(CourseComment courseComment, Course c, User u) {
		try {
			relateCourseCommentDaoImpl.insertCourseComment(courseComment, c, u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CourseComment getCourseComment(int courseCommentId) {
		try {
			return relateCourseCommentDaoImpl.getCourseComment(courseCommentId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean insertCourseCommentAnswer(CourseComment courseComment, CourseComment newCourseComment, Course c,
			User u) {
		try {
			relateCourseCommentDaoImpl.insertCourseCommentAnswer(courseComment, newCourseComment, c, u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Object[]> getCourseCommentLast() {
		try {
			return relateCourseCommentDaoImpl.getCourseCommentLast();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<CourseComment> FindSon(int top){
		try {
			return relateCourseCommentDaoImpl.FindSon(top);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
