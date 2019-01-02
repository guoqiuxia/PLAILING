package com.es.plailing.applicationsite.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.applicationsite.service.ApplicationSiteService;
import com.es.plailing.coursedetail.service.CourseDetailService;
import com.es.plailing.entity.Course;

@Controller
public class ApplicationSiteController {

	@Resource
	private ApplicationSiteService applicationSiteServiceImpl;
	@Resource
	private CourseDetailService courseDetailServiceImpl;

	@RequestMapping("/applicationSite")
	public String application(@RequestParam("courseId") int courseId,HttpServletRequest request) {
		String email=(String) request.getSession().getAttribute("email");
		if(!email.equals("")) {
		request.getServletContext().setAttribute("courseId", courseId);
		}
		return "applicationsite";
	}
	@RequestMapping("/insertApplicationSite")
	public void insertApplication(HttpSession session, @RequestParam("sitetype") String siteType,
			@RequestParam("usetime") String useTime,@RequestParam(value = "uselang") String uselang, 
			@RequestParam("courseId") int courseId,HttpServletResponse response)throws IOException {
		Course course=courseDetailServiceImpl.getCourse(courseId);
		if (siteType.equals("") || useTime.equals("") || uselang == "") {
			response.getWriter().print("empty");
		} else {
			Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
			boolean b=pattern.matcher(uselang).matches();
			if(b) {
			double	useLang=Double.valueOf(uselang);
			int i = applicationSiteServiceImpl.insertApplicationSiteDaoImpl(useTime, siteType, useLang,course);
			if (i == 0) {
				response.getWriter().print("userTimefail");
			} else if (i == 1) {
				response.getWriter().print("ok");
			} else if (i == 2) {
				response.getWriter().print("warn");
			} else if (i == 3) {
				response.getWriter().print("userlangfail");
			} else if (i == 4) {
				response.getWriter().print("fail");
			}
			}else {
				response.getWriter().print("timefail");
			}
		}
	}
}
