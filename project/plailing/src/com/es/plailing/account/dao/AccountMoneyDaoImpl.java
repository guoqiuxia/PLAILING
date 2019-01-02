package com.es.plailing.account.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Money;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;

/*
 * 
    * @ClassName: AccountMoneyDaoImpl
    * @Description: TODO(查询此用户  开设的  课程-对应收益总和，并分页)
    * @author zhangsijia
    * @date 2018年12月8日
    *
 */
@Repository
public class AccountMoneyDaoImpl extends BaseDao<Object [], Integer> {
	
	/**
	 * 
	    * @Title: userEarningByPage
	    * @Description: TODO(分页查询此用户开设课程和对应收益总和)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Object[]>    返回类型 object数组中只有      课程/收益总和   两列
	    * @throws
	 */
	public Page<Object[]> userEarningByPage(int pageNum, int pageSize,String email) throws Exception {
		String forCount = "select M.course.name from Money M where M.user.email=? group by M.course.name";
		Object [] params = {email};
		List<Object[]> count = super.find(forCount, params);
		//查询此用户  开设的  课程-对应收益总和
		String hql = "select M.course.name,sum(M.money) from Money M where M.user.email=? group by M.course.name";		
		List<Object[]> rows = findByProjection(pageNum, pageSize, hql, params);
		return new Page<Object[]>(pageNum, pageSize,count.size(), rows);
	}
	
	/**
	 * 
	    * @Title: userNowTotleEaring
	    * @Description: TODO(查询此用户开设所有课程的总收益)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return double    返回类型
	    * @throws
	 */
	public double userNowTotleEaring(String email) throws Exception {
		String hql = "select sum(M.money) from Money M where M.user.email=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, email);
		double n = 0;
		if(query.uniqueResult() == null) {}else {
			n = (double) query.uniqueResult();
		}
		
		System.out.println("当前用户开课总收益：" + n);
		return n; 
	}
}
