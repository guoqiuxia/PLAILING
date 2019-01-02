package com.es.plailing.login.dao;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: LoginDaoImpl
    * @Description: TODO(连接数据库，对数据增删改查)
    * @author 梁芳芳
    * @date 2018年12月5日
    *
 */
@Repository
public class LoginDaoImpl extends BaseDao<User, Integer> {
	
	/**
	 * 
	    * @Title: insertUser
	    * @Description: TODO(注册时插入数据库)
	    * @param @param user
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void insertUser(User user) throws Exception {
		this.save(user);
	}
	
	/**
	 * 
	    * @Title: findAllUser
	    * @Description: TODO(查找所有用户)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<User>    返回类型
	    * @throws
	 */
	public List<User> findAllUser() throws Exception{
		return this.findAll();
	}
		
	
}
