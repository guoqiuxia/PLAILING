package com.es.plailing.checkinform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.es.plailing.checkinform.dao.CheckInformDaoImpl;
import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;

@Service
public class CheckInformServiceImpl implements CheckInformService{

	@Resource
	private CheckInformDaoImpl checkInformDaoImpl;

	@Override
	public List<Inform> findInform(int userId) {
		try {
			return checkInformDaoImpl.findInform(userId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Page<Inform> pageInform(int pageNum, int pageSize, int userId) {
		try {
			return checkInformDaoImpl.pageInform(pageNum, pageSize, userId);
		} catch (Exception e) {
			return null;
		}
	}
}
