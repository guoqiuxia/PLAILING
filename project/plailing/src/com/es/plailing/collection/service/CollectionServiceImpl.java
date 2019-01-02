package com.es.plailing.collection.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.collection.dao.CollectionDaoImpl;
import com.es.plailing.collection.dao.DeleteCollectionDaoImpl;
import com.es.plailing.collection.dao.PageDaoImpl;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

/**
 * 
    * @ClassName: CollectionServiceImpl
    * @Description: TODO(继承CollectionService方法)
    * @author 梁芳芳
    * @date 2018年12月3日
    *
 */

@Service
@Transactional(readOnly=false)
public class CollectionServiceImpl implements CollectionService{
	
	@Resource
	private CollectionDaoImpl collectionDaoImpl;
	
	@Resource
	private PageDaoImpl pageDaoImpl;
	
	@Resource
	private DeleteCollectionDaoImpl deleteCollectionDaoImpl;

	@Override
	public User findOne(String email) {
		try {
			return collectionDaoImpl.findOne(email);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Page<Course> findPage(int pageNum, int pageSize, String email) {
		try {
			return pageDaoImpl.findPage(pageNum, pageSize, email);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Course> findCourse(String email) {
		
		try {
			return pageDaoImpl.findCourse(email);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean checkCourse(int userId,int courseId) {
		
		try {
			deleteCollectionDaoImpl.checkCourse(userId, courseId);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public void deleteCourse(int userId, int courseId) {
		try {
			deleteCollectionDaoImpl.deleteCourse(userId, courseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

	
}
