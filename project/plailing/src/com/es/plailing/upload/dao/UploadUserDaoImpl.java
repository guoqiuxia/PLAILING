package com.es.plailing.upload.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

@Repository
public class UploadUserDaoImpl extends BaseDao<User,Integer>{

	public int getUserIdByEmail(String email) throws Exception {
		String hql="from User u where u.email=?";
		Object[] params= {email};
		User u=findOne(hql, params);
		return u.getUserId();
	}
}
