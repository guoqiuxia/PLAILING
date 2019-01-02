package com.es.plailing.relatecomment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.comment.dao.StudyCommentDaoImpl;
import com.es.plailing.coursedetail.dao.UsersDaoImpl;
import com.es.plailing.entity.Comment;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.relatecomment.dao.RelateCommentDaoImpl;
@Service
@Transactional(readOnly=false)
public class RelateCommentServiceImpl implements RelateCommentService {
	@Resource
	private RelateCommentDaoImpl relateCommentDaoImpl;
	@Resource
	private UsersDaoImpl usersDaoImpl;
	@Override
	public Page<Comment> Find(int pageNum, int pageSize, String email) {
		Page<Comment> comments;
		 try {
			 comments=relateCommentDaoImpl.pageComment(pageNum, pageSize, email);
			return comments;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public void Save(Comment entity) {
		try {
			relateCommentDaoImpl.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public Comment Get(Integer id) {
		try {
			return relateCommentDaoImpl.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Comment> FindSon(int top){
		try {
			return relateCommentDaoImpl.FindSon(top);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Comment FindOne(String text){
		try {
			return relateCommentDaoImpl.findOne(text);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public User FindUser(String email){
		try {
			return usersDaoImpl.getUserByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
