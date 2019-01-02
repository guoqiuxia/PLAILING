package com.es.plailing.account.dao;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Page;
import com.es.plailing.entity.UserBalance;
import com.es.plailing.util.BaseDao;

/*
 * 
    * @ClassName: AccounBalancetDaoImpl
    * @Description: TODO(查询此用户充值消费记录,并分页)
    * @author zhangsijia
    * @date 2018年12月4日
    *
 */
@Repository
public class AccountBalanceDaoImpl extends BaseDao<UserBalance,Integer>{

	/**
	 * 
	    * @Title: findBalanceByPage
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<UserBalance>    返回类型
	    * @throws
	 */
	public Page<UserBalance> findBalanceByPage(int pageNum, int pageSize,String email) throws Exception {
		String hqlCount = "select count(*) from UserBalance UB where UB.user.email=?";
		String hql = "from UserBalance UB where UB.user.email=? order by balanceTime desc";//按时间倒叙查询
		Object [] params = {email};
		Page<UserBalance> balancePageList = super.findPage(pageNum, pageSize, hqlCount,hql, params);
		return balancePageList;
	}
	
	/**
	 * 
	    * @Title: findNowTotleMoney
	    * @Description: TODO(查询此用户充值消费表中的最近一条记录，得到当前余额)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return double    返回类型
	    * @throws
	 */
	public double findNowTotleMoney(String email) throws Exception {
		String hql = "select UB.totleMoney from UserBalance UB where UB.user.email=? order by UB.balanceTime desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, email);
		query.setMaxResults(1);
		double n = 0;
		if(query.uniqueResult() == null) {}else {
			n = (double)query.uniqueResult();
		}
		System.out.println("当前余额为：" + n);
		return n;
	}
	
}
