package com.es.plailing.checkinform.service;

import java.util.List;

import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;

/**
 * 
    * @ClassName: CourseReleaseService
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 梁芳芳
    * @date 2018年12月18日
    *
 */
public interface CheckInformService {

	/**
	 * 
	    * @Title: findInform
	    * @Description: TODO(根据id查询上传课程通知)
	    * @param @param userId
	    * @param @return    参数
	    * @return List<Inform>    返回类型
	    * @throws
	 */
	public List<Inform> findInform(int userId);
	
	/**
	 * 
	    * @Title: pageInform
	    * @Description: TODO(根据id分页查询上传课程通知)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return    参数
	    * @return Page<Inform>    返回类型
	    * @throws
	 */
	public Page<Inform> pageInform(int pageNum,int pageSize,int userId);
}
