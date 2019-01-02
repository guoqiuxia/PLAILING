package com.es.plailing.relatecomment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

@Service
public interface RelateCourseCommentService {
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
	public Page<CourseComment> pageCourseComment(int pageNum,int pageSize,String email);
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
	public List<Object[]> getCourseCommentLast();
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
}
