package com.es.plailing.update.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;

/*
 * 
    * @ClassName: UpdateDaoImpl
    * @Description: TODO(查询用户初始信息，更新用户信息)
    * @author 张思嘉
    * @date 2018年12月3日
    *
 */
@Repository
public class UpdateDaoImpl extends BaseDao<User, String> {

	/**
	 * 
	 * @Title: findUserInfo @Description: TODO(查询原有用户信息，用于起始显示) @param @param
	 * User对象 @param @return @param @throws Exception 参数 @return User 返回类型 @throws
	 */
	public User findUserInfo(String email) throws Exception {
		String hql = "from User u where u.email=?";
		Object[] params = { email };
		return findOne(hql, params);
	}

	/**
	 * @param introduction @param major @param school @param identity @param
	 * phone @param birthday @param homeStay @param gender @param
	 * confirm_password @throws Exception
	 *
	 * @Title: update @Description: TODO(更新数据库用户信息) @param @param
	 * User对象 @param @return @param @throws Exception 参数 @return void 返回类型 @throws
	 */
	public void updateInfo(String userEmail, String nickName, String confirm_password,String imagePath, String gender, String province,
			String city, String birthday, String phone, String identity, String school, String major,
			String introduction) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from User u where u.email=:email";
		Query query = session.createQuery(hql);
		query.setParameter("email", userEmail);
		User u = (User) query.uniqueResult();
		u.setNickName(nickName);
		u.setSex(gender);
		u.setPassword(confirm_password);
		u.setPhoto(imagePath);
		u.setNativeProvince(province);
		u.setNativeCity(city);
		u.setBirthday(birthday);
		u.setPhoneNumber(phone);
		u.setIdentityNumber(identity);
		u.setSchool(school);
		u.setMajor(major);
		u.setIntroduction(introduction);
		tx.commit();
		session.close();

	}
	
	/**
	 * 
	    * @Title: updateInfo1
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param userEmail
	    * @param @param nickName
	    * @param @param confirm_password
	    * @param @param gender
	    * @param @param province
	    * @param @param city
	    * @param @param birthday
	    * @param @param phone
	    * @param @param identity
	    * @param @param school
	    * @param @param major
	    * @param @param introduction
	    * @param @throws Exception    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void updateInfo1(String userEmail, String nickName, String confirm_password,String gender, String province,
			String city, String birthday, String phone, String identity, String school, String major,
			String introduction) throws Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from User u where u.email=:email";
		Query query = session.createQuery(hql);
		query.setParameter("email", userEmail);
		User u = (User) query.uniqueResult();
		u.setNickName(nickName);
		u.setSex(gender);
		u.setPassword(confirm_password);
		u.setNativeProvince(province);
		u.setNativeCity(city);
		u.setBirthday(birthday);
		u.setPhoneNumber(phone);
		u.setIdentityNumber(identity);
		u.setSchool(school);
		u.setMajor(major);
		u.setIntroduction(introduction);
		tx.commit();
		session.close();

	}
}
