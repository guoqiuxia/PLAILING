package com.es.plailing.login.service;

import java.util.List;
import java.util.Map;

import com.es.plailing.entity.User;

/**
 * 
    * @ClassName: LoginService
    * @Description: TODO(注册和登录接口)
    * @author 梁芳芳
    * @date 2018年12月4日
    *
 */
public interface RegisterService {
	
	/**
	 * 
	    * @Title: insertUser
	    * @Description: TODO(注册用户接口)
	    * @param @param user    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void insertUser(User user);
	
	/**
	 * 
	    * @Title: findAllUser
	    * @Description: TODO(查询所有用户的接口)
	    * @param @return    参数
	    * @return List<User>    返回类型
	    * @throws
	 */
	public List<User> findAllUser();
}
