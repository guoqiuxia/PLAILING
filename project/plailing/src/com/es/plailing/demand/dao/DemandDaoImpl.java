package com.es.plailing.demand.dao;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;
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
@Transactional(readOnly=false)
public class DemandDaoImpl extends BaseDao<Demand,Integer>{

	/**
	 * 
	    * @Title: getDemand
	    * @Description: TODO(查找有没有对应的需求)
	    * @param @param text
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Demand    返回类型
	    * @throws
	 */
	public Demand getDemand(String text) throws Exception {
		String hql="from Demand d where d.text=?";
		Object[] params= {text};
		return findOne(hql,params);
	}
	/**
	 * 
	    * @Title: addDeamand
	    * @Description: TODO(添加一个评论)
	    * @param @param text
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void addDeamand(String text,Demand demand) throws Exception {
		if(demand!=null) {
			int count=demand.getCount()+1;
			demand.setCount(count);
			int i=demand.getCourses().size()+1;
			demand.setProportion((double)i/count);
			update(demand);
		}else { 
			Demand demand1=new Demand();
			demand1.setCount(1);
			demand1.setProportion(1);
			demand1.setText(text);
			save(demand1);
		}
	}

	/**
	 * 
	    * @Title: listDemand
	    * @Description: TODO(先按照比例升序排序，按数量降序排列，查找所有需求)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Demand>    返回类型
	    * @throws
	 */
	public Page<Demand> listDemand(int pageNum,int pageSize) throws Exception{
		String hqlCount="select count(*) from Demand d order by d.proportion,d.count desc,d.demandId desc";
		String hqlList="from Demand d  order by d.proportion,d.count desc,d.demandId desc";
		Object[] params= {};
		return findPage(pageNum,pageSize, hqlCount, hqlList, params);
	}
	/**
	 * 
	    * @Title: listDemand
	    * @Description: TODO(找到里含有text的需求)
	    * @param @param text
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Object[]>    返回类型
	    * @throws
	 */
	public List<Object[]> listDemand(int pageNum,int pageSize,String text) throws Exception{
		String hql="select d.text from Demand d where d.text like ? order by d.proportion";
		Object[] params= {"%"+text+"%"};
		return findByProjection(pageNum, pageSize, hql, params);
	}

}
