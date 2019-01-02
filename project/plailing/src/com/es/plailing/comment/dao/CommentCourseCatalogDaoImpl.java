
    /**  
    * @Title: CourseCatalog.java
    * @Package com.es.plailing.comment.dao
    * @Description: TODO(用一句话描述该文件做什么)
    * @author Administrator
    * @date 2018年12月24日
    * @version V1.0  
    */
    
package com.es.plailing.comment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.util.BaseDao;

/**
    * @ClassName: CourseCatalog
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 刘珊珊
    * @date 2018年12月24日
    *
    */

@Repository
public class CommentCourseCatalogDaoImpl extends BaseDao<CourseCatalog,Integer>{
	/**
	 * @throws Exception 
	 * 
	    * @Title: listCourseCatalog
	    * @Description: TODO(按照页数显示目录)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<CourseCatalog>    返回类型
	    * @throws
	 */
	public List<CourseCatalog> listCourseCatalog(int pageNum,int pageSize,int courseId) throws Exception{
		String hql="from CourseCatalog cc where cc.courseCatalog.catalogId is null and cc.course.courseId=?";
		Object[] params= {courseId};
		return find(pageNum, pageSize, hql, params);
	}
	/**
	 * 
	    * @Title: listCourseCatalogByPid
	    * @Description: TODO(通过父目录找到子目录)
	    * @param @param pid
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<CourseCatalog>    返回类型
	    * @throws
	 */
	public List<CourseCatalog> listCourseCatalogByPid(int pid) throws Exception{
		String hql="from CourseCatalog cc where cc.courseCatalog.catalogId=? order by cc.catalogId desc";
		Object[] params= {pid};
		return find(hql,params);
 	}

}
