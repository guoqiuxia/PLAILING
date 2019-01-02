package com.es.plailing.demand.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.es.plailing.coursedetail.service.CourseDetailServiceImp;
import com.es.plailing.demand.service.DemandServiceImpl;
import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.information.service.InformationServiceImpl;
import com.es.plailing.upload.service.UploadServiceImpl;

/**
 * 
    * @ClassName: DemandController
    * @Description: TODO(展示demand页面需要的controller)
    * @author 刘珊珊
    * @date 2018年12月21日
    *
 */
@Controller
public class DemandController {

	@Resource
	private DemandServiceImpl demandServiceImpl;
	@Resource
	private UploadServiceImpl uploadServiceImpl;
	@Resource
	private CourseDetailServiceImp courseDetailServiceImpl;
	@Resource
	private InformationServiceImpl informationServiceImpl;

	/**
	 * 
	    * @Title: getDemand
	    * @Description: TODO(需求按照顺序排列，并且显示在页面上)
	    * @param @param pageNum
	    * @param @param request
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("/demand")
	public String getDemand(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			HttpServletRequest request) {
		String email = "";
		Object o = request.getSession().getAttribute("email");
		if (o != null) {
			email = (String) request.getSession().getAttribute("email");
		}
		Page<Demand> pageDemand = demandServiceImpl.listDemand(pageNum, 10);
		request.getServletContext().setAttribute("pageDemand", pageDemand);
		request.getServletContext().setAttribute("listDemand", pageDemand.getList());
		request.getServletContext().setAttribute("count", (pageNum - 1) * 10);
		request.getServletContext().setAttribute("email", email);
		request.getServletContext().setAttribute("pageNum", pageNum);
		return "demand";
	}
	/**
	 * 
	    * @Title: addDemand
	    * @Description: TODO(将需求的数据添加到数据库中)
	    * @param @param pageNum
	    * @param @param text
	    * @param @param request
	    * @param @param response
	    * @param @throws IOException    参数
	    * @return void    返回类型
	    * @throws
	 */
	@RequestMapping("/addDemand")
	public void addDemand(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam("search") String text, HttpServletRequest request,HttpServletResponse response) throws IOException {
		String result="";
		String semail = (String) request.getSession().getAttribute("email");
		User user = informationServiceImpl.getTheUserByEmail(semail);
		Demand demand=demandServiceImpl.getDemand(text);
		boolean b = demandServiceImpl.addDeamand(text, demand);
		if(b) {
			Demand demand1=demandServiceImpl.getDemand(text);
			boolean b1 = demandServiceImpl.addUserDemand(user, text, demand1);
			if(b1) {
				response.getWriter().print("ok");
			}else {
				response.getWriter().print("fail");
			}
		}else {
			response.getWriter().print("fail");
		}
		
	}
	
	/**
	 * 
	    * @Title: searchWord
	    * @Description: TODO(根据搜索框的内容进行模糊匹配)
	    * @param @param word
	    * @param @param response
	    * @param @throws IOException    参数
	    * @return void    返回类型
	    * @throws
	 */
	@RequestMapping("/search")
	public void searchWord(@RequestParam(value="searchWord") String word,HttpServletResponse response) throws IOException {
		List<Object[]> listDemand=demandServiceImpl.listDemand(1,6,word); 
		System.out.println(listDemand.size());
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(JSON.toJSONString(listDemand));
	}

}
