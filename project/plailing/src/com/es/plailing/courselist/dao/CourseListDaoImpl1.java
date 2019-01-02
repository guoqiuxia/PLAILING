package com.es.plailing.courselist.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseType;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;
/**
 * 
    * @ClassName: CourseListDaoImpl1
    * @Description: TODO(courselist页面关于课程的dao)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
@Repository
public class CourseListDaoImpl1 extends BaseDao<Course,Integer>{
/**
 * 
    * @Title: listAllCourse
    * @Description: TODO(查询所有的课程)
    * @param @return
    * @param @throws Exception    参数
    * @return List<Course>    返回类型
    * @throws
 */
	@SuppressWarnings("unchecked")
	public List<Course> listAllCourse() throws Exception {
		String hql = "from Course c where c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc)"; 
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		List<Course> list = query.list();
		return list;
	}
	/**
	 * 
	    * @Title: listAllCoursePage
	    * @Description: TODO(查询当前页的全部课程)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<Course>    返回类型
	    * @throws
	 */
	@SuppressWarnings("unchecked")
	public Page<Course> listAllCoursePage(int pageNum, int pageSize,int total) throws Exception {
		String hql = "from Course c where c.state=1  and c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc)";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Course> rows = query.list();
		return new Page<Course>(pageNum, pageSize, (int) total, rows);
	}
	/**
	 * 
	    * @Title: listChildCoursePage
	    * @Description: TODO(按照课程子类型查询当前页的所有课程)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param cCourseType
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<Course>    返回类型
	    * @throws
	 */
	public Page<Course> listChildCoursePage(int pageNum, int pageSize,CourseType cCourseType)
			throws Exception {
		String hqlCount = "select count(*) from Course c where c.courseType=? and c.state=1  and c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc)";
		String hqlList = "from Course c where c.courseType=? and c.state=1  and c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc)";
		Object[] params = {cCourseType};
		return this.findPage(pageNum, pageSize, hqlCount, hqlList, params);
		
	}
	/**
	 * 
	    * @Title: listParentCoursePage
	    * @Description: TODO(按照课程父类型查询当前页的所有课程)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param fCourseType
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<Course>    返回类型
	    * @throws
	 */
	public Page<Course> listParentCoursePage(int pageNum, int pageSize,CourseType fCourseType)
			throws Exception {
		String hqlCount = "select count(*) from Course c where c.courseType.courseType=? and c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc)";
		String hqlList = "from Course c where c.courseType.courseType=? and c.state=1  and c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc)";
		Object[] params = {fCourseType};
		return this.findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}
	/**
	 * 
	    * @Title: listCourseHotCourse
	    * @Description: TODO(按照评分查询8节课程)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Course>    返回类型
	    * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Course> listCourseHotCourse() throws Exception{
		String hql="from Course as c where c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc) order by c.joinCount desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setMaxResults(8);
		List<Course> list = query.list();
		return list;
	}

}
