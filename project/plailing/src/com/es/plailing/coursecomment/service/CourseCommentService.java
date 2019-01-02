package com.es.plailing.coursecomment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Grade;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

@Service
public interface CourseCommentService {
	
	/**
	 * 
	    * @Title: getCourseComment
	    * @Description: TODO(通过courseCommentId查找到对应的courseComment对象)
	    * @param @param courseCommentId
	    * @param @return    参数
	    * @return CourseComment    返回类型
	    * @throws
	 */
	public CourseComment getCourseComment(int courseCommentId);
	/**
	 * 
	    * @Title: listCourseComment
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param courseId
	    * @param @return    参数
	    * @return Page<Comment>    返回类型
	    * @throws
	 */
	public Page<CourseComment> pageCourseComment(int pageNum,int pageSize,int courseId);
	/**
	 * 
	    * @Title: insertCourseComment
	    * @Description: TODO(将用户的此评论插入到数据库中)
	    * @param @param courseComment
	    * @param @param c
	    * @param @param u    参数
	    * @return void    返回类型
	    * @throws
	 */
	public boolean insertCourseComment(CourseComment courseComment,Course c,User u);
	/**
	 * 
	    * @Title: insertCourseCommentAnswer
	    * @Description: TODO(添加回复的评论)
	    * @param @param courseComment  父评论
	    * @param @param newCourseComment 新评论
	    * @param @param c  课程
	    * @param @param u  用户
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public boolean insertCourseCommentAnswer(CourseComment courseComment,CourseComment newCourseComment,Course c,User u);
	/**
	 * 
	    * @Title: getCourseCommentLast
	    * @Description: TODO得到courseComment的相关数据)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Object[]>    返回类型
	    * @throws
	 */
	public List<CourseComment> getCourseCommentLast();
	/**
	 * 
	    * @Title: FindSon
	    * @Description: TODO(查找子评论)
	    * @param @param top
	    * @param @return    参数
	    * @return List<CourseComment>    返回类型
	    * @throws
	 */
	public List<CourseComment> FindSon(int top);
	/**
	 * 
	    * @Title: giveGrade
	    * @Description: TODO(用户评分插入数据库数据)
	    * @param @param u
	    * @param @param c
	    * @param @param grade    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void giveGrade(User u,Course c,int grade);
	/**
	 * 
	    * @Title: getCourseById
	    * @Description: TODO(通过课程id获得课程)
	    * @param @param courseId
	    * @param @return    参数
	    * @return Course    返回类型
	    * @throws
	 */
	public Course getCourseById(int courseId);
	/**
	 * 
	    * @Title: checkGrade
	    * @Description: TODO(检查是否评分)
	    * @param @param u
	    * @param @param c
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public boolean checkGrade(User u,Course c);
	/**
	 * 
	    * @Title: findTheGrade
	    * @Description: TODO(根据课程和用户查询评分)
	    * @param @param u
	    * @param @param c
	    * @param @return    参数
	    * @return Grade    返回类型
	    * @throws
	 */
	public Grade findTheGrade(User u,Course c);
	/**
	 * 
	    * @Title: listGrounds
	    * @Description: TODO(根据课程查询此课程的分数集合)
	    * @param @param courseId
	    * @param @return    参数
	    * @return List<Object[]>    返回类型
	    * @throws
	 */
	public List<Grade> listGrounds(int courseId);
	/**
	 * 
	    * @Title: updateGrade
	    * @Description: TODO(更新课程评分字段)
	    * @param @param avgGrade
	    * @param @param courseId    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void updateGrade(double avgGrade,int courseId);
}
