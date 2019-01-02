package com.es.plailing.relatecourseinform.service;

import java.util.List;


import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.UserJoinCourse;

/**
 * 
    * @ClassName: RelateService
    * @Description: TODO(查询接口)
    * @author 梁芳芳
    * @date 2018年12月3日
    *
 */
public interface CourseInformService {
	
	/**
	 * 
	    * @Title: find
	    * @Description: TODO(根据用户Id查询加入的所有课程)
	    * @param @param userId
	    * @param @return    参数
	    * @return User    返回类型
	    * @throws
	 */
	public List<UserJoinCourse> find(int userId);
	
	/**
	 * 
	    * @Title: findInform
	    * @Description: TODO(根据课程号获取通知)
	    * @param @param courseId
	    * @param @return    参数
	    * @return List<Inform>    返回类型
	    * @throws
	 */
	public List<Inform> findInform(int courseId);
	
	/**
	 * 
	    * @Title: findPage
	    * @Description: TODO(根据用户id分页查询)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return    参数
	    * @return Page<Inform>    返回类型
	    * @throws
	 */
	public Page<Inform> findPage(int pageNum, int pageSize, int userId);
}
