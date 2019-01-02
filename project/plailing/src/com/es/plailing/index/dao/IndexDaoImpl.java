package com.es.plailing.index.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.util.BaseDao;
/**
 * 
    * @ClassName: IndexDaoImpl
    * @Description: TODO(index页面关于课程的dao)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
@Repository
public class IndexDaoImpl extends BaseDao<Course,Integer>{
	/**
	 * 
	    * @Title: listCourseByGrades
	    * @Description: TODO(按价格查询12节课程)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Course>  List<Course>
	    * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Course> listCourseByGrades() throws Exception{
		String hql="from Course as c where c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc) order by c.grade desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setMaxResults(8);
		List<Course> list = query.list();
		return list;
	}
	/**
	 * 
	    * @Title: listHotCourse
	    * @Description: TODO(按评分查询4节课程)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Course>    List<Course>
	    * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Course> listHotCourse() throws Exception{
		String hql="from Course as c where c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc) order by c.courseId desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setMaxResults(4);
		List<Course> list = query.list();
		return list;
	}
}
