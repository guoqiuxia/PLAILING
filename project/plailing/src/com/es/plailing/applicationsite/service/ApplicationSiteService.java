package com.es.plailing.applicationsite.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.ApplicationSite;
import com.es.plailing.entity.Course;
@Service
public interface ApplicationSiteService {
	/**
	 * 
	    * @Title: insertApplicationSiteDaoImpl
	    * @Description: TODO(将用户申请场地的信息填到数据库中)
	    * @param @param applicationSite    参数
	    * @return void    返回类型
	    * @throws
	 */
	public int insertApplicationSiteDaoImpl(String useTime,String siteType,double userLang,Course course);
}
