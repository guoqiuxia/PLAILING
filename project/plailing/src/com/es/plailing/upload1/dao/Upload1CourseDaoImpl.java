package com.es.plailing.upload1.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.util.BaseDao;
@Repository
public class Upload1CourseDaoImpl extends BaseDao<Course, Integer> {
	/**
	 * 
	    * @Title: get
	    * @Description: TODO(根据课程id查询课程)
	    * @param @param courseId
	    * @param @throws Exception    参数
	    * @return Course    返回类型
	    * @throws
	 */
	public Course Get(Integer courseId) throws Exception {
		
		return super.get(courseId);
	}
}
