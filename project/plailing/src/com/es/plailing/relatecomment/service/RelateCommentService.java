package com.es.plailing.relatecomment.service;

import java.util.List;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

public interface RelateCommentService {
	/**
	 * 
	    * @Title: Find
	    * @Description: TODO(根据用户email分页查询评论)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param catalogId
	    * @param @return    参数
	    * @return Page<Comment>    返回类型
	    * @throws
	 */
	public Page<Comment> Find(int pageNum, int pageSize, String email);
	/**
	 * 
	    * @Title: Save
	    * @Description: TODO(数据库插入评论)
	    * @param @param entity    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void Save(Comment entity);
	/**
	 * 
	    * @Title: Get
	    * @Description: TODO(根据评论id查找评论)
	    * @param @param id
	    * @param @return    参数
	    * @return Comment    返回类型
	    * @throws
	 */
	public Comment Get(Integer id);
	/**
	 * 
	    * @Title: FindSon
	    * @Description: TODO(根据父评论查找子评论)
	    * @param @param top
	    * @param @return    参数
	    * @return List<Comment>    返回类型
	    * @throws
	 */
	public List<Comment> FindSon(int top);
	/**
	 * 
	    * @Title: FindOne
	    * @Description: TODO(根据评论内容查找评论)
	    * @param @param text
	    * @param @return    参数
	    * @return Comment    返回类型
	    * @throws
	 */
	public Comment FindOne(String text);
	/**
	 * 
	    * @Title: FindUser
	    * @Description: TODO(根据用户email查找用户)
	    * @param @param email
	    * @param @return    参数
	    * @return User    返回类型
	    * @throws
	 */
	public User FindUser(String email);
}
