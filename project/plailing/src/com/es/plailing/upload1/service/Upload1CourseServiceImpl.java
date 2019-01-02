package com.es.plailing.upload1.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.coursedetail.dao.CourseDaoImpl;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.CourseType;
import com.es.plailing.upload1.dao.Upload1CourseCatalogDaoImpl;
import com.es.plailing.upload1.dao.Upload1CourseDaoImpl;
import com.es.plailing.upload1.dao.Upload1CourseTypeDaoImpl;


@Service("uploadtype")
@Transactional(readOnly=true)
public class Upload1CourseServiceImpl implements Upload1CourseService {
	@Resource
	private CourseDaoImpl courseDaoImpl;
	@Resource
	private Upload1CourseTypeDaoImpl  courseTypeDaoImpl;
	@Resource
	private Upload1CourseCatalogDaoImpl courseCatalogDaoImpl;
	@Resource
	private Upload1CourseDaoImpl upload1CourseDaoImpl;
	@Transactional(readOnly=false)
	public void Save(Course entity) {
		try {
			courseDaoImpl.save(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Transactional(readOnly=false)
	public void SaveCatalog(CourseCatalog courseCatalog) {
		try {
			courseCatalogDaoImpl.save(courseCatalog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<CourseType>FindAll() {
		List<CourseType> courseTypes;
		 try {
			courseTypes=courseTypeDaoImpl.findAll();
			return courseTypes;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Object[]> Find(Object[]objects){
		try {
			return courseTypeDaoImpl.Find(objects);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public CourseType Get(Integer typeId) {
		try {
			return courseTypeDaoImpl.Get(typeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public CourseCatalog FindOne(Object[]objects){
		try {
			return courseCatalogDaoImpl.findOne(objects);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public Course GetCourse(Integer courseId) {
		try {
			return upload1CourseDaoImpl.Get(courseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public CourseCatalog findCatalog(String catalogName,int courseId) {
		try {
			return courseCatalogDaoImpl.findCatalog(catalogName,courseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
