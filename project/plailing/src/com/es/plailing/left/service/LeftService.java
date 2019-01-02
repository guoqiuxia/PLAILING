package com.es.plailing.left.service;

import com.es.plailing.entity.User;

/**
 * 
    * @ClassName: LeftService
    * @Description: TODO(查询接口)
    * @author 梁芳芳
    * @date 2018年12月3日
    *
 */
public interface LeftService {
	
	/**
	 * 
	    * @Title: findOne
	    * @Description: TODO(按条件查询接口)
	    * @param @param email
	    * @param @return    参数
	    * @return User    返回类型
	    * @throws
	 */

	public User findLeft(String email);
}
