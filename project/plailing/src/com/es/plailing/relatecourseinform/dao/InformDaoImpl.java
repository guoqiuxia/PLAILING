package com.es.plailing.relatecourseinform.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Inform;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: InformDaoImpl
    * @Description: TODO(连接数据库获取inform表的数据)
    * @author 梁芳芳
    * @date 2018年12月17日
    *
 */
@Repository
public class InformDaoImpl extends BaseDao<Inform, Integer>{

	/**
	 * 
	    * @Title: findInform
	    * @Description: TODO(根据课程号获取通知)
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Inform>    返回类型
	    * @throws
	 */
	public List<Inform> findInform(int courseId) throws Exception {
		String hql="from Inform i where i.course.courseId=? and state=1";
		Object[] params= {courseId};
		return find(hql, params);
	}
}
