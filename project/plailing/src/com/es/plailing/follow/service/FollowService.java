package com.es.plailing.follow.service;



import org.springframework.stereotype.Service;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

@Service
public interface FollowService {
	public Page<User> listMyFollow(int userId,int pageNum,int pageSize);
	public Page<User> listMyFollowMe(int userId,int pageNum,int pageSize);
}
