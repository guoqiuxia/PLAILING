package com.es.plailing.collection.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: CollectionDaoImpl
    * @Description: TODO(实现和数据库连接)
    * @author 梁芳芳
    * @date 2018年12月3日
    *
 */

@Repository

public class CollectionDaoImpl extends BaseDao<User, Integer>{
	
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

	public User findOne(String email) throws Exception {
		String hql="from User u where u.email=?";
		Object[] params= {email};
		return this.findOne(hql, params);
	}
}
