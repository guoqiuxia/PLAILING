package com.es.plailing.check.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseType;
import com.es.plailing.entity.Demand;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserDemand;
import com.es.plailing.util.BaseDao;

/**
    * @ClassName: CheckCourseDaoImpl
    * @Description: TODO(check.jsp页面有关Course表的操作)
    * @author 郭秋霞
    * @date 2018年12月19日
    *
    */
@Repository
public class CheckCourseDaoImpl extends BaseDao<Course,Integer>{
	/**
	 * 
	    * @Title: insertCourse
	    * @Description: TODO(通过传参向Course表中插入数据)
	    * @param @param name
	    * @param @param photo
	    * @param @param price
	    * @param @param courseInfo
	    * @param @param user
	    * @param @param grade
	    * @param @param courseType
	    * @param @param joinCount
	    * @param @param state
	    * @param @param demand
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void insertCourse(String name,String photo,double price,String courseInfo,User user,
			double grade,CourseType courseType,int joinCount,int state,Demand demand) throws Exception {
		Course course = new Course();
		course.setName(name);
		course.setPhoto(photo);
		course.setPrice(price);
		course.setCourseInfo(courseInfo);
		course.setUser(user);
		course.setGrade(grade);
		course.setCourseType(courseType);
		course.setJoinCount(joinCount);
		course.setState(state);
		course.setDemand(demand);
		save(course);
	}
}
