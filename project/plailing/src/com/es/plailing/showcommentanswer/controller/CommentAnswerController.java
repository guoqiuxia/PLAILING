package com.es.plailing.showcommentanswer.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.coursecomment.service.CourseCommenServiceImpl;
import com.es.plailing.coursedetail.service.CourseDetailService;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseComment;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.showcommentanswer.service.CommentAnswerService;
import com.es.plailing.upload.service.UploadServiceImpl;

@Controller
public class CommentAnswerController {

	@Resource
	private CommentAnswerService commentAnswerServiceImpl;
	@Resource
	private CourseDetailService courseDetailServiceImpl;
	@Resource
	private UploadServiceImpl uploadServiceImpl;
	@Resource
	private CourseCommenServiceImpl courseCommentServiceImpl;

	@RequestMapping("/commentAnswer")
	public String getCommentAnswer(HttpServletRequest request, @RequestParam("commentId") int commentId,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam("courseId") int courseId,
			HttpSession session) {

		String semail = "";
		Object email=session.getAttribute("email");
		//判断收藏处的五角星是什么形状
		if(email!=null) {
		    semail=(String) session.getAttribute("email");
		    int uid=uploadServiceImpl.getUserIdByEmail(semail);
			//判断这个课程是否被用户收藏
			boolean isCollection=courseDetailServiceImpl.isCollection(uid, courseId);
			if(isCollection) {
				request.getServletContext().setAttribute("isCollection", "ok");
			}else {
				request.getServletContext().setAttribute("isCollection", "fail");
			}
		}else {
			request.getServletContext().setAttribute("isCollection", "fail");
		}		
		// 得到课程的相关信息
		Course c = courseDetailServiceImpl.getCourse(courseId);
		request.getServletContext().setAttribute("course", c);

		// 得到学习此课程的人数
		int studyPeople = courseDetailServiceImpl.getStudyCoursePeople(courseId);
		request.getServletContext().setAttribute("studypeople", studyPeople);
		// 通过课程号找到上传课程的人
		int cu = courseDetailServiceImpl.getCourseUserId(courseId);

		// 通过userid找到对应的人
		User uploadCourseUser = courseDetailServiceImpl.getCourseUser(cu);
		request.getServletContext().setAttribute("uploadCourseUser", uploadCourseUser);

		// 通过userid找到上传课程的数量
		int uploadCourseCount = courseDetailServiceImpl.getUserUploadCourse(cu);
		request.getServletContext().setAttribute("uploadCourseCount", uploadCourseCount);

		// 通过评论的id找到对应的评论
		CourseComment comment = commentAnswerServiceImpl.getComment(commentId);
		request.getServletContext().setAttribute("comment", comment);

		// 通过评论的id找到回复的评论并且分页显示
		Page<CourseComment> pageCommentList = commentAnswerServiceImpl.listComment(pageNum, 4, commentId);
		request.getServletContext().setAttribute("pageCommentList", pageCommentList);
		request.getServletContext().setAttribute("commentList", pageCommentList.getList());

		// 得到与此课程类型相同的三个课程
		List<Course> listCourse = courseDetailServiceImpl.listCourse(courseId);
		Map<Course, Integer> mpc = new LinkedHashMap<Course, Integer>();
		for (Course temp : listCourse) {
			mpc.put(temp, temp.getJoinUsers().size());
		}
		request.setAttribute("mpc", mpc);

		request.getServletContext().setAttribute("btn", "btn");
		request.getServletContext().setAttribute("commentId", commentId);
		request.getServletContext().setAttribute("courseId", courseId);
		return "showcommentanswer";
	}

}
