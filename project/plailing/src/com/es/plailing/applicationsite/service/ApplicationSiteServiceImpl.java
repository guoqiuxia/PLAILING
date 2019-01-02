package com.es.plailing.applicationsite.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.applicationsite.dao.ApplicationSiteDaoImpl;
import com.es.plailing.entity.ApplicationSite;
import com.es.plailing.entity.Course;

@Service
@Transactional(readOnly=false)
public class ApplicationSiteServiceImpl implements ApplicationSiteService{

	@Resource
	private ApplicationSiteDaoImpl applicationSiteDaoImpl;
	@Override
	public int insertApplicationSiteDaoImpl(String useTime,String siteType,double userLang,Course course) {
		//将得到的日期从String类型转换为date类型
		Date now=new Date();
		now.setYear(Integer.parseInt(useTime.substring(0,4))-1900);
		now.setMonth(Integer.parseInt(useTime.substring(5,7))-1);
		now.setDate(Integer.parseInt(useTime.substring(8,10)));
		now.setHours(Integer.parseInt(useTime.substring(11,13)));
		now.setMinutes(Integer.parseInt(useTime.substring(14,16)));
		
		Date now1=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String nowtime=sdf.format(now);
		String nowtime1=sdf.format(now1);
		
		//比较当前的时间和申请时间
		if(nowtime.compareTo(nowtime1)<0) {
			return 0;
		}else {
			//查看申请时间比当前时间多几天
			int days = (int) ((now.getTime() - now1.getTime()) / (1000*3600*24));
			if(days>=2) {
				if(userLang>0 && userLang<=4) {
					try {
						applicationSiteDaoImpl.insertApplicationSiteDaoImpl(now,siteType,userLang,course);
						return 1;
					} catch (Exception e) {
						return 4;
					}
				}else {
					return 3;
				}
			}else {
				if(userLang>0 && userLang<4) {
					try {
						System.out.println("222");
						applicationSiteDaoImpl.insertApplicationSiteDaoImpl(now,siteType,userLang,course);
						return 2;
					} catch (Exception e) {
						return 4;
					}
				}else {
					return 3;
				}
			}
			
		}
		
	}

}
