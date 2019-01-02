package com.es.plailing.showcommentanswer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;
import com.es.plailing.showcommentanswer.dao.AnswerCommentDaoImpl;

@Service
public class CommentAnswerServiceImpl implements CommentAnswerService{

	@Resource
	private AnswerCommentDaoImpl answerCommentDaoImpl;
	@Override
	public Page<CourseComment> listComment(int pageNum, int pageSize, int commentId) {
		try {
			return answerCommentDaoImpl.listComment(pageNum, pageSize, commentId);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public CourseComment getComment(int commentId) {
		try {
			return answerCommentDaoImpl.getComment(commentId);
		} catch (Exception e) {
			return null;
		}
	}
	
}
