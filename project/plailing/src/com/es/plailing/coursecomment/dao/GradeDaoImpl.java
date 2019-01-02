package com.es.plailing.coursecomment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Grade;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

/**
 * 
 * @ClassName: GradeDaoImpl
 * @Description: TODO(评分的dao)
 * @author 梁雅茹
 * @date 2018年12月18日
 *
 */
@Repository
public class GradeDaoImpl extends BaseDao<Grade, Integer> {
	public void giveGrade(User u, Course c, int grade) throws Exception {
		Grade g = new Grade();
		g.setUser(u);
		g.setCourse(c);
		g.setGrade(grade);
		this.save(g);
	}

	public boolean checkGrade(User u, Course c) throws Exception {
		String hql = "from Grade g where g.user.userId=? and g.course.courseId=?";
		Object[] params = { u.getUserId(), c.getCourseId() };
		Grade g = this.findOne(hql, params);
		if (g != null) {
			return true;
		} else {
			return false;
		}
	}

	public Grade findTheGrade(User u, Course c) throws Exception {
		String hql = "from Grade g where g.user.userId=? and g.course.courseId=?";
		Object[] params = { u.getUserId(), c.getCourseId() };
		return this.findOne(hql, params);
	}

	public List<Grade> listGrounds(int courseId) throws Exception {
		String hql = "from Grade g where g.course.courseId=?";
		Object[] params = { courseId };
		return this.find(hql, params);
	}
}
