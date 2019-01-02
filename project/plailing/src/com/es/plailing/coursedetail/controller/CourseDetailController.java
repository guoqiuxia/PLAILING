package com.es.plailing.coursedetail.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.plailing.coursedetail.service.CourseDetailService;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserBalance;
import com.es.plailing.upload.service.UploadService;


/**
 * 
    * @ClassName: CourseDetailController
    * @Description: 实现coursedetail页面
    * @author liushanshan
    * @date 2018年11月28日
    *
 */
@Controller
public class CourseDetailController {
	
	@Resource
	private CourseDetailService courseDetailServiceImpl;
	@Resource
	private UploadService uploadServiceImpl;
	
	@RequestMapping("/courseDetail")
	public String showCourseDetail(HttpServletRequest request,@RequestParam("courseId") int courseId,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum,HttpSession session) {
		String semail="";
		Object email=session.getAttribute("email");
		//判断收藏处的五角星是什么形状
		if(email!=null) {
		    semail=(String) session.getAttribute("email");
		    int uid=uploadServiceImpl.getUserIdByEmail(semail);
		    System.out.println(uid);
			//判断这个课程是否被用户收藏
			boolean isCollection=courseDetailServiceImpl.isCollection(uid, courseId);
			System.out.println(isCollection);
			if(isCollection) {
				request.getServletContext().setAttribute("isCollection", "ok");
			}else {
				request.getServletContext().setAttribute("isCollection", "fail");
			}
		}else {
			request.getServletContext().setAttribute("isCollection", "fail");
		}		
		//得到课程的相关信息
		Course c=courseDetailServiceImpl.getCourse(courseId);
		request.getServletContext().setAttribute("course", c);
		
		//得到学习此课程的人数
		int studyPeople=courseDetailServiceImpl.getStudyCoursePeople(courseId);
		request.getServletContext().setAttribute("studypeople", studyPeople);
		
		//得到课程的目录
		Page<CourseCatalog> pageCatalogList=courseDetailServiceImpl.listCourseCatalog(pageNum,3,courseId);
		request.getServletContext().setAttribute("pageCatalogList", pageCatalogList);
		request.getServletContext().setAttribute("catalogList", pageCatalogList.getList());
		
		//通过课程号找到上传课程的人
		int cu=courseDetailServiceImpl.getCourseUserId(courseId);
		
		//通过userid找到对应的人
		User uploadCourseUser=courseDetailServiceImpl.getCourseUser(cu);
		request.getServletContext().setAttribute("uploadCourseUser", uploadCourseUser);
		
		//通过userid找到上传课程的数量
		int uploadCourseCount=courseDetailServiceImpl.getUserUploadCourse(cu);
		request.getServletContext().setAttribute("uploadCourseCount",uploadCourseCount);
		
		//得到与此课程类型相同的三个课程
		List<Course> listCourse=courseDetailServiceImpl.listCourse(courseId);
		Map<Course,Integer> mpc=new LinkedHashMap<Course,Integer>();
		for(Course temp:listCourse) {
			mpc.put(temp, temp.getJoinUsers().size());
		}
		request.setAttribute("mpc", mpc);
		request.getServletContext().setAttribute("email", semail); 
		

		request.getServletContext().setAttribute("uploaduser", cu);
		request.getServletContext().setAttribute("courseId", courseId);
		request.getServletContext().setAttribute("count", (pageNum-1)*3); 
		return "coursedetail";
	}
	
	@RequestMapping("/insertdetailCollection")
	public void isCollectioin(@RequestParam("courseId") int courseId,
			HttpServletResponse response,HttpSession session) throws IOException {
		Object obj=session.getAttribute("email");
		if(obj==null) {
			response.getWriter().print("emailempty");
		}else {
			String semail=(String) session.getAttribute("email");
			int uid=uploadServiceImpl.getUserIdByEmail(semail);	
			Course course=courseDetailServiceImpl.getCourse(courseId);
			User user=courseDetailServiceImpl.getCourseUser(uid);
			boolean insertCollection=courseDetailServiceImpl.insertCollection(course, user);
			if(insertCollection) {
				response.getWriter().print("ok");
			}else {
				response.getWriter().print("fail");
			}
		}
	}
	
	@RequestMapping("/canceldetailCollection")
	public void canceldetailCollection(@RequestParam("courseId") int courseId,
			HttpServletResponse response,HttpSession session) throws IOException{
		Object obj=session.getAttribute("email");
		if(obj==null) {
			response.getWriter().print("emailempty");
		}else {
			String semail=(String) session.getAttribute("email");
			int uid=uploadServiceImpl.getUserIdByEmail(semail);	
			boolean canceldetailCollection=courseDetailServiceImpl.updateCollection(courseId, uid);
			if(canceldetailCollection) {
				response.getWriter().print("ok");
			}else {
				response.getWriter().print("fail");
			}
		}
	}
	
	@RequestMapping("/detailJoin")
	public void isJoin(@RequestParam("courseId") int courseId,@RequestParam("uploadUser") int upuserId,
			HttpServletResponse response,HttpSession session) throws IOException {
		Object obj=session.getAttribute("email");
		if(obj==null) {
			response.getWriter().print("emailempty");
		}else {
			String semail=(String) session.getAttribute("email");
			int uid=uploadServiceImpl.getUserIdByEmail(semail);
			Course course=courseDetailServiceImpl.getCourse(courseId);
			User u=courseDetailServiceImpl.getCourseUser(uid);
			User upu=courseDetailServiceImpl.getCourseUser(upuserId);
			//判断这个用户是否已经加入过此课程
			boolean b=courseDetailServiceImpl.isJoin(uid, courseId);
			if(b) {
				response.getWriter().print("fail");
			}else {
				//判断账户余额是否小于课程的价格
				if(u.getBalance()<course.getPrice()) {
					response.getWriter().print("checkfail");
				}else{
					double totleMoney=u.getBalance()-course.getPrice();
					UserBalance ub=new UserBalance();
					ub.setTotleMoney(totleMoney);
					//写零钱明细
					boolean insertUserBalance=courseDetailServiceImpl.insertUserBalance(u, ub,course);
					//修改用户的余额
					u.setBalance(totleMoney);
					boolean updateUser=courseDetailServiceImpl.updateUser(u);
					//添加赚钱明细
					boolean insertMoney=courseDetailServiceImpl.insert(course, upu);
					//将信息填写到收藏课程内
					boolean insertJoin=courseDetailServiceImpl.insertJoin(u, course);
					//修改课程信息
					course.setJoinCount(course.getJoinUsers().size());
					boolean courseJoinCount=courseDetailServiceImpl.updateCourse(course);
				
					if(insertUserBalance && updateUser && insertMoney && insertJoin && courseJoinCount) {
						response.getWriter().print("buy");
					}
				}
			}
		}
		
	}
	@RequestMapping("/study")
	@ResponseBody
	public String study(HttpServletRequest request, @RequestParam("courseId") int courseId) {
		String result="";
		Object obj=request.getSession().getAttribute("email");
		if(obj==null) {
			result="fail";
			return result;
		}else {
			String semail=(String)request.getSession().getAttribute("email");
			int uid=uploadServiceImpl.getUserIdByEmail(semail);
			//判断这个用户是否已经加入过此课程
			boolean b=courseDetailServiceImpl.isJoin(uid, courseId);
			if(b) {
				result = "pass";
				return result;
			}else {
				result = "fail1";
				return result;
			}
		}
	}

}

