package com.es.plailing.coursecomment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.coursecomment.dao.CommentCourseCommentDaoImpl;
import com.es.plailing.coursecomment.dao.GradeDaoImpl;
import com.es.plailing.coursecomment.dao.GradeDaoImpl1;
import com.es.plailing.entity.Comment;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Grade;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

@Service
@Transactional(readOnly = false)
public class CourseCommenServiceImpl implements CourseCommentService {

	@Resource
	private CommentCourseCommentDaoImpl commentDaoImpl;
	@Resource
	private GradeDaoImpl gradeDaoImpl;
	@Resource
	private GradeDaoImpl1 gradeDaoImpl1;

	@Override
	public Page<CourseComment> pageCourseComment(int pageNum, int pageSize, int courseId) {
		try {
			return commentDaoImpl.pageCourseComment(pageNum, pageSize, courseId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean insertCourseComment(CourseComment courseComment, Course c, User u) {
		try {
			commentDaoImpl.insertCourseComment(courseComment, c, u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CourseComment getCourseComment(int courseCommentId) {
		try {
			return commentDaoImpl.getCourseComment(courseCommentId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean insertCourseCommentAnswer(CourseComment courseComment, CourseComment newCourseComment, Course c,
			User u) {
		try {
			commentDaoImpl.insertCourseCommentAnswer(courseComment, newCourseComment, c, u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CourseComment> getCourseCommentLast() {
		try {
			return commentDaoImpl.getCourseCommentLast();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<CourseComment> FindSon(int top) {
		try {
			return commentDaoImpl.FindSon(top);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void giveGrade(User u, Course c, int grade) {
		// TODO Auto-generated method stub
		try {
			this.gradeDaoImpl.giveGrade(u, c, grade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Course getCourseById(int courseId) {
		// TODO Auto-generated method stub
		try {
			return this.gradeDaoImpl1.getCourseById(courseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean checkGrade(User u, Course c) {
		// TODO Auto-generated method stub
		try {
			return this.gradeDaoImpl.checkGrade(u, c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Grade findTheGrade(User u, Course c) {
		// TODO Auto-generated method stub
		try {
			return this.gradeDaoImpl.findTheGrade(u, c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Grade> listGrounds(int courseId) {
		// TODO Auto-generated method stub
		try {
			return this.gradeDaoImpl.listGrounds(courseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateGrade(double avgGrade, int courseId) {
		// TODO Auto-generated method stub
		try {
			this.gradeDaoImpl1.updateGrade(avgGrade, courseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
