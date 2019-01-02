package com.es.plailing.upload1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.CourseType;
import com.es.plailing.util.BaseDao;
@Repository
public class Upload1CourseTypeDaoImpl extends BaseDao<CourseType, Integer> {
	@Override
	/**
	 * 
	    * @Title: findAll
	    * @Description: TODO(查找所有的课程类型)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<CourseType>    返回类型
	    * @throws
	 */
	public List<CourseType> findAll() throws Exception {
		System.out.println("ssss");
		System.out.println(super.findAll());
		return super.findAll();
	}
	/**
	 * 
	    * @Title: Find
	    * @Description: TODO(根据课程父类型id查找课程类型的typeId,typeName)
	    * @param @param objects
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Object[]>    返回类型
	    * @throws
	 */
	public List<Object[]> Find(Object[]objects) throws Exception {
		return super.findByProjection("select typeId,typeName from CourseType where courseType.typeId=?",objects);
	}
	/**
	 * 
	    * @Title: Get
	    * @Description: TODO(根据id查找课程类型)
	    * @param @param typeId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return CourseType    返回类型
	    * @throws
	 */
	public CourseType Get(Integer typeId) throws Exception{
		return super.get(typeId);
	}
}
