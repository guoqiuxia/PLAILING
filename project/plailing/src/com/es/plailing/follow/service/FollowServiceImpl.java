package com.es.plailing.follow.service;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.follow.dao.FollowDaoImpl;

@Service
public class FollowServiceImpl implements FollowService{
	@Resource
	private FollowDaoImpl followDaoImpl;

	@Override
	public Page<User> listMyFollow(int userId,int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		try {
			return this.followDaoImpl.listMyFollow(userId, pageNum, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Page<User> listMyFollowMe(int userId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		try {
			return this.followDaoImpl.listMyFollowMe(userId, pageNum, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
