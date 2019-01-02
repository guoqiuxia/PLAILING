package com.es.plailing.check.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Demand;
import com.es.plailing.util.BaseDao;

/**
    * @ClassName: CheckDemandDaoImpl
    * @Description: TODO(check.jsp页面关于UserDemand的一些操作)
    * @author 郭秋霞
    * @date 2018年12月19日
    *
    */
@Repository
public class CheckDemandDaoImpl extends BaseDao<Demand,Integer>{
	
	/**
	 * 
	    * @Title: findDemand
	    * @Description: TODO(通过demandId找到UserDemand对象)
	    * @param @param demandId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return UserDemand    返回类型
	    * @throws
	 */
	public Demand findDemand(int demandId) throws Exception {
		String hql = "from Demand d where d.demandId=?";
		Object[] params = {demandId};
		return findOne(hql, params);
	}
}
