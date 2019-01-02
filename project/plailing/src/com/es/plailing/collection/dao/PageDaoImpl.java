package com.es.plailing.collection.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: PageDaoImpl
    * @Description: TODO(实现对数据库的数据进行分页)
    * @author 梁芳芳
    * @date 2018年12月3日
    *
 */

@Repository
public class PageDaoImpl extends BaseDao<Course, Integer> {
	
	/**
	 * @throws Exception 
	 * 
	    * @Title: findPage
	    * @Description: TODO(分页查询)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param email
	    * @param @return    参数
	    * @return Page<Course>    返回类型
	    * @throws
	 */
	public Page<Course> findPage(int pageNum, int pageSize, String email) throws Exception{
		String hqlCount="select count(c.collectionId) from UserCollectionCourse c where c.state=1 and c.user.userId = (select u.userId from User u where u.email=?)";
		String hqlList="from Course c where c.courseId in (select uc.course.courseId from UserCollectionCourse uc where uc.user.userId=(select u.userId from User u where u.email=?))";
		Object[] params= {email};
		return this.findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}
	
	public List<Course> findCourse(String email) throws Exception{
		String hql="from Course c where c.courseId in (select uc.course.courseId from UserCollectionCourse uc where uc.state=1 and uc.user.userId=(select u.userId from User u where u.email=?))";
		Object[] params= {email};
		return find(hql, params);
	}
	
}
