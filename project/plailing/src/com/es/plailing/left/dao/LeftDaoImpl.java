package com.es.plailing.left.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

@Repository
public class LeftDaoImpl extends BaseDao<User, Integer> {
	
	/**
	 * 
	    * @Title: findOne
	    * @Description: TODO(按条件查询用户)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return User    返回类型
	    * @throws
	 */

	public User findLeft(String email) throws Exception {
		String hql="from User u where u.email=?";
		Object[] params= {email};
		return this.findOne(hql, params);
	}

}
