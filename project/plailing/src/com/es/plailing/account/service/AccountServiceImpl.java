package com.es.plailing.account.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.account.dao.AccountBalanceDaoImpl;
import com.es.plailing.account.dao.AccountMoneyDaoImpl;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.UserBalance;

/**
 * 
    * @ClassName: AccountBalanceServiceImpl
    * @Description: TODO(account逻辑层，整合消费充值记录和课程收益记录)
    * @author zhangsijia
    * @date 2018年12月10日
    *
 */
@Service
@Transactional(readOnly=true)
public class AccountServiceImpl implements AccountService{

	@Resource
	private AccountBalanceDaoImpl accountBalanceDaoImpl = new AccountBalanceDaoImpl();
	@Resource
	private AccountMoneyDaoImpl accountMoneyDaoImpl = new AccountMoneyDaoImpl();
	
	/**
	 * 
	    * @Title: findBalance
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<UserBalance>    返回类型
	    * @throws
	 */
	public Page<UserBalance> findBalance(int pageNum, int pageSize,String email) throws Exception {
		return accountBalanceDaoImpl.findBalanceByPage(pageNum, pageSize, email); 
	}
	
	/**
	 * 
	    * @Title: findNowTotleMoney
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return double    返回类型
	    * @throws
	 */
	public double findNowTotleBalance (String email) throws Exception {
		return accountBalanceDaoImpl.findNowTotleMoney(email);
	}
	
	/**
	 * 
	    * @Title: findMoney
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<Object[]>    返回类型
	    * @throws
	 */
	public Page<Object[]> findMoney(int pageNum, int pageSize,String email) throws Exception {
		return accountMoneyDaoImpl.userEarningByPage(pageNum, pageSize, email); 
	}
	
	/**
	 * 
	    * @Title: findUserNowTotleEaring
	    * @Description: TODO(调用Dao查询用户当前开课总收益)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return double    返回类型
	    * @throws
	 */
	public double findUserNowTotleEaring(String email) throws Exception {
		return accountMoneyDaoImpl.userNowTotleEaring(email);
	}
}
