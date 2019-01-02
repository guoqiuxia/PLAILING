package com.es.plailing.relatecourseinform.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;


@Repository
public class CourseInformPageDaoImpl extends BaseDao<Inform, Integer> {

	
	
	public Page<Inform> findPage(int pageNum, int pageSize, int userId) throws Exception{
		String hqlCount="select count(*) from Inform i where i.state=1 and i.course.courseId in (select jc.course.courseId from UserJoinCourse jc where jc.user.userId=?)";
		String hqlList="from Inform i where i.state=1 and i.course.courseId in (select jc.course.courseId from UserJoinCourse jc where jc.user.userId=?)"; 
		Object[] params= {userId};
		return this.findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}
	
	
}
