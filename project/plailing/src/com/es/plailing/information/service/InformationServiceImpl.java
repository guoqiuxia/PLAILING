package com.es.plailing.information.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.information.dao.InformationDaoImpl;
import com.es.plailing.information.dao.InformationDaoImpl1;
import com.es.plailing.information.dao.InformationDaoImpl2;
@Service
@Transactional(readOnly=false)
/**
 * 
    * @ClassName: InformationServiceImpl
    * @Description: TODO(information.jsp页面service实现类)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
public class InformationServiceImpl implements InformationService{
	@Resource
	private InformationDaoImpl informationDaoImpl;
	@Resource
	private InformationDaoImpl1 informationDaoImpl1;
	@Resource
	private InformationDaoImpl2 informationDaoImpl2;
	@Override
	public User getTheUser(int userId) {
		// TODO Auto-generated method stub
		try {
			return this.informationDaoImpl1.getUser(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Page<Course> listPersonCourses(int pageNum, int pageSize, User user) {
		// TODO Auto-generated method stub
		try {
			return this.informationDaoImpl.listPersonCourse(pageNum, pageSize, user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean checkFollow(User user1,User user2) {
		// TODO Auto-generated method stub
		try {
			return this.informationDaoImpl2.checkFollow(user1, user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public void addFollow(User user1, User user2) {
		// TODO Auto-generated method stub
		try {
			this.informationDaoImpl2.addFollow(user1, user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteFollow(User user1, User user2) {
		// TODO Auto-generated method stub
		try {
			this.informationDaoImpl2.deleteFollow(user1, user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public User getTheUserByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			return this.informationDaoImpl1.getUserByEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}



}
