package com.es.plailing.demand.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserDemand;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: DemandDaoImpl
    * @Description: TODO(demand页面底层查询)
    * @author 刘珊珊
    * @date 2018年12月21日
    *
 */

@Repository
public class UserDemandDaoImpl extends BaseDao<UserDemand,Integer>{
	/**
	 * 
	    * @Title: addUserDemand
	    * @Description: TODO(将数据插入到userDemand中)
	    * @param @param u
	    * @param @param text
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void addUserDemand(User u,String text,Demand demand) throws Exception {
		UserDemand userDemand=new UserDemand();
		userDemand.setDemandTime(new Date());
		userDemand.setUser(u);
		userDemand.setDemand(demand);
		u.getDemands().add(userDemand);
		demand.getUsers().add(userDemand);
		save(userDemand);
	}
}
