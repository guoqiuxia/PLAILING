package com.es.plailing.follow.dao;


import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Follow;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

@Repository
public class FollowDaoImpl extends BaseDao<User,Integer>{
	public Page<User> listMyFollow(int userId,int pageNum,int pageSize) throws Exception{
		String hqlCount = "select count(*) from User u where u.userId in (select f.teacherUser from Follow f where f.studentUser.userId=? and f.state=1)";
		String hqlList = "from User u where u.userId in (select f.teacherUser from Follow f where f.studentUser.userId=? and f.state=1)";
		Object[] params = {userId};
		return this.findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}
	public Page<User> listMyFollowMe(int userId,int pageNum,int pageSize) throws Exception{
		String hqlCount = "select count(*) from User u where u.userId in (select f.studentUser from Follow f where f.teacherUser.userId=? and f.state=1)";
		String hqlList = "from User u where u.userId in (select f.studentUser from Follow f where f.teacherUser.userId=? and f.state=1)";
		Object[] params = {userId};
		return this.findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}
}
