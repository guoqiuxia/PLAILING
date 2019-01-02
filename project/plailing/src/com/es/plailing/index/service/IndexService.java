package com.es.plailing.index.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.User;
/**
 * 
    * @ClassName: IndexService
    * @Description: TODO(index页面service接口类)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
@Service
public interface IndexService {
	public List<Course> listCoursesByGrades();
	public List<Course> listHotCourses();

}
