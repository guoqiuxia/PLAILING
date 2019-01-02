package com.es.plailing.check.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.entity.CourseType;
import com.es.plailing.entity.Demand;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserDemand;

@Service
@Transactional(readOnly=false)
public interface CheckService{
	public List<CourseType> courseTypeList();
	
	public List<Object[]> find(Object[]objects);
		
	public void insertAuditing(User user,String personalInfo,String identityPic,
			String teachVideo,String certificate,int state);
	
	public CourseType findTypeId(int typeId);
	
	public void insertCourse(String name,String photo,double price,String courseInfo,User user,
			double grade,CourseType courseType,int joinCount,int state,Demand demand);
	
	public Demand findDemand(int demandId);
}
