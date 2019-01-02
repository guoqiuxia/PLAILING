package com.es.plailing.relatecourseinform.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserJoinCourse;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: RelateDaoImpl
    * @Description: TODO(连接数据库)
    * @author 梁芳芳
    * @date 2018年12月3日
    *
 */

@Repository
public class CourseInformDaoImpl extends BaseDao<UserJoinCourse, Integer> {

	/**
	 * 
	    * @Title: find
	    * @Description: TODO(根据用户Id查询加入的所有课程)
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Course>    返回类型
	    * @throws
	 */
	public List<UserJoinCourse> find(int userId) throws Exception{
		String hql="from UserJoinCourse u where u.user.userId=?";
		Object[] params= {userId};
		return find(hql, params);
	}
	
}
