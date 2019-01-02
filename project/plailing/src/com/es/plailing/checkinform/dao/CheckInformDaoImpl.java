package com.es.plailing.checkinform.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: CourseReleaseDaoImpl
    * @Description: TODO(连接数据库)
    * @author 梁芳芳
    * @date 2018年12月18日
    *
 */
@Repository
public class CheckInformDaoImpl extends BaseDao<Inform, Integer>{

	/**
	 * 
	    * @Title: findCourse
	    * @Description: TODO(根据Id获取上传课程的通知)
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Course>    返回类型
	    * @throws
	 */
	public List<Inform> findInform(int userId) throws Exception{
		String hql="from Inform i where i.state=0 and i.course.courseId in (select c.courseId from Course c where c.user.userId=?)";
		Object[] params= {userId};
		return find(hql, params);
	}
	
	/**
	 * 
	    * @Title: pageInform
	    * @Description: TODO(根据用户Id分页查询上传课程信息通知)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<Inform>    返回类型
	    * @throws
	 */
	public Page<Inform> pageInform(int pageNum,int pageSize,int userId) throws Exception{
		String hqlCount="select count(*) from Inform i where i.state=0 and i.course.courseId in (select c.courseId from Course c where c.user.userId=?)";
		String hqlList="from Inform i where i.state=0 and i.course.courseId in (select c.courseId from Course c where c.user.userId=?)"; 
		Object[] params= {userId};
		return findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}
}
