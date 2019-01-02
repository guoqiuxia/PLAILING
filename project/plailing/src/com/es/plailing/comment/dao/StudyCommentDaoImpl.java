package com.es.plailing.comment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;
@Repository
@Transactional
public class StudyCommentDaoImpl extends BaseDao<Comment, Integer> {
		
	/**
	 * 
	    * @Title: pageComment
	    * @Description: TODO(分页查询评论)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param catalogId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<Comment>    返回类型
	    * @throws
	 */
	public Page<Comment> pageComment(int pageNum,int pageSize,int catalogId) throws Exception{
		String hqlList="from Comment cc where cc.comment.commentId is null and  cc.courseCatalog.catalogId=? order by cc.commentId desc";
		String hqlCount="select count(*) from  Comment cc where cc.comment.commentId is null and cc.courseCatalog.catalogId=? order by cc.commentId desc";
		Object[] params= {catalogId};
		return findPage(pageNum, pageSize, hqlCount, hqlList, params);
		
	}
	@Override
	/**
	 * 
	    * @Title: get
	    * @Description: TODO(插入评论)
	    * @param @param entity
	    * @param @return
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void save(Comment entity) throws Exception {
		
		super.save(entity);
	}
	/**
	 * 
	    * @Title: get
	    * @Description: TODO(根据id查询单个评论)
	    * @param @param id
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Comment    返回类型
	    * @throws
	 */
	public Comment get(Integer id) throws Exception {
		return super.get(id);
	}
	/**
	 * 
	    * @Title: FindSon
	    * @Description: TODO(根据评论内容查询评论id，内容)
	    * @param @param top
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Object[]>    返回类型
	    * @throws
	 */
	public List<Comment> FindSon(int top) throws Exception {
		Object[] params= {top};
		return super.find("from Comment where top=?",params);
	}
	/**
	 * 
	    * @Title: findOne
	    * @Description: TODO()
	    * @param @param text
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Comment    返回类型
	    * @throws
	 */
	public Comment findOne(String text) throws Exception {
		Object[] params= {text};
		return super.findOne(" from Comment t where t.text=?",params);
	}
	/**
	 * 
	    * @Title: listComment
	    * @Description: TODO(按照页数查找评论)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param catalogId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Comment>    返回类型
	    * @throws
	 */
	public List<Comment> listComment(int pageNum,int pageSize,int catalogId) throws Exception{
		String hql="from Comment cc where cc.comment.commentId is null and cc.courseCatalog.catalogId=? order by cc.commentId desc";
		Object[] params= {catalogId};
		return find(pageNum,pageSize,hql,params);
	}

}
