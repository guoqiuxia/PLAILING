package com.es.plailing.coursedetail.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserCollectionCourse;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: CourseDetailDaoImpl
    * @Description: 从数据库中查找所需要的数据
    * @author liushanshan
    * @date 2018年11月28日
    *
 */
@Repository
public class CourseDaoImpl extends BaseDao<Course,Integer>{
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private UsersDaoImpl userDaoImpl;
	/**
	 * 
	    * @Title: updateCourse
	    * @Description: TODO(修改课程信息)
	    * @param @param course
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void updateCourse(Course course) throws Exception {
		update(course);
	}

	/**
	    * @Title: getCourse
	    * @Description: TODO(通过课程的Id得到course)
	    * @param @param courseId 课程表的id
	    * @param @return 
	    * @param @throws Exception    参数
	    * @return Course    返回类型
	    * @throws
	 */
	public Course getCourse(int courseId) throws Exception{	
		return get(courseId);
	}
	
	/**
	 * 
	    * @Title: getStudyCoursePeople
	    * @Description: TODO(得到上这节课的人数)
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return int    返回类型
	    * @throws
	 */
	public int getStudyCoursePeople(int courseId) throws Exception {
		return get(courseId).getJoinUsers().size();
	}
	/**
	 * 
	    * @Title: getCourseUserId
	    * @Description: TODO(找到上传课程的那个用户的id)
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return int    返回类型
	    * @throws
	 */
	public int getCourseUserId(int courseId) throws Exception {
		return get(courseId).getUser().getUserId();
	}
	

	/**
	 * 
	    * @Title: listCourse
	    * @Description: TODO(获取同种类型的三个课程)
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Course>    返回类型
	    * @throws
	 */
	public List<Course> listCourse(int courseId) throws Exception{
		int typeId =get(courseId).getCourseType().getTypeId();
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Course c where c.courseType.typeId=? and c.courseId !=?");
		q.setParameter(0, typeId);
		q.setParameter(1, courseId);
		q.setFirstResult(0);
		q.setMaxResults(3);
		return q.list();
	}
	
	
	
	/**
	 * 
	    * @Title: save
	    * @Description: TODO(上传课程)
	    * @param @param entity
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void save(Course entity) throws Exception {
		
		super.save(entity);
	}
}
