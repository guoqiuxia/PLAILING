package com.es.plailing.coursedetail.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserBalance;
import com.es.plailing.util.BaseDao;

@Repository
public class UserBalanceDaoImpl extends BaseDao<UserBalance,Integer>{
	
	public void insertUserBalance(User u,UserBalance ub,Course c) throws Exception {
		ub.setBalanceState(1);
		ub.setBalanceTime(new Date());
		ub.setMoney(c.getPrice());
		u.getUserBalances().add(ub);
		c.getUserBalances().add(ub);
		ub.setUser(u);	
		ub.setCourse(c);
		save(ub);		
	}
}
