package com.es.plailing.courselist.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.es.plailing.entity.CourseType;
import com.es.plailing.util.BaseDao;


@Repository
/**
 * 
    * @ClassName: CourseListDaoImpl
    * @Description: TODO(courselist页面关于CourseType的dao)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
public class CourseListDaoImpl extends BaseDao<CourseType,Integer>{
	/**
	 * 
	    * @Title: findAllCourseParentType
	    * @Description: TODO(查询所有课程的父类型)
	    * @param @return 
	    * @param @throws Exception    参数
	    * @return List<CourseType>    
	    * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<CourseType> listAllCourseParentType() throws Exception{
		String hql = "from CourseType ct where ct.courseType=null";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	/**
	 * 
	    * @Title: getParentType
	    * @Description: TODO(通过课程类型Id查询课程类型)
	    * @param @param tId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return CourseType   
	    * @throws
	 */
	public CourseType getParentType(int tId) throws Exception {
		String hql = "from CourseType ct where ct.typeId=?";
		Object[] params = {tId};
		return this.findOne(hql, params);
	}
	@SuppressWarnings("unchecked")
	public List<CourseType> listCourseChildType(int fId) throws Exception{
		String hql = "from CourseType ct where ct.courseType.typeId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0,fId);
		return query.list();
	}
}
