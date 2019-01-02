package com.es.plailing.study.service;

import java.util.List;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserJoinCourse;

public interface StudyService {
	
	public Page<UserJoinCourse> joinCourseByPage(int pageNum, int pageSize,String email) throws Exception;
}
