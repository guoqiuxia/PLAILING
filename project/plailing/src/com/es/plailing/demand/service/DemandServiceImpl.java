package com.es.plailing.demand.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.demand.dao.DemandDaoImpl;
import com.es.plailing.demand.dao.UserDemandDaoImpl;
import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
/**
 * 
    * @ClassName: DemandServiceImpl
    * @Description: TODO(controller所用的一些方法)
    * @author 刘珊珊
    * @date 2018年12月21日
    *
 */
@Service
@Transactional(readOnly=false)
public class DemandServiceImpl implements DemandService{
	@Resource
	private DemandDaoImpl demandDaoImpl;
	@Resource
	private UserDemandDaoImpl userDemandDaoImpl;
	
	@Override
	public Demand getDemand(String text)  {
		try {
			return demandDaoImpl.getDemand(text);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean addDeamand(String text,Demand demand) {
		try {
			demandDaoImpl.addDeamand(text,demand);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	
	@Override
	public Page<Demand> listDemand(int pageNum, int pageSize) {
		try {
			return demandDaoImpl.listDemand(pageNum, pageSize);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public boolean addUserDemand(User u, String text,Demand demand) {
		try {
			userDemandDaoImpl.addUserDemand(u, text,demand);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Object[]> listDemand(int pageNum,int pageSize,String text)  {
		try {
			return demandDaoImpl.listDemand(pageNum,pageSize,text);
		} catch (Exception e) {
			return null;
		}
	}






}
