package com.es.plailing.forgetpwd.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;
/**
 * 
    * @ClassName: ForgetPwdDaoImpl
    * @Description: TODO(forgetpwd页面关于用户的dao)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
@Repository
public class ForgetPwdDaoImpl extends BaseDao<User,Integer>{
/**
 * 
    * @Title: updateUserPwd
    * @Description: TODO(在数据库里修改用户的密码)
    * @param @param email
    * @param @param pwd
    * @param @throws Exception    参数
    * @return void    返回类型
    * @throws
 */
	public void updateUserPwd(String email,String pwd) throws Exception {
		Session session = this.sessionFactory.openSession();;
		Transaction tx = session.beginTransaction();
		String hql = "from User u where u.email=:email";
		Query query = session.createQuery(hql);
		query.setParameter("email",email);
		User u = (User)query.uniqueResult();
		u.setPassword(pwd);
		tx.commit();
		session.close();
	}
	/**
	 * 
	    * @Title: getUser
	    * @Description: TODO(通过用户email获得用户)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return User    返回类型
	    * @throws
	 */
	public User getUser(String email) throws Exception{
		String hql = "from User u where u.email=?";
		Object[] params = {email};
		return this.findOne(hql, params);
	}
}
