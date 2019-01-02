
    /**  
    * @Title: CheckDaoImpl.java
    * @Package com.es.plailing.check.dao
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 郭秋霞
    * @date 2018年12月19日
    * @version V1.0  
    */
    
package com.es.plailing.check.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Auditing;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

/**
    * @ClassName: CheckDaoImpl
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 郭秋霞
    * @date 2018年12月19日
    *
    */
@Repository
public class CheckDaoImpl extends BaseDao<Auditing, Integer>{
	/**
	 * @throws Exception 
	 * 
	    * @Title: insertAuditing
	    * @Description: TODO(向Auditing表中插入数据)
	    * @param @param personalInfo
	    * @param @param identityPic
	    * @param @param teachVideo
	    * @param @param certificate
	    * @param @param state    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void insertAuditing(User user,String personalInfo,String identityPic,
			String teachVideo,String certificate,int state) throws Exception {
		Auditing auditing = new Auditing();
		auditing.setUser(user);
		auditing.setPersonalInfo(personalInfo);
		auditing.setIdentityPic(identityPic);
		auditing.setTeachVideo(teachVideo);
		auditing.setCertificate(certificate);
		auditing.setCheckState(state);
		auditing.setAuditingId(0);
		save(auditing);
	}
}
