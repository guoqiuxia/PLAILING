package com.es.plailing.collection.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.UserCollectionCourse;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: DeleteCollectionDaoImpl
    * @Description: TODO(连接数据库)
    * @author 梁芳芳
    * @date 2018年12月22日
    *
 */
@Repository
public class DeleteCollectionDaoImpl extends BaseDao<UserCollectionCourse, Integer>{

	/**
	 * 
	    * @Title: checkCourse
	    * @Description: TODO(根据用户ID和课程ID查询核对)
	    * @param @param userId
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public boolean checkCourse(int userId,int courseId) throws Exception {
		String hql="from UserCollectionCourse uc where uc.course.courseId=? and uc.user.userId=?";
		Object[] params= {courseId,userId};
		UserCollectionCourse ucc=this.findOne(hql, params);
		if(ucc != null && ucc.getState()==1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	    * @Title: deleteCourse
	    * @Description: TODO(根据用户ID和课程ID更改数据状态)
	    * @param @param userId
	    * @param @param courseId
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void deleteCourse(int userId,int courseId) throws Exception{
		String hql="from UserCollectionCourse uc where uc.course.courseId=? and uc.user.userId=?";
		Object[] params= {courseId,userId};
		UserCollectionCourse ucc=this.findOne(hql, params);
		ucc.setState(0);
		update(ucc);
	}
}
