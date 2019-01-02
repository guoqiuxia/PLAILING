package com.es.plailing.index.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.entity.Course;
import com.es.plailing.index.service.IndexServiceImpl;

@Controller
/**
 * 
 * @ClassName: IndexController
 * @Description: TODO(index页面的控制类)
 * @author 梁雅茹
 * @date 2018年12月8日
 *
 */
public class IndexController {
	@Resource
	IndexServiceImpl indexServiceImpl;

	/**
	 * 
	 * @Title: index @Description: TODO(查询index页的信息) @param @param
	 * request @param @return index页面 @return String 返回类型 @throws
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		List<Course> recomendCourse = this.indexServiceImpl.listCoursesByGrades();
		Map<Object, Integer> recomendCourses = new LinkedHashMap<Object, Integer>();
		for (Course c : recomendCourse) {
			recomendCourses.put(c, c.getJoinUsers().size());
		}
		request.getServletContext().setAttribute("recomendCourses", recomendCourses);

		List<Course> hotCourse = this.indexServiceImpl.listHotCourses();
		Map<Object, Integer> hotCourses = new LinkedHashMap<Object, Integer>();
		for (Course c : hotCourse) {
			hotCourses.put(c, c.getJoinUsers().size());
		}
		request.getServletContext().setAttribute("hotCourses", hotCourses);
		
		String email=(String) request.getSession().getAttribute("email");
		if (email != null) {
			request.getServletContext().setAttribute("loginFlag", 1);
		} else {
			request.getServletContext().setAttribute("loginFlag", 0);
		}
		
		return "index";
	}
}