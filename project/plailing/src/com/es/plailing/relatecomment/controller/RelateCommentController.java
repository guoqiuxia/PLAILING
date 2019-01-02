package com.es.plailing.relatecomment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.es.plailing.comment.service.CommentServiceImpl;
import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.relatecomment.service.RelateCommentService;
import com.es.plailing.upload1.service.Upload1CourseServiceImpl;

@Controller
@RequestMapping("/relatecomment")
public class RelateCommentController {
	@Resource
	private RelateCommentService relateCommentService;
	@Resource
	private Upload1CourseServiceImpl courseServiceImpl;
	@Resource
	private CommentServiceImpl commentServiceImpl;
	/**
	 * 
	    * @Title: FindComment
	    * @Description: TODO(分页查询一级评论)
	    * @param @param model
	    * @param @param pageNum
	    * @param @param email
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public String FindComment(Model model,HttpServletRequest request,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum
			 ) {
		String email=(String)request.getSession().getAttribute("email");
		Page<Comment> page=relateCommentService.Find(pageNum,10, email);
		model.addAttribute("page", page);
		model.addAttribute("comments", page.getList());
		return "relatecomment";
	}
	/**
	 * 
	    * @Title: AddSonComment
	    * @Description: TODO(评论回复)
	    * @param @param request
	    * @param @param response    参数
	    * @return void    返回类型
	    * @throws
	 */
	@RequestMapping(value="/addsoncomment",method=RequestMethod.POST)
	public void AddSonComment(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request.getParameter("text") );
		System.out.println(request.getParameter("time"));

		//查询父评论
		Comment commentp=relateCommentService.Get(Integer.parseInt(request.getParameter("commentPid")));	
		CourseCatalog courseCatalog=commentp.getCourseCatalog();
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
		relateCommentService.Save(comment);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(JSON.toJSONString(user.getNickName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	    * @Title: findSonComment
	    * @Description: TODO(查看回复)
	    * @param @param request
	    * @param @param response    参数
	    * @return void    返回类型
	    * @throws
	 */
	@RequestMapping(value="/findsoncomment",method=RequestMethod.POST)
	public void findSonComment(HttpServletRequest request,HttpServletResponse response) {
		List<Comment> comments=relateCommentService.FindSon(Integer.parseInt(request.getParameter("oHfTop")));
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
}
