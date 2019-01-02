package com.es.plailing.check.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.check.dao.CheckCourseDaoImpl;
import com.es.plailing.check.dao.CheckCourseTypeDaoImpl;
import com.es.plailing.check.dao.CheckDaoImpl;
import com.es.plailing.check.dao.CheckDemandDaoImpl;
import com.es.plailing.entity.CourseType;
import com.es.plailing.entity.Demand;
import com.es.plailing.entity.User;

@Service
@Transactional(readOnly=false)
public class CheckServiceImpl implements CheckService {
	@Resource
	private CheckCourseTypeDaoImpl checkCourseTypeDaoImpl;
	@Resource
	private CheckDaoImpl chackDaoImpl;
	@Resource
	private CheckCourseDaoImpl chackCourseDaoImpl;
	@Resource
	private CheckDemandDaoImpl checkUserDemandDaoImpl;
	
	@Override
	public List<CourseType> courseTypeList() {
		try {
			return checkCourseTypeDaoImpl.courseTypeList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Object[]> find(Object[]objects){
		try {
			return checkCourseTypeDaoImpl.Find(objects);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	public void insertAuditing(User user,String personalInfo,String identityPic,
			String teachVideo,String certificate,int state) {
		try {
			chackDaoImpl.insertAuditing(user,personalInfo,identityPic,teachVideo,certificate,state);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public CourseType findTypeId(int typeId) {
		try {
			return checkCourseTypeDaoImpl.findTypeId(typeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void insertCourse(String name,String photo,double price,String courseInfo,User user,
			double grade,CourseType courseType,int joinCount,int state,Demand demand) {
		try {
			chackCourseDaoImpl.insertCourse(name, photo, price, courseInfo, user, grade, courseType, joinCount, state, demand);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Demand findDemand(int demandId) {
		try {
			return checkUserDemandDaoImpl.findDemand(demandId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
