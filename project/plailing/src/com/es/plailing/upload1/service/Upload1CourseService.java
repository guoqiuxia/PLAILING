package com.es.plailing.upload1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.CourseType;
@Service
/**
 * 
    * @ClassName: Upload1CourseService
    * @Description: TODO(与上传课程有关得到方法)
    * @author 辛佳锟
    * @date 2018年12月03日
    *
 */
public interface Upload1CourseService {
	/**
	 * 
	    * @Title: Save
	    * @Description: TODO(课程存入数据库)
	    * @param @param entity    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void Save(Course entity);
	@Transactional(readOnly=false)
	/**
	 * 
	    * @Title: SaveCatalog
	    * @Description: TODO(课程目录存入数据库)
	    * @param @param courseCatalog    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void SaveCatalog(CourseCatalog courseCatalog);
	/**
	 * 
	    * @Title: FindAll
	    * @Description: TODO(查找所有课程类型)
	    * @param @return    参数
	    * @return List<CourseType>    返回类型
	    * @throws
	 */
	public List<CourseType>FindAll();
	/**
	 * 
	    * @Title: Find
	    * @Description: TODO(根据课程父类型id查找课程类型的typeId,typeName)
	    * @param @param objects
	    * @param @return    参数
	    * @return List<Object[]>    返回类型
	    * @throws
	 */
	public List<Object[]> Find(Object[]objects);
	/**
	 * 
	    * @Title: Get
	    * @Description: TODO(根据id查找课程类型)
	    * @param @param typeId
	    * @param @return    参数
	    * @return CourseType    返回类型
	    * @throws
	 */
	public CourseType Get(Integer typeId);
	/**
	 * 
	    * @Title: FindOne
	    * @Description: TODO(根据课程父目录id查询课程目录)
	    * @param @param objects
	    * @param @return    参数
	    * @return CourseCatalog    返回类型
	    * @throws
	 */
	public CourseCatalog FindOne(Object[]objects);
	/**
	 * 
	    * @Title: GetCourse
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param courseId
	    * @param @return    参数
	    * @return Course    返回类型
	    * @throws
	 */
	public Course GetCourse(Integer courseId);
	/**
	 * 
	    * @Title: findCatalog
	    * @Description: TODO(根据目录catalogName查询目录)
	    * @param @param catalogName
	    * @param @return    参数
	    * @return Course    返回类型
	    * @throws
	 */
	public CourseCatalog findCatalog(String catalogName,int courseId);

}
