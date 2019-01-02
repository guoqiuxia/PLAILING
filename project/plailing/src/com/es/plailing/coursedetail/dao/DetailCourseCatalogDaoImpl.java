package com.es.plailing.coursedetail.dao;


import org.springframework.stereotype.Repository;

import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;

@Repository
public class DetailCourseCatalogDaoImpl extends BaseDao<CourseCatalog,Integer>{

	/**
	 * 
	    * @Title: listCourseCatalog
	    * @Description: TODO(得到该课程的一级目录的对象)
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<CourseCatalog>    返回类型
	    * @throws
	 */
	public Page<CourseCatalog> listCourseCatalog(int pageNum,int pageSize,int courseId) throws Exception{
		String hqlList="from CourseCatalog cc where cc.courseCatalog.catalogId is null and cc.course.courseId=?";
		String hqlCount="select count(*) from CourseCatalog cc where cc.courseCatalog.catalogId is null and cc.course.courseId=?";
		Object[] params= {courseId};
		return findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}

	

}
