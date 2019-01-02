package com.es.plailing.study.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserBalance;
import com.es.plailing.entity.UserJoinCourse;
import com.es.plailing.study.dao.StudyDaoImpl;

/*
 * 
    * @ClassName: StudyServiceImpl
    * @Description: TODO(study的service类调用对应Dao查找对应用户)
    * @author 张思嘉
    * @date 2018年12月3日
    *
 */
@Service
@Transactional(readOnly=true)
public class StudyServiceImpl implements StudyService{
	@Resource
	private StudyDaoImpl studyDaoImpl;

	
	public Page<UserJoinCourse> joinCourseByPage(int pageNum, int pageSize,String email) throws Exception {
		return studyDaoImpl.joinCourseByPage(pageNum, pageSize, email); 
	}
}
