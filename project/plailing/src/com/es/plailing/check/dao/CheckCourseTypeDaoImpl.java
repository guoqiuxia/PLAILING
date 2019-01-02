package com.es.plailing.check.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.CourseType;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: CheckDaoImpl
    * @Description: TODO(Auditing表的相关操作)
    * @author 郭秋霞
    * @date 2018年12月5日
    *
 */

@Repository
public class CheckCourseTypeDaoImpl extends BaseDao<CourseType, Integer> {
	    /**
	     * @throws Exception 
	    * @Title: courseTypeList
	    * @Description: TODO(找到所有的一级类型)
	    * @param @return    参数
	    * @return List<CourseType>    返回类型
	    * @throws
	    */
	    
	public List<CourseType> courseTypeList() throws Exception {
		// TODO Auto-generated method stub
		return findAll();
	}
	/**
	 * 
	    * @Title: Find
	    * @Description: TODO(通过typeId找到typeName)
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
	    * @Title: findTypeId
	    * @Description: TODO(通过二级类型名找到对应的TypeId)
	    * @param @param name
	    * @param @return
	    * @param @throws Exception    参数
	    * @return int    返回类型
	    * @throws
	 */
	public CourseType findTypeId(int typeId) throws Exception {
		String hql = "from CourseType ct where ct.typeId=?";
		Object[] params = {typeId};
		return findOne(hql, params);
	}
}
