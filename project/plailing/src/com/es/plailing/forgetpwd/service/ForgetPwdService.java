package com.es.plailing.forgetpwd.service;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.User;
/**
 * 
    * @ClassName: ForgetPwdService
    * @Description: TODO(forgetpwd页面service接口类)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
@Service
public interface ForgetPwdService {
	public  void updateTheUserPwd(String email,String pwd);
	public User getTheUser(String email);
}
