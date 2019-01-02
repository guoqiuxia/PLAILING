package com.es.plailing.showcommentanswer.service;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;

@Service
public interface CommentAnswerService {
	/**
	 * 
	    * @Title: listComment
	    * @Description: TODO(分页显示这个评论的回复)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param commentId
	    * @param @return    参数
	    * @return Page<Comment>    返回类型
	    * @throws
	 */
	public Page<CourseComment> listComment(int pageNum,int pageSize,int commentId);
	/**
	 * 
	    * @Title: getComment
	    * @Description: TODO(通过commentId找到Comment)
	    * @param @param commentId
	    * @param @return    参数
	    * @return Comment    返回类型
	    * @throws
	 */
	public CourseComment getComment(int commentId);
}
