package com.es.plailing.checkinform.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.checkinform.service.CheckInformServiceImpl;
import com.es.plailing.coursecomment.service.CourseCommenServiceImpl;
import com.es.plailing.entity.Inform;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;

/**
 * 
    * @ClassName: CheckInformController
    * @Description: TODO(通过方法获取审核信息通知)
    * @author 梁芳芳
    * @date 2018年12月19日
    *
 */
@Controller
public class CheckInformController {

	@Resource
	private CheckInformServiceImpl checkInformServiceImpl;
	
	/**
	 * 
	    * @Title: getCourseRelease
	    * @Description: TODO(通过方法获取审核信息通知)
	    * @param @param request
	    * @param @param pageNum
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	
	@RequestMapping("/release")
	public String getCourseRelease(HttpServletRequest request,@RequestParam(value = "pageNum", required = true, defaultValue = "1") int pageNum) {
		
		//获取上传课程
		User user =(User) request.getServletContext().getAttribute("leftUser");
		List<Inform> listInform=checkInformServiceImpl.findInform(user.getUserId());
		request.getServletContext().setAttribute("listInform", listInform);
		
		//分页
		Page<Inform> pageRelease=checkInformServiceImpl.pageInform(pageNum, 10, user.getUserId());
		request.getServletContext().setAttribute("pageRelease", pageRelease);
		
		return "checkinform";
	}
}
