package com.es.plailing.update.service;

import com.es.plailing.entity.User;

public interface UpdateService {
	public User findUserInfo(String email) throws Exception;
	public void updateUserInfo(String userEmail, String nickName, String confirm_password,String imagePath,  
			String gender, String province,String city, String birthday, String phone,
			String identity, String school, String major, String introduction) throws Exception;
	public void updateUserInfo1(String userEmail, String nickName, String confirm_password,  
			String gender, String province,String city, String birthday, String phone,
			String identity, String school, String major, String introduction) throws Exception;
}
