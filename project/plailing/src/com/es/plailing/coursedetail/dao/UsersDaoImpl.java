package com.es.plailing.coursedetail.dao;

import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

@Repository
public class UsersDaoImpl extends BaseDao<User,Integer>{
	
	/**
	 * 
	    * @Title: insert
	    * @Description: TODO(修改用户信息)
	    * @param @param u
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void updateUser(User u) throws Exception {
		update(u);
	}
	
	/**
	 * 
	    * @Title: getCourseUser
	    * @Description: TODO(通过userId找到用户)
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return User    返回类型
	    * @throws
	 */
	public User getCourseUser(int userId) throws Exception {
		return get(userId);
	}
	
	/**
	 * 
	    * @Title: getUserUploadCourse
	    * @Description: TODO(通过userId找到这个客户上传的课程数)
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return int    返回类型
	    * @throws
	 */
	public int getUserUploadCourse(int userId) throws Exception {
		return get(userId).getUploadCourses().size();
	}
	/**
	 * 
	    * @Title: getUserByEmail
	    * @Description: TODO(通过email查找对象)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Users    返回类型
	    * @throws
	 */
	public User getUserByEmail(String email) throws Exception {
		String hql="from User u where u.email=?";
		Object[] params= {email};
		return findOne(hql,params);
	}
	/**
	 * 
	    * @Title: getTeacher
	    * @Description: TODO(通过目录id查询发布的用户)
	    * @param @param catalogId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return User    返回类型
	    * @throws
	 */
	public User getTeacher(int catalogId) throws Exception{
		String hql = "from User u where u.userId=(select c.user.userId from Course c where c.courseId=(select cc.course.courseId from CourseCatalog cc where cc.catalogId=?))";
		Object[] params = {catalogId};
		return this.findOne(hql, params);
	}

	
}
