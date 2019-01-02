package com.es.plailing.coursedetail.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserJoinCourse;
import com.es.plailing.util.BaseDao;

@Repository
public class DetailUserJoinCourse extends BaseDao<UserJoinCourse,Integer>{
	
	/**
	 * 
	    * @Title: isCollection
	    * @Description: TODO(判断这个课程是否被这个用户加入)
	    * @param @param userId
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public boolean isJoin(int userId,int courseId) throws Exception {
		String hql="from UserJoinCourse ujc where ujc.user.userId=? and ujc.course.courseId=?";
		Object[] params= {userId,courseId};
		UserJoinCourse ujc=findOne(hql,params);
		if(ujc!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	    * @Title: insertJoin
	    * @Description: TODO(添加课程收藏表)
	    * @param @param u
	    * @param @param c
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void insertJoin(User u,Course c) throws Exception {
		UserJoinCourse ujc=new UserJoinCourse();
		ujc.setCourse(c);
		ujc.setJoinTime(new Date());
		ujc.setUser(u);
		c.getJoinUsers().add(ujc);
		u.getJoinCourses().add(ujc);
		save(ujc);
	}
}
