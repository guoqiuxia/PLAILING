package com.es.plailing.relatecomment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;
@Repository
public class RelateCourseCommentDaoImpl extends BaseDao<CourseComment, Integer> {

	/**
	 * 
	    * @Title: getCourseComment
	    * @Description: TODO(通过courseCommentId查找到对应的courseComment对象)
	    * @param @param courseCommentId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return CourseComment    返回类型
	    * @throws
	 */
	public CourseComment getCourseComment(int courseCommentId) throws Exception {
		return get(courseCommentId);
	}
	/**
	 * 
	    * @Title: listCourseComment
	    * @Description: TODO(得到这个课程的评论分页显示)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<Comment>    返回类型
	    * @throws
	 */
	public Page<CourseComment> pageCourseComment(int pageNum,int pageSize,String email) throws Exception{
		String hqlList="from CourseComment cc where cc.courseComment.courseCommentId is null and cc.user.email=? order by cc.courseCommentId desc";
		String hqlCount="select count(*) from CourseComment cc where cc.courseComment.courseCommentId is null and cc.user.email=? order by cc.courseCommentId desc";
		Object[] params= {email};
		return findPage(pageNum, pageSize, hqlCount, hqlList, params);
		
	}
	/**
	 * @throws Exception 
	 * 
	    * @Title: insertCourseComment
	    * @Description: TODO(将用户的此评论插入到数据库中)
	    * @param @param courseComment
	    * @param @param c
	    * @param @param u    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void insertCourseComment(CourseComment courseComment,Course c,User u) throws Exception {
		courseComment.setCourse(c);
		courseComment.setUser(u);
		courseComment.setCourseComment(null);
		c.getCourseComments().add(courseComment);
		u.getCourseComments().add(courseComment);
		save(courseComment);
	}
	/**
	 * @throws Exception 
	 * 
	    * @Title: insertCourseCommentAnswer
	    * @Description: TODO(添加回复的评论)
	    * @param @param courseComment
	    * @param @param newCourseComment
	    * @param @param c
	    * @param @param u
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public void insertCourseCommentAnswer(CourseComment courseComment,CourseComment newCourseComment,Course c,User u) throws Exception {
		newCourseComment.setCourse(c);
		newCourseComment.setUser(u);
		newCourseComment.setCourseComment(courseComment);
		c.getCourseComments().add(newCourseComment);
		u.getCourseComments().add(newCourseComment);
		courseComment.getCourseComments().add(newCourseComment);
		save(newCourseComment);
	}
	/**
	 * 
	    * @Title: getCourseCommentLast
	    * @Description: TODO得到courseComment的相关数据)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Object[]>    返回类型
	    * @throws
	 */
	public List<Object[]> getCourseCommentLast() throws Exception{
		String hql="select cc.user.photo,cc.user.nickName,cc.courseCommentId,cc.commentTime,cc.text from CourseComment cc order by cc.courseCommentId desc";
		Object[] params= {};
		return findByProjection(0, 1, hql, params);
	}
	/**
	 * 
	    * @Title: FindSon
	    * @Description: TODO(查找子评论)
	    * @param @param top
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<CourseComment>    返回类型
	    * @throws
	 */
	public List<CourseComment> FindSon(int top) throws Exception {
		Object[] params= {top};
		return super.find("from CourseComment where top=?",params);
	}
	
}
