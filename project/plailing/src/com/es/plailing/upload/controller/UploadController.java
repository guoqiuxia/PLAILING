package com.es.plailing.upload.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.upload.service.UploadService;

@Controller
public class UploadController {
	@Resource
	private UploadService uploadServiceImpl;
	
	@RequestMapping("/upload")
	public String upload(HttpSession session,HttpServletRequest request,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum) {
		Object obj=session.getAttribute("email");
		if(obj!=null) {
			String email=(String) session.getAttribute("email");
			int userId=uploadServiceImpl.getUserIdByEmail(email);
			Page<Course> coursepage=uploadServiceImpl.listCourseByUserId(pageNum,10,userId);
			request.getServletContext().setAttribute("coursepage", coursepage);
			request.getServletContext().setAttribute("courseList", coursepage.getList());	
		}
		return "upload";

	}
	
}
