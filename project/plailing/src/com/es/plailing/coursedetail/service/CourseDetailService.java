package com.es.plailing.coursedetail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.coursedetail.dao.UserCollectionCourseDaoImpl;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserBalance;
import com.es.plailing.entity.UserCollectionCourse;
import com.es.plailing.entity.UserJoinCourse;;

/**
 * 
    * @ClassName: CourseDetailService
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author liushanshan
    * @date 2018年11月28日
    *
 */
@Service
public interface CourseDetailService {
	/**
	 * 
	    * @Title: getCourse
	    * @Description: TODO(通过课程id找到课程)
	    * @param @param courseId
	    * @param @return    参数
	    * @return Course    返回类型
	    * @throws
	 */
	public Course getCourse(int courseId);
	/**
	 * 
	    * @Title: getStudyCoursePeople
	    * @Description: TODO(通过课程找出学习课程人数)
	    * @param @param courseId
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	public int getStudyCoursePeople(int courseId);
	/**
	 * 
	    * @Title: listCourseCatalog
	    * @Description: TODO(通过课程号找到课程的一级目录,分页显示)
	    * @param @param courseId
	    * @param @return    参数
	    * @return List<CourseCatalog>    返回类型
	    * @throws
	 */
	public Page<CourseCatalog> listCourseCatalog(int pageNum,int pageSize,int courseId);
	/**
	 * 
	    * @Title: getCourseUser
	    * @Description: TODO(通过userId得到User)
	    * @param @param userId
	    * @param @return    参数
	    * @return User    返回类型
	    * @throws
	 */
	public User getCourseUser(int userId);
	/**
	 * 
	    * @Title: getUserUploadCourse
	    * @Description: TODO(通过userId找到上传课程的数量)
	    * @param @param userId
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	public int getUserUploadCourse(int userId);
	/**
	 * 
	    * @Title: getCourseUserId
	    * @Description: TODO(通过课程号找到上传课程的人)
	    * @param @param courseId
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	public int getCourseUserId(int courseId);
	/**
	 * 
	    * @Title: getUserByEmail
	    * @Description: TODO(通过email查找对象)
	    * @param @param email
	    * @param @return    参数
	    * @return Users    返回类型
	    * @throws
	 */
	public User getUserByEmail(String email);
	/**
	 * 
	    * @Title: listCourse
	    * @Description: TODO(获取同种类型的三个课程)
	    * @param @param courseId
	    * @param @return    参数
	    * @return List<Course>    返回类型
	    * @throws
	 */
	public List<Course> listCourse(int courseId);
	/**
	 * 
	    * @Title: insert
	    * @Description: TODO(修改用户信息)
	    * @param @param u    参数
	    * @return void    返回类型
	    * @throws
	 */
	public boolean updateUser(User u);
	/**
	 * 
	    * @Title: insertUserBalance
	    * @Description: TODO(添加零钱明细)
	    * @param @param u
	    * @param @param ub
	    * @param @param c
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public boolean insertUserBalance(User u,UserBalance ub,Course c);
	/**
	 * 
	    * @Title: insert
	    * @Description: TODO(添加收益表)
	    * @param @param c
	    * @param @param u    参数
	    * @return void    返回类型
	    * @throws
	 */
	public boolean insert(Course c,User u);
	/**
	 * 
	    * @Title: isCollection
	    * @Description: TODO(判断这个课程是否被这个用户收藏)
	    * @param @param userId
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public boolean isCollection(int userId,int courseId);
	/**
	 * 
	    * @Title: insertCollection
	    * @Description: TODO(将用户和课程加入到收藏表中)
	    * @param @param course
	    * @param @param user
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public boolean insertCollection(Course course,User user);
	/**
	 * 
	    * @Title: updateCollection
	    * @Description: TODO(取消收藏)
	    * @param @param ucc
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public boolean updateCollection(int courseId,int userId);
	/**
	 * 
	    * @Title: isCollection
	    * @Description: TODO(判断这个课程是否被这个用户加入)
	    * @param @param userId
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public boolean isJoin(int userId,int courseId);
	/**
	 * 
	    * @Title: insertJoin
	    * @Description: TODO(添加课程收藏表)
	    * @param @param u
	    * @param @param c
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public boolean insertJoin(User u,Course c);
	/**
	 * 
	    * @Title: updateCourse
	    * @Description: TODO(修改课程信息)
	    * @param @param course
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public boolean updateCourse(Course course);
}
