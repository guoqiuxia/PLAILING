package com.es.plailing.left.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.plailing.entity.User;
import com.es.plailing.left.service.LeftServiceImpl;

@Controller
public class LeftController {

	@Resource
	private LeftServiceImpl leftServiceImpl;
	
	@RequestMapping("/left")
	public String getLeft(HttpServletRequest request) {
		String email=(String) request.getSession().getAttribute("email");
		User user=leftServiceImpl.findLeft(email);
		request.getServletContext().setAttribute("leftUser", user);	
		
		return "redirect:user/findInfo";
	}
	@RequestMapping("/left1")
	public String getLeft1(HttpServletRequest request) {
		String email=(String) request.getSession().getAttribute("email");
		User user=leftServiceImpl.findLeft(email);
		request.getServletContext().setAttribute("leftUser", user);	
		
		return "redirect:findFirstType";
	}
}
