package com.es.plailing.demand.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
/**
 * 
    * @ClassName: DemandService
    * @Description: TODO(接口)
    * @author 刘珊珊
    * @date 2018年12月21日
    *
 */
@Service
public interface DemandService {

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
	public Demand getDemand(String text); 
	/**
	 * 
	    * @Title: addDeamand
	    * @Description: TODO(添加一个需求)
	    * @param @param text
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public boolean addDeamand(String text,Demand demand);
	/**
	 * 
	    * @Title: listDemand
	    * @Description: TODO(状态为零，按数量降序排列，查找所有需求)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Demand>    返回类型
	    * @throws
	 */
	public Page<Demand> listDemand(int pageNum,int pageSize);
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
	public boolean addUserDemand(User u,String text,Demand demand);
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
	public List<Object[]> listDemand(int pageNum,int pageSize,String text);
}
