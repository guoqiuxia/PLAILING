package com.es.plailing.collection.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.plailing.collection.service.CollectionServiceImpl;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserCollectionCourse;

/**
 * 
    * @ClassName: CollectionController
    * @Description: TODO(课程收藏页面跳转)
    * @author 梁芳芳
    * @date 2018年12月3日
    *
 */

@Controller
public class CollectionController {

	@Resource
	private CollectionServiceImpl collectionServiceImpl;
	
	/**
	 * 
	    * @Title: getCollection
	    * @Description: TODO(查询收藏课程)
	    * @param @param request
	    * @param @param pageNum
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("/collection")
	public String getCollection(HttpServletRequest request,@RequestParam(value="pageNum",required=true,defaultValue="1") int pageNum) {		
		User user=(User) request.getServletContext().getAttribute("leftUser");
		//学习人数
		String email=user.getEmail();
		List<Course> listCourse=collectionServiceImpl.findCourse(email);
		
		Map<Course,Integer> mpc=new LinkedHashMap<Course,Integer>();
		for(Course temp:listCourse) {
			mpc.put(temp, temp.getJoinUsers().size());
		}
		request.setAttribute("mpc", mpc);

		//分页
		Page<Course> pageCourse=collectionServiceImpl.findPage(pageNum, 9,user.getEmail());		
		request.getServletContext().setAttribute("pageCourse", pageCourse);
		return "collection";
	}
	
	/**
	 * 
	    * @Title: deleteCollection
	    * @Description: TODO(更改数据状态)
	    * @param @param request
	    * @param @param response
	    * @param @param courseId
	    * @param @throws IOException    参数
	    * @return void    返回类型
	    * @throws
	 */
	@RequestMapping("/delete")
	public void deleteCollection(HttpServletRequest request,HttpServletResponse response, @RequestParam("courseId") int courseId) throws IOException {
		User user=(User) request.getServletContext().getAttribute("leftUser");		
		if(collectionServiceImpl.checkCourse(user.getUserId(), courseId)) {
			collectionServiceImpl.deleteCourse(user.getUserId(), courseId);
			response.getWriter().print("delete");			
		}else {
			response.getWriter().print("");
		}
		
	}
	
}
