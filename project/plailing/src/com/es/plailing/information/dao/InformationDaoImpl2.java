package com.es.plailing.information.dao;


import java.util.Date;

import org.springframework.stereotype.Repository;
import com.es.plailing.entity.Follow;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;
/**
 * 
    * @ClassName: InformationDaoImpl2
    * @Description: TODO(information页面关于Follow的dao)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
@Repository
public class InformationDaoImpl2 extends BaseDao<Follow,Integer>{
	/**
	 * 
	    * @Title: checkFollow
	    * @Description: TODO(检查userId1是否关注userId2)
	    * @param @param userId1
	    * @param @param userId2
	    * @param @return
	    * @param @throws Exception    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public boolean checkFollow(User user1,User user2) throws Exception{
		String hql = "from Follow f where f.studentUser.userId=? and f.teacherUser.userId=?";
		Object[] params = {user1.getUserId(),user2.getUserId()};
		Follow follow = this.findOne(hql, params);
		if(follow!=null&&follow.getState()==1) {
			return true;
		}else {
			return false;
		}
	}
	public void addFollow(User user1,User user2) throws Exception{
		String hql = "from Follow f where f.studentUser.userId=? and f.teacherUser.userId=?";
		Object[] params = {user1.getUserId(),user2.getUserId()};
		Follow follow = this.findOne(hql, params);
		if(follow!=null) {
			follow.setState(1);
			update(follow);
		}else {
			Follow f = new Follow();
			f.setState(1);
			f.setStudentUser(user1);
			f.setTeacherUser(user2);
			f.setFollowDate(new Date());
			user1.getStudentFollows().add(f);
			user2.getTeacherFollows().add(f);
			save(f);
		}
	}
	public void deleteFollow(User user1,User user2) throws Exception{
		String hql = "from Follow f where f.studentUser.userId=? and f.teacherUser.userId=?";
		Object[] params = {user1.getUserId(),user2.getUserId()};
		Follow follow = this.findOne(hql, params);
		follow.setState(0);
		update(follow);
	}
}
