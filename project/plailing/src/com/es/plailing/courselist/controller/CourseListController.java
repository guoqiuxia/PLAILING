package com.es.plailing.courselist.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.es.plailing.courselist.service.CourseListServiceImpl;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseType;
import com.es.plailing.entity.Page;
/**
 * 
    * @ClassName: CourseListController
    * @Description: TODO(courselist页的控制类)
    * @author 梁雅茹
    * @date 2018年11月28日
    *
 */
@Controller
public class CourseListController {
	@Resource
	private CourseListServiceImpl courseListServiceImpl;
/**
 * 
    * @Title: courseListAll
    * @Description: TODO(查询courselist页面全部课程的数据)
    * @param @param request
    * @param @return    参数
    * @return String    返回类型
    * @throws
 */
	@RequestMapping("/courseListAll")
	public String courseListAll(HttpServletRequest request,@RequestParam(value="pageNum",defaultValue="1") int pageNum) {
		List<CourseType> parentType = new ArrayList<CourseType>();
		parentType = courseListServiceImpl.listAllCoursePareType();
		List<Course> listHotCourse = this.courseListServiceImpl.listCourseHotCourses();
		request.getServletContext().setAttribute("listHotCourse",listHotCourse);
		request.getServletContext().setAttribute("parentType",parentType);
		request.setAttribute("mTag","推荐");
		//分页查询课程
		int total = this.courseListServiceImpl.listAllCourses().size();
		System.out.print(total);
		System.out.print("helloworld");
		Page<Course> page = courseListServiceImpl.listAllCoursesPage(pageNum, 12,total);
		Map<Object,Integer> Coursespage= new LinkedHashMap<Object,Integer>();
		for(Course c:page.getList()) {
			Coursespage.put(c,c.getJoinUsers().size());
		}
		request.getServletContext().setAttribute("Coursespage",Coursespage);
		request.getServletContext().setAttribute("page", page);
		request.setAttribute("tag","ac");
		return "courselist";
	}
	/**
	 * 
	    * @Title: courseListF
	    * @Description: TODO(查询courselist页面父类型课程的数据)
	    * @param @param request
	    * @param @param fTypeId
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("/courseListF")
	public String courseListF(@RequestParam(value="pageNum",defaultValue="1") int pageNum,HttpServletRequest request,@RequestParam("fTypeId") int fTypeId){
		CourseType fCourseType = courseListServiceImpl.getPareType(fTypeId);
		List<CourseType> cCourseTypes = this.courseListServiceImpl.listCoursesChildType(fTypeId);
		request.getServletContext().setAttribute("cCourseTypes",cCourseTypes);
		Page<Course> page = this.courseListServiceImpl.listParentCoursesPage(pageNum, 12, fCourseType);
		Map<Object,Integer> Coursespage= new LinkedHashMap<Object,Integer>();
		for(Course c:page.getList()) {
			Coursespage.put(c,c.getJoinUsers().size());
		}
		request.getServletContext().setAttribute("Coursespage",Coursespage);
		request.getServletContext().setAttribute("page",page);
		request.setAttribute("mTag","全部");
		request.setAttribute("fTypeId",fTypeId);
		request.setAttribute("tag","ftc");
		return "courselist";
	}
	/**
	 * 
	    * @Title: courseListT
	    * @Description: TODO(查询courselist页面子类型课程的数据)
	    * @param @param request
	    * @param @param pageNum
	    * @param @param cTypeId
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("/courseListT")
	public String courseListT(HttpServletRequest request,@RequestParam(value="pageNum",defaultValue="1") int pageNum,@RequestParam("cTypeId") int cTypeId){
		//按子类型分页查询课程
		CourseType cCourseType = this.courseListServiceImpl.getPareType(cTypeId);
		Page<Course> page = this.courseListServiceImpl.listChildCoursesPage(pageNum, 12, cCourseType);
		Map<Object,Integer> Coursespage= new LinkedHashMap<Object,Integer>();
		for(Course c:page.getList()) {
			Coursespage.put(c,c.getJoinUsers().size());
		}
		request.getServletContext().setAttribute("Coursespage",Coursespage);
		request.getServletContext().setAttribute("page",page);
		request.setAttribute("mTag","全部");
		request.setAttribute("cTypeId",cTypeId);
		request.setAttribute("tag","ctc");
		request.setAttribute("fTypeId",cCourseType.getCourseType().getTypeId());
		return "courselist";
	}
	
}
