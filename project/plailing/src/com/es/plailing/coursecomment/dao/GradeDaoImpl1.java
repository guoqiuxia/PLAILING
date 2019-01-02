package com.es.plailing.coursecomment.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.util.BaseDao;

@Repository
public class GradeDaoImpl1 extends BaseDao<Course,Integer>{
	public Course getCourseById(int courseId) throws Exception{
		return this.get(courseId);
	}
	public void updateGrade(double avgGrade,int courseId) throws Exception{
		String hql = "from Course c where c.courseId=?";
		Object[] params = {courseId};
		Course course = this.findOne(hql, params);
		course.setGrade(avgGrade);
		this.update(course);
	}
}
