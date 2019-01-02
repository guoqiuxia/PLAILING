package com.es.plailing.follow.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.plailing.entity.Follow;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.follow.service.FollowServiceImpl;
import com.es.plailing.information.service.InformationServiceImpl;

@Controller
public class FollowController {
	@Resource
	private FollowServiceImpl followServiceImpl;
	@Resource
	private InformationServiceImpl informationServiceImpl;
	
	@RequestMapping("/follow")
	public String follow(HttpServletRequest request,@RequestParam(value="pageNum",defaultValue="1") int pageNum) {
		String email = (String) request.getSession().getAttribute("email");
		User loginUser = this.informationServiceImpl.getTheUserByEmail(email);
		int userId = loginUser.getUserId();
		Page<User> myFollowPeople = this.followServiceImpl.listMyFollow(userId, pageNum, 10);
		request.getServletContext().setAttribute("myFollowPeople", myFollowPeople);
		request.getServletContext().setAttribute("followFlag","myfol");
		Map<User,Integer> myFollowPeopleMap = new LinkedHashMap<User,Integer>();
		for(User u :myFollowPeople.getList()) {
			if(this.informationServiceImpl.checkFollow(u,loginUser)){
				myFollowPeopleMap.put(u, 1);
			}else {
				myFollowPeopleMap.put(u, 0);
			}
		}
		request.getServletContext().setAttribute("myFollowPeopleMap", myFollowPeopleMap);
		return "follow";
	}
	@RequestMapping("/followMe")
	public String followMe(HttpServletRequest request, @RequestParam(value="pageNum",defaultValue="1") int pageNum) {
		String email = (String) request.getSession().getAttribute("email");
		User loginUser = this.informationServiceImpl.getTheUserByEmail(email);
		int userId = loginUser.getUserId();
		Page<User> FollowMePeople = this.followServiceImpl.listMyFollowMe(userId, pageNum, 10);
		request.getServletContext().setAttribute("FollowMePeople", FollowMePeople);
		request.getServletContext().setAttribute("followFlag","folme");
		Map<User,Integer> FollowMePeopleMap = new LinkedHashMap<User,Integer>();
		for(User u :FollowMePeople.getList()) {
			if(this.informationServiceImpl.checkFollow(loginUser,u)){
				FollowMePeopleMap.put(u, 1);
			}else {
				FollowMePeopleMap.put(u, 0);
			}
		}
		request.getServletContext().setAttribute("FollowMePeopleMap", FollowMePeopleMap);
		return "follow";
	}
	@RequestMapping("/deleteFollow")
	@ResponseBody
	public void deleteFollow(HttpServletRequest request,@RequestParam("userId") int userId) {
		String email = (String) request.getSession().getAttribute("email");
		User studentUser = this.informationServiceImpl.getTheUserByEmail(email);
		User teacherUser = this.informationServiceImpl.getTheUser(userId);
		this.informationServiceImpl.deleteFollow(studentUser, teacherUser);
	}
	@RequestMapping("/changemutualFollow")
	@ResponseBody
	public String changemutualFollow(HttpServletRequest request,@RequestParam("userId") int userId) {
		String result = "addmtualfollow";
		String email = (String) request.getSession().getAttribute("email");
		User loginUser = this.informationServiceImpl.getTheUserByEmail(email);
		User studentUser = this.informationServiceImpl.getTheUser(userId);
		//如果互相关注
		if(this.informationServiceImpl.checkFollow(studentUser, loginUser)&&this.informationServiceImpl.checkFollow(loginUser, studentUser)) {
			this.informationServiceImpl.deleteFollow(loginUser, studentUser);
			result = "deletemtualfollow";
			return result;
		}else {
			this.informationServiceImpl.addFollow(loginUser, studentUser);
			return result;
		}
	}
}
