package com.es.plailing.update.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.entity.User;
import com.es.plailing.update.dao.UpdateDaoImpl;

/*
 * 
    * @ClassName: UpdateServiceImpl
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 张思嘉
    * @date 2018年12月3日
    *
 */
@Service
@Transactional(readOnly = true)
public class UpdateServiceImpl implements UpdateService{
	@Resource
	private UpdateDaoImpl updateDaoImpl;

	/**
	 * 
	    * @Title: findUserInfo
	    * @Description: TODO(查询原有信息)
	    * @param @param email
	    * @param @return
	    * @param @throws Exception    参数
	    * @return User    返回类型
	    * @throws
	 */
	public User findUserInfo(String email) throws Exception {
		return updateDaoImpl.findUserInfo(email);
	}
	
	/**
	 * @throws Exception 
	 * @param introduction 
	 * @param major 
	 * @param school 
	 * @param identity 
	 * @param phone 
	 * @param birthday 
	 * @param homeStay 
	 * @param gender 
	 * @param confirm_password 
	 * 
	    * @Title: updateUserInfo
	    * @Description: TODO(调用updateDaoImpl更新用户信息)
	    * @param @param user    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void updateUserInfo(String userEmail, String nickName, String confirm_password,String imagePath, 
			String gender, String province,String city, String birthday, String phone,
			String identity, String school, String major, String introduction) throws Exception {
		updateDaoImpl.updateInfo(userEmail,nickName,confirm_password,imagePath, gender,province,city,birthday,phone,identity,school,major,introduction);
	}
	
	/**
	 * 
	    * @Title: updateUserInfo1
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
	public void updateUserInfo1(String userEmail, String nickName, String confirm_password, 
			String gender, String province,String city, String birthday, String phone,
			String identity, String school, String major, String introduction) throws Exception {
		updateDaoImpl.updateInfo1(userEmail,nickName,confirm_password,gender,province,city,birthday,phone,identity,school,major,introduction);
	}
}
