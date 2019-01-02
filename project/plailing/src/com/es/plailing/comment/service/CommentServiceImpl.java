package com.es.plailing.comment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.comment.dao.CommentCourseCatalogDaoImpl;
import com.es.plailing.comment.dao.StudyCommentDaoImpl;
import com.es.plailing.comment.dao.VideoDetailDaoImpl;
import com.es.plailing.coursedetail.dao.UsersDaoImpl;
import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

@Service
@Transactional(readOnly=false)
public class CommentServiceImpl implements CommentService {
	@Resource
	private StudyCommentDaoImpl commentDaoImpl;
	@Resource
	private UsersDaoImpl usersDaoImpl;
	@Resource
	private CommentCourseCatalogDaoImpl courseCatalogDaoImpl;
/*	@Resource
	private UserDaoImpl userDaoImpl;*/
	@Resource
	private VideoDetailDaoImpl videoDetailDaoImpl;
	
	public Page<Comment> Find(int pageNum, int pageSize, int catalogId) {
		Page<Comment> comments;
		 try {
			 comments=commentDaoImpl.pageComment(pageNum, pageSize, catalogId);
			return comments;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void Save(Comment entity) {
		try {
			commentDaoImpl.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Comment Get(Integer id) {
		try {
			return commentDaoImpl.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Comment> FindSon(int top){
		try {
			return commentDaoImpl.FindSon(top);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Comment FindOne(String text){
		try {
			return commentDaoImpl.findOne(text);
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

	@Override
	public CourseCatalog getSingleCourse(int catalogId) {
		// TODO Auto-generated method stub
		try {
			return this.videoDetailDaoImpl.getSingleCourse(catalogId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User getTeacher(int catalogId) {
		// TODO Auto-generated method stub
		try {
			return this.usersDaoImpl.getTeacher(catalogId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	    
	@Override
	public List<CourseCatalog> listCourseCatalog(int pageNum, int pageSize, int courseId) {
		try {
			return courseCatalogDaoImpl.listCourseCatalog(pageNum, pageSize, courseId);
		} catch (Exception e) {
			return null;
		}
	}
	    
	@Override
	public List<Comment> listComment(int pageNum, int pageSize, int catalogId) {
		try {
			return commentDaoImpl.listComment(pageNum, pageSize, catalogId);
		} catch (Exception e) {
			return null;
		}
	}
	    
	@Override
	public List<CourseCatalog> listCourseCatalogByPid(int pid) {
		try {
			return courseCatalogDaoImpl.listCourseCatalogByPid(pid);
		} catch (Exception e) {
			return null;
		}
	}
}
