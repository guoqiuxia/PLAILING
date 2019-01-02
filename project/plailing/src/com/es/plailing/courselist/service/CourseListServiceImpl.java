package com.es.plailing.courselist.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.es.plailing.courselist.dao.CourseListDaoImpl;
import com.es.plailing.courselist.dao.CourseListDaoImpl1;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseType;
import com.es.plailing.entity.Page;
/**
 * 
    * @ClassName: CourseListServiceImpl
    * @Description: TODO(courselist页面service实现类)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
@Service
public class CourseListServiceImpl implements CourseListService{
	@Resource
	private CourseListDaoImpl courseListDaoImpl;
	@Resource
	private CourseListDaoImpl1 courseListDaoImpl1;
	@Override
	public List<CourseType> listAllCoursePareType(){
		// TODO Auto-generated method stub
		try {
			return courseListDaoImpl.listAllCourseParentType();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CourseType getPareType(int tId) {
		// TODO Auto-generated method stub
		try {
			return courseListDaoImpl.getParentType(tId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Page<Course> listChildCoursesPage(int pageNum, int pageSize, CourseType cCourseType) {
		// TODO Auto-generated method stub
		try {
			return this.courseListDaoImpl1.listChildCoursePage(pageNum, pageSize, cCourseType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Page<Course> listParentCoursesPage(int pageNum, int pageSize, CourseType fCourseType) {
		// TODO Auto-generated method stub
		try {
			return this.courseListDaoImpl1.listParentCoursePage(pageNum, pageSize, fCourseType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Course> listCourseHotCourses() {
		// TODO Auto-generated method stub
		try {
			return this.courseListDaoImpl1.listCourseHotCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Page<Course> listAllCoursesPage(int pageNum, int pageSize,int total) {
		// TODO Auto-generated method stub
		try {
			return this.courseListDaoImpl1.listAllCoursePage(pageNum, pageSize,total);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Course> listAllCourses() {
		// TODO Auto-generated method stub
		try {
			return this.courseListDaoImpl1.listAllCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CourseType> listCoursesChildType(int fId) {
		// TODO Auto-generated method stub
		try {
			return this.courseListDaoImpl.listCourseChildType(fId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}



}
