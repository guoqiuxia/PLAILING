package com.es.plailing.login.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.entity.User;
import com.es.plailing.login.dao.LoginDaoImpl;

@Service
@Transactional(readOnly=false)
public class RegisterServiceImpl implements RegisterService {
	@Resource
	private LoginDaoImpl loginDaoImpl;

	@Override
	public void insertUser(User user) {
		try {
			this.loginDaoImpl.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> findAllUser() {
		try {
			return this.loginDaoImpl.findAllUser();
		} catch (Exception e) {
			return null;
		}
	}
}
