package com.es.plailing.study.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserBalance;
import com.es.plailing.entity.UserJoinCourse;
import com.es.plailing.util.BaseDao;

/*
 * 
    * @ClassName: StudyDaoImpl
    * @Description: 用于study.jsp的数据库连接查询
    * @author 张思嘉
    * @date 2018年12月3日
    *
 */
@Repository
public class StudyDaoImpl extends BaseDao<UserJoinCourse,String>{

	/**
	 * 
	    * @Title: findUser
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return User    返回类型
	    * @throws
	 */
	public List<UserJoinCourse> findCourses(User user) throws Exception {
		String hql="from UserJoinCourse UJC where UJC.user=?";
		Object[] params= {user};
		return super.find(hql, params);
	}
	
	/**
	 * 
	    * @Title: joinCourseByPage
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<UserJoinCourse>    返回类型
	    * @throws
	 */
	public Page<UserJoinCourse> joinCourseByPage(int pageNum, int pageSize,String email) throws Exception {
		String hqlCount = "select count(*) from UserJoinCourse UB where UB.user.email=?";
		String hql = "from UserJoinCourse UB where UB.user.email=?";//按时间倒叙查询
		Object [] params = {email};
		Page<UserJoinCourse> joinCoursePageList = super.findPage(pageNum, pageSize, hqlCount,hql, params);
		return joinCoursePageList;
	}

	
	
}
