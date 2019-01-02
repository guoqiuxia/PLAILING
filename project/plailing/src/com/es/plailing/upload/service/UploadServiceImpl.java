package com.es.plailing.upload.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.upload.dao.UploadCourseDaoImpl;
import com.es.plailing.upload.dao.UploadUserDaoImpl;

@Service
public class UploadServiceImpl implements UploadService{

	@Resource
	private UploadUserDaoImpl uploadUserDaoImpl;
	@Resource
	private UploadCourseDaoImpl uploadCourseDaoImpl;

	@Override
	public int getUserIdByEmail(String email) {
		try {
		    return uploadUserDaoImpl.getUserIdByEmail(email);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Page<Course> listCourseByUserId(int pageNum, int pageSize, int userId) {
		try {
			return uploadCourseDaoImpl.listCourseByUserId(pageNum,pageSize,userId);
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
