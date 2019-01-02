package com.es.plailing.coursedetail.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.coursedetail.dao.DetailCourseCatalogDaoImpl;
import com.es.plailing.coursedetail.dao.DetailMoneyDaoImpl;
import com.es.plailing.coursedetail.dao.DetailUserJoinCourse;
import com.es.plailing.coursedetail.dao.UserBalanceDaoImpl;
import com.es.plailing.coursedetail.dao.UserCollectionCourseDaoImpl;
import com.es.plailing.coursedetail.dao.CourseDaoImpl;
import com.es.plailing.coursedetail.dao.UsersDaoImpl;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserBalance;
import com.es.plailing.entity.UserCollectionCourse;

/**
 * 
    * @ClassName: CourseDetailServiceImp
    * @Description: TODO(调用coursedetail的方法)
    * @author Administrator
    * @date 2018年11月30日
  	*
 */
@Service
@Transactional(readOnly=false)
public class CourseDetailServiceImp implements CourseDetailService{
    @Resource
    private CourseDaoImpl courseDaoImpl;
    @Resource
    private DetailCourseCatalogDaoImpl courseCatalogDaoImpl;
    @Resource
    private UsersDaoImpl usersDaoImpl;
    @Resource
    private UserBalanceDaoImpl userBalanceDaoImpl;
    @Resource
    private DetailMoneyDaoImpl moneyDaoImpl;
    @Resource
    private UserCollectionCourseDaoImpl userCollectionCourseDaoImpl;
    @Resource
    private DetailUserJoinCourse detailUserJoinCourse;

	@Override
	public Course getCourse(int courseId) {
		try {
			return courseDaoImpl.getCourse(courseId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int getStudyCoursePeople(int courseId) {
		try {
			return courseDaoImpl.getStudyCoursePeople(courseId);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public User getCourseUser(int userId) {
		try {
			return usersDaoImpl.getCourseUser(userId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int getUserUploadCourse(int userId) {
		try {
			return usersDaoImpl.getUserUploadCourse(userId);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int getCourseUserId(int courseId) {
		try {
			return courseDaoImpl.getCourseUserId(courseId);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Page<CourseCatalog> listCourseCatalog(int pageNum, int pageSize, int courseId) {
		try {
			return courseCatalogDaoImpl.listCourseCatalog(pageNum, pageSize, courseId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			return usersDaoImpl.getUserByEmail(email);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public List<Course> listCourse(int courseId) {
		try {
			return courseDaoImpl.listCourse(courseId);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public boolean insertUserBalance(User u, UserBalance ub,Course c) {
		try {
			userBalanceDaoImpl.insertUserBalance(u, ub,c);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean updateUser(User u) {
		try {
			usersDaoImpl.updateUser(u);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean insert(Course c, User u) {
		try {
			moneyDaoImpl.insertMoney(c, u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isCollection(int userId, int courseId) {
		UserCollectionCourse ucc;
		try {
			ucc = userCollectionCourseDaoImpl.getUserCollectionCourse(userId, courseId);
			if(ucc!=null) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean insertCollection(Course course, User user) {
		try {
			userCollectionCourseDaoImpl.insertCollection(course, user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCollection(int courseId,int userId) {
		try {
			userCollectionCourseDaoImpl.updateCollection(courseId, userId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isJoin(int userId, int courseId) {
		try {
			return detailUserJoinCourse.isJoin(userId, courseId);
		} catch (Exception e) {
			return false;		}
	}

	@Override
	public boolean insertJoin(User u, Course c) {
		try {
			detailUserJoinCourse.insertJoin(u, c);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	    
	@Override
	public boolean updateCourse(Course course) {
		try {
			courseDaoImpl.update(course);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	
	
}
