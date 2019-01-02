package com.es.plailing.relatecomment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.es.plailing.coursecomment.service.CourseCommentService;
import com.es.plailing.coursedetail.service.CourseDetailService;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.relatecomment.service.RelateCourseCommentService;
import com.es.plailing.upload.service.UploadServiceImpl;

@Controller
@RequestMapping("/relatecoursecomment")
public class RelateCourseCommentController {
	@Resource
	private RelateCourseCommentService relateCourseCommentService;
	@Resource
	private CourseDetailService courseDetailServiceImpl;
	@Resource
	private UploadServiceImpl uploadServiceImpl;
	@RequestMapping("/find")
	public String getCourseComment(HttpServletRequest request,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, HttpSession session) {

		String email=(String)request.getSession().getAttribute("email");
		// 查找用关课程的评论并显示出来
		Page<CourseComment> pageCommentList = relateCourseCommentService.pageCourseComment(pageNum, 10, email);
		request.getServletContext().setAttribute("pageCommentList", pageCommentList);
		request.getServletContext().setAttribute("commentList", pageCommentList.getList());


		return "relatecoursecomment";
	}

	@RequestMapping("/insertAnswerCourseComment")
	@ResponseBody
	public String insertCourseComment(
			@RequestParam("text") String content, @RequestParam("commentPid") int courseCommentId,
			@RequestParam("oHfTop") String oHfTop,
			HttpServletResponse response,HttpSession session,HttpServletRequest request) {
		String result="";
		Object obj=session.getAttribute("email");
		if(obj==null) {
			result="emailempty";
			return result;
		}else {
			String semail=(String) obj;
			int userId=uploadServiceImpl.getUserIdByEmail(semail);	
			User u = courseDetailServiceImpl.getCourseUser(userId);
			CourseComment courseComment = relateCourseCommentService.getCourseComment(courseCommentId);
			Course c = courseComment.getCourse();
			CourseComment newCourseComment = new CourseComment();
			newCourseComment.setCommentTime(new Date());
			newCourseComment.setText(content);
			newCourseComment.setTop(Integer.parseInt(oHfTop));
			boolean insertCourseCommentAnswer = relateCourseCommentService.insertCourseCommentAnswer(courseComment,
					newCourseComment, c, u);
			if (insertCourseCommentAnswer) {
				result="ok";

				return result;
			} else {
				result="false";
				return result;
			}
		}
	}

	@RequestMapping(value="/findsoncomment",method=RequestMethod.POST)
	public void findSonComment(HttpServletRequest request,HttpServletResponse response) {
		List<CourseComment> comments=relateCourseCommentService.FindSon(Integer.parseInt(request.getParameter("oHfTop")));
		List<Object[]> name= new ArrayList<Object[]>() ;
		for(CourseComment c:comments ) {
			Object[] aObjects= {c.getCourseCommentId(),(Date)c.getCommentTime(),c.getText(),c.getCourseComment().getUser().getNickName(),c.getUser().getNickName()};
			System.out.println((Date)c.getCommentTime());
			name.add(aObjects);
		}
	     response.setCharacterEncoding("UTF-8");
//	      comment=commentServiceImpl.FindOne(objects);
	     System.out.println("comment2:"+comments);
			PrintWriter out = null;
//			SimplePropertyPreFilter filter=new SimplePropertyPreFilter(Comment.class,"commentId","text","user");
			try {
				out = response.getWriter();
				System.out.println(JSON.toJSONString(name));
				out.print(JSON.toJSONString(name));
			} catch (IOException e) {
				e.printStackTrace();
			}		
	}
}
