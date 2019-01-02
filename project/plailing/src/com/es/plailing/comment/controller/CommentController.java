package com.es.plailing.comment.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.es.plailing.comment.service.CommentService;
import com.es.plailing.coursedetail.service.CourseDetailServiceImp;
import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.upload.service.UploadServiceImpl;
import com.es.plailing.upload1.service.Upload1CourseService;




@Controller
@RequestMapping("/comment")
public class CommentController {
	@Resource
	private CommentService commentServiceImpl;
	@Resource
	private Upload1CourseService courseServiceImpl;
	@Resource
	private CourseDetailServiceImp courseDetailServiceImpl;
	@Resource
	private UploadServiceImpl uploadServiceImpl;
	/**
	 * 
	    * @Title: FindComment
	    * @Description: TODO(分页查询一级评论)
	    * @param @param model
	    * @param @param pageNum
	    * @param @param catalogId
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String FindComment(HttpServletRequest request, Model model,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam("catalogId") int catalogId,@RequestParam("courseId") int courseId) {
		Object obj = request.getSession().getAttribute("email");
		String semail = (String) request.getSession().getAttribute("email");
		int uid = this.uploadServiceImpl.getUserIdByEmail(semail);
		// 判断这个用户是否已经加入过此课程
		boolean b = courseDetailServiceImpl.isJoin(uid, courseId);
		if (obj!=null&&b) {
			CourseCatalog singleCourse = this.commentServiceImpl.getSingleCourse(catalogId);
			request.setAttribute("singleCourse", singleCourse);
			User singlerUser = this.commentServiceImpl.getTeacher(catalogId);
			request.setAttribute("singlerUser", singlerUser);
	
			// 得到课程的目录
			Page<CourseCatalog> pageCatalogList = courseDetailServiceImpl.listCourseCatalog(pageNum, 3, courseId);
			request.getServletContext().setAttribute("pageCatalogList", pageCatalogList);
			request.getServletContext().setAttribute("catalogList", pageCatalogList.getList());
	
			// 得到课程评论
			Page<Comment> page = commentServiceImpl.Find(pageNum, 10, catalogId);
			
			model.addAttribute("page", page);
			model.addAttribute("comments", page.getList());
			model.addAttribute("catalogId", catalogId);
			model.addAttribute("courseId", courseId);
			
			request.getServletContext().setAttribute("pageCount", page.getTotalCount());
			request.getServletContext().setAttribute("count", (pageNum-1)*10);
			
			return "videodetail";
		}else {
			return "redirect:demand";
		}
	}

	@RequestMapping(value="/addcomment",method=RequestMethod.POST)
	/**
	 * 
	    * @Title: AddComment
	    * @Description: TODO(数据库插入一级评论并查询返回评论id)
	    * @param @param request
	    * @param @param response    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void AddComment(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request.getParameter("text") );
		System.out.println(request.getParameter("commentTime"));
		Comment comment=new Comment();
		comment.setText(request.getParameter("text"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(request.getParameter("commentTime"));
			comment.setCommentTime(date);
		} catch (ParseException e1) {	
			e1.printStackTrace();
		}
		//获取用户
		User user=commentServiceImpl.FindUser((String)request.getSession().getAttribute("email"));
		comment.setUser(user);
		//查询目录
		Object []object= {Integer.parseInt(request.getParameter("catalogId"))};
		System.out.println(request.getParameter("catalogId"));
		CourseCatalog courseCatalog=courseServiceImpl.FindOne(object);
		comment.setCourseCatalog(courseCatalog);
		comment.setTop(0);
		comment.setCourseCatalog(courseCatalog);
		commentServiceImpl.Save(comment);
		//查询评论
		Comment comments=commentServiceImpl.FindOne(request.getParameter("text"));
		//保存字段到对象数组
		Object[] cObjects= {comment.getCommentId(),comment.getUser().getPhoto(),comment.getUser().getNickName()};
		//传输数据(转化为json)
	     response.setCharacterEncoding("UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
				System.out.println(JSON.toJSONString(cObjects));
				out.print(JSON.toJSONString(cObjects));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(value="/addsoncomment",method=RequestMethod.POST)
	public void AddSonComment(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request.getParameter("text") );
		System.out.println(request.getParameter("time"));
		//查询目录
		Object []object= {Integer.parseInt(request.getParameter("catalogId"))};
		CourseCatalog courseCatalog=courseServiceImpl.FindOne(object);
		//查询父评论
		Comment commentp=commentServiceImpl.Get(Integer.parseInt(request.getParameter("commentPid")));	

		//评论插入数据库
		Comment comment=new Comment();
		comment.setText(request.getParameter("text"));
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date;
			System.out.println(sdf.parse(request.getParameter("time")));
			date = sdf.parse(request.getParameter("time"));
			
			comment.setCommentTime(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		comment.setComment(commentp);
		comment.setCourseCatalog(courseCatalog);
		//获取用户
		User user=commentServiceImpl.FindUser((String)request.getSession().getAttribute("email"));
		
		comment.setUser(user);
		comment.setTop(Integer.parseInt(request.getParameter("oHfTop")));
		commentServiceImpl.Save(comment);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(JSON.toJSONString(user.getNickName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/findsoncomment",method=RequestMethod.POST)
	public void findSonComment(HttpServletRequest request,HttpServletResponse response) {
		List<Comment> comments=commentServiceImpl.FindSon(Integer.parseInt(request.getParameter("oHfTop")));
		List<Object[]> name= new ArrayList<Object[]>() ;
		for(Comment c:comments ) {
			Object[] aObjects= {c.getCommentId(),(Date)c.getCommentTime(),c.getText(),c.getComment().getUser().getNickName(),c.getUser().getNickName()};
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
	
	@RequestMapping("/catalogDetail")
	public void catalogDetails(@RequestParam("courseId") int courseId,@RequestParam("pageNum") int pageNum,
			HttpServletResponse response,HttpServletRequest request) throws IOException {
		List<CourseCatalog> listCourseCatalog=commentServiceImpl.listCourseCatalog(pageNum,3, courseId);
		Collections.reverse(listCourseCatalog);
		List<Object[]> lists=new ArrayList<Object[]>();
		int size=listCourseCatalog.size();
		System.out.println(size);
		for(CourseCatalog cc:listCourseCatalog) {
			List<CourseCatalog> listc=commentServiceImpl.listCourseCatalogByPid(cc.getCatalogId());
			List<Object[]> list=new ArrayList<Object[]>();
			for(CourseCatalog c:listc) {
				Object[] o= {c.getCatalogId(),c.getCatalogName(),c.getCourseFile()};
				list.add(o);
			}
			Object[] params= {cc.getCatalogName(),list,size};
			lists.add(params);
		}

		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(JSON.toJSONString(lists));		
	}
	
	@RequestMapping("/catalogComment")
	public void catalogComment(@RequestParam("courseId") int courseId,@RequestParam("pageNum") int pageNum,
			@RequestParam("catalogId") int catalogId,HttpServletRequest request,HttpServletResponse response,
			HttpServletResponse repsonse) throws IOException {
		List<Comment> listComment=commentServiceImpl.listComment(pageNum, 10, catalogId);
		Collections.reverse(listComment);
		List<Object[]> lists=new ArrayList<Object[]>();
		for(Comment c:listComment) {
			Object[] o= {c.getCommentId(),c.getCommentTime(),c.getText(),c.getUser().getPhoto(),c.getUser().getNickName()};
			lists.add(o);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(JSON.toJSONString(lists));
	}
}
