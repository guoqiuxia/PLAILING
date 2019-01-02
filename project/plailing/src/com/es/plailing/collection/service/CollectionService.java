package com.es.plailing.collection.service;

import java.util.List;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

/**
 * 
    * @ClassName: CollectionService
    * @Description: TODO(这是一个接口)
    * @author 梁芳芳
    * @date 2018年12月3日
    *
 */
public interface CollectionService {
	
	/**
	 * 
	 * 
	    * @Title: findOne
	    * @Description: TODO(按条件查询用户接口)
	    * @param @param email
	    * @param @return    参数
	    * @return User    返回类型
	    * @throws
	 */
	
	public User findOne(String email);
	
	/**
	 * 
	    * @Title: findPage
	    * @Description: TODO(分页查询)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param email
	    * @param @return    参数
	    * @return Page<Course>    返回类型
	    * @throws
	 */
	public Page<Course> findPage(int pageNum, int pageSize, String email);
	
	/**
	 * 
	    * @Title: findCourse
	    * @Description: TODO(查询参加这门课的人数)
	    * @param @param email
	    * @param @return    参数
	    * @return List<Course>    返回类型
	    * @throws
	 */
	
	public List<Course> findCourse(String email);
	
	/**
	 * 
	    * @Title: checkCourse
	    * @Description: TODO(核对信息查询接口)
	    * @param @param userId
	    * @param @param courseId
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	
	public boolean checkCourse(int userId,int courseId);
	
	/**
	 * 
	    * @Title: deleteCourse
	    * @Description: TODO(更改数据状态)
	    * @param @param userId
	    * @param @param courseId    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void deleteCourse(int userId,int courseId);
}
