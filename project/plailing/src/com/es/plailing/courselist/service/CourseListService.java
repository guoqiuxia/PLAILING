package com.es.plailing.courselist.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseType;
import com.es.plailing.entity.Page;


/**
 * 
    * @ClassName: CourseListService
    * @Description: TODO(courselist页面service接口类)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
@Service
public interface CourseListService {
	public List<CourseType> listAllCoursePareType(); 
	public CourseType getPareType(int tId);
	public Page<Course> listChildCoursesPage(int pageNum, int pageSize,CourseType cCourseType);
	public Page<Course> listParentCoursesPage(int pageNum, int pageSize,CourseType fCourseType);
	public List<Course> listCourseHotCourses();
	public List<Course> listAllCourses();
	public Page<Course> listAllCoursesPage(int pageNum,int pageSize,int total);
	public List<CourseType> listCoursesChildType(int fId);
}

