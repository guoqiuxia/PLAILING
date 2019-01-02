package com.es.plailing.left.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.User;
import com.es.plailing.left.dao.LeftDaoImpl;

@Service
public class LeftServiceImpl implements LeftService {
	
	@Resource
	private LeftDaoImpl leftDaoImpl;

	@Override
	public User findLeft(String email) {
		try {
			return leftDaoImpl.findLeft(email);
		} catch (Exception e) {
			return null;
		}
	}

	
}
