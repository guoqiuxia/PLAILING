package com.es.plailing.index.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
    * @ClassName: FilterController
    * @Description: TODO(拦截是否登录查看个人中心页面)
    * @author 梁雅茹
    * @date 2018年12月11日
    *
 */
@Controller
public class FilterController {
	@RequestMapping("/pleaseLogin")
	@ResponseBody
	public String pleaseLogin(HttpServletRequest request) {
		String result = "fail";
		Object object = request.getSession().getAttribute("email");
		if(object!=null) {
			result = "pass";
			return result;
		}
		return result;
	}
}
