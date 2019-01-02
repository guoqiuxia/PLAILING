package com.es.plailing.upload1.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.util.BaseDao;
@Repository
public class Upload1CourseCatalogDaoImpl extends BaseDao<CourseCatalog, Integer> {
	@Override
	/**
	 * 
	    * @Title: findOne
	    * @Description: TODO(课程目录存入数据库)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void save(CourseCatalog entity) throws Exception {
		
		super.save(entity);
	}
	/**
	 * 
	    * @Title: findOne
	    * @Description: TODO(根据课程父目录id查询课程目录)
	    * @param @param objects
	    * @param @return
	    * @param @throws Exception    参数
	    * @return CourseCatalog    返回类型
	    * @throws
	 */
	public CourseCatalog findOne(Object[]objects) throws Exception {
		System.out.println("dao:"+super.findOne(" from CourseCatalog t where t.catalogId=?",objects));
		return super.findOne(" from CourseCatalog t where t.catalogId=?",objects);
	}
	/**
	 * 
	    * @Title: findCatalog
	    * @Description: TODO(根据目录catalogName查询目录)
	    * @param @param catalogName
	    * @param @return
	    * @param @throws Exception    参数
	    * @return CourseCatalog    返回类型
	    * @throws
	 */
	public CourseCatalog findCatalog(String catalogName,int courseId) throws Exception {
		Object[] name= {catalogName,courseId};
		return super.findOne(" from CourseCatalog t where t.catalogName=? and t.course.courseId=?", name);
	}
}
