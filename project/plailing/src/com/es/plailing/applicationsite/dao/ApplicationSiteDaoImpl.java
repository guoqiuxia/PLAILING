package com.es.plailing.applicationsite.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.ApplicationSite;
import com.es.plailing.entity.Course;
import com.es.plailing.util.BaseDao;

@Repository
public class ApplicationSiteDaoImpl extends BaseDao<ApplicationSite,Integer>{
	/**
	 * 
	    * @Title: insertApplicationSiteDaoImpl
	    * @Description: TODO(将申请场地的信息添加到数据库中)
	    * @param @param applicationSite
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void insertApplicationSiteDaoImpl(Date now,String siteType,double userLang,Course course) throws Exception {
   	 	
   	 	//得到application对象
		ApplicationSite applicationSite=new ApplicationSite();
   	 	applicationSite.setUseTime(now);
   	    applicationSite.setSiteType(siteType);
   	    applicationSite.setUseLang(userLang);
		applicationSite.setApplicationTime(new Date());
		applicationSite.setCourse(course);
		
		course.getApplicationSites().add(applicationSite);
		
		save(applicationSite);
	}

}
