package com.es.plailing.information.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Follow;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.information.service.InformationServiceImpl;
/**
 * 
    * @ClassName: InformationController
    * @Description: TODO(information.jsp页面的控制类)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
@Controller
public class InformationController {
	@Resource
	private InformationServiceImpl informationServiceImpl;
	/**
	 * 
	    * @Title: information
	    * @Description: TODO(查询与information有关的信息)
	    * @param @param request
	    * @param @param pageNum
	    * @param @param userId
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("/information")
	public String information(HttpServletRequest request,@RequestParam(value="pageNum",defaultValue="1") int pageNum,@RequestParam("userId") int userId,HttpSession session) {
		int flag = 0;
		int flag1 = 1;
		User user = this.informationServiceImpl.getTheUser(userId);
		if(session.getAttribute("email")!=null) {
			String email = (String)session.getAttribute("email");
			User loginUser = this.informationServiceImpl.getTheUserByEmail(email);
			if(loginUser.getUserId()==user.getUserId()) {
				flag1 = 0;
			}else {
				if(this.informationServiceImpl.checkFollow(loginUser, user)) {
					flag = 1;
				}
			}
		}
		request.setAttribute("flag", flag);
		request.setAttribute("flag1", flag1);
		request.setAttribute("user", user);
		request.setAttribute("courseCount",user.getUploadCourses().size());
		Page<Course> page = this.informationServiceImpl.listPersonCourses(pageNum, 9, user);
		Map<Object,Integer> Coursespage= new LinkedHashMap<Object,Integer>();
		for(Course c:page.getList()) {
			Coursespage.put(c,c.getJoinUsers().size());
		}
		request.setAttribute("Coursespage", Coursespage);
		request.setAttribute("personalCourses", page);
		return "information";
	}
	/**
	 * 
	    * @Title: changeFollow
	    * @Description: TODO(改变关注转态)
	    * @param @param request
	    * @param @param userId
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("/changeFollow")
	@ResponseBody
	public String changeFollow(HttpServletRequest request, @RequestParam("userId") int userId,HttpSession session) {
		String result = "";
		if(session.getAttribute("email")==null) {
			result = "login";
			return result;
		}
		String email  = (String)session.getAttribute("email");
		User loginUser = this.informationServiceImpl.getTheUserByEmail(email);
		User user = this.informationServiceImpl.getTheUser(userId);
		if(this.informationServiceImpl.checkFollow(loginUser, user)) {
			this.informationServiceImpl.deleteFollow(loginUser, user);
			result = "delete";
			return result;
		}else {
			this.informationServiceImpl.addFollow(loginUser, user);
			result = "add";
			return result;
		}
	}
}
