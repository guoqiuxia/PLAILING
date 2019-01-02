package com.es.plailing.relatedemandnotification.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;
import com.es.plailing.relatedemandnotification.dao.RelateDemandDaoImpl;

@Service
public class RelateDemandServiceImpl implements RelateDemandService{

	@Resource
	private RelateDemandDaoImpl relateDemandDaoImpl;
	
	@Override
	public List<Demand> findDemand(int userId) {
		try {
			return relateDemandDaoImpl.findDemand(userId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Page<Demand> pageDemand(int pageNum, int pageSize, int userId) {
		
		try {
			return relateDemandDaoImpl.pageDemand(pageNum, pageSize, userId);
		} catch (Exception e) {
			return null;
		}
	}

}
