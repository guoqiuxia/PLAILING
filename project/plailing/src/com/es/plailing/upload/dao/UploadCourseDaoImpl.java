package com.es.plailing.upload.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;

@Repository
public class UploadCourseDaoImpl extends BaseDao<Course,Integer>{
	/**
	 * 
	    * @Title: listCourseByUserId
	    * @Description: TODO(通过userId查找他上传的课程有哪些)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<Course>    返回类型
	    * @throws
	 */
	public Page<Course> listCourseByUserId(int pageNum,int pageSize,int userId) throws Exception{
		String hqlCount="select count(*) from Course c where c.user.userId=? and c.state=1";
		String hqlList="from Course c where c.user.userId=? and c.state=1";
		Object[] params= {userId};
		return findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}
}
