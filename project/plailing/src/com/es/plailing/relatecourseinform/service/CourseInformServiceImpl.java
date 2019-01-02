package com.es.plailing.relatecourseinform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserJoinCourse;
import com.es.plailing.relatecourseinform.dao.CourseInformDaoImpl;
import com.es.plailing.relatecourseinform.dao.CourseInformPageDaoImpl;
import com.es.plailing.relatecourseinform.dao.InformDaoImpl;

@Service
public class CourseInformServiceImpl implements CourseInformService{
	
	@Resource
	private CourseInformDaoImpl courseInformDaoImpl;
	
	@Resource
	private CourseInformPageDaoImpl courseInformPageDaoImpl;

	@Resource
	private InformDaoImpl informDaoImpl;
	
	

	@Override
	public List<Inform> findInform(int courseId) {
		
		try {
			return informDaoImpl.findInform(courseId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Page<Inform> findPage(int pageNum, int pageSize, int userId) {
		
		try {
			return courseInformPageDaoImpl.findPage(pageNum, pageSize, userId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<UserJoinCourse> find(int userId) {
		try {
			return courseInformDaoImpl.find(userId);
		} catch (Exception e) {
			return null;
		}
	}

	

	
}
