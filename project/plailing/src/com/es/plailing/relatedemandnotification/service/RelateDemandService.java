package com.es.plailing.relatedemandnotification.service;

import java.util.List;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;

/**
 * 
    * @ClassName: DemandService
    * @Description: TODO(接口)
    * @author 梁芳芳
    * @date 2018年12月18日
    *
 */
public interface RelateDemandService {
	
	/**
	 * 
	    * @Title: findDemand
	    * @Description: TODO(根据id查询需求)
	    * @param @param userId
	    * @param @return    参数
	    * @return List<Demand>    返回类型
	    * @throws
	 */
	public List<Demand> findDemand(int userId);
	
	/**
	 * 
	    * @Title: pageDemand
	    * @Description: TODO(根据Id分页查询需求)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return    参数
	    * @return Page<Demand>    返回类型
	    * @throws
	 */
	public Page<Demand> pageDemand(int pageNum,int pageSize,int userId);
	
}
