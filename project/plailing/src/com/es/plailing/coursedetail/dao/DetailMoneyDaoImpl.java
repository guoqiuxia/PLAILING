package com.es.plailing.coursedetail.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Money;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

@Repository
public class DetailMoneyDaoImpl extends BaseDao<Money,Integer>{
	

	public void insertMoney(Course c,User u) throws Exception {
		Money money=new Money();
		money.setMoney(c.getPrice());
		money.setMoneyTime(new Date());
		money.setCourse(c);
		money.setUser(u);
		c.getMoneys().add(money);
		u.getMoneys().add(money);
		save(money);
	}
}
