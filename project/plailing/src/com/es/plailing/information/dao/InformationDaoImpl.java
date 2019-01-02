package com.es.plailing.information.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;
/**
 * 
    * @ClassName: InformationDaoImpl
    * @Description: TODO(information页面关于课程的dao)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
@Repository
public class InformationDaoImpl extends BaseDao<Course,Integer>{
	/**
	 * 
	    * @Title: listPersonCourse
	    * @Description: TODO(查询某个用户的当前页的课程)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param user
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<Course>    返回类型
	    * @throws
	 */
	public Page<Course> listPersonCourse(int pageNum, int pageSize,User user) throws Exception{
		String hqlCount="select count(*) from Course c where c.user=? and c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc)";
		String hqlList = "from Course c where c.user=? and c.state=1 and c.courseId in (select cc.course.courseId from CourseCatalog cc)";
		Object[] params = {user};
		return this.findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}
}
