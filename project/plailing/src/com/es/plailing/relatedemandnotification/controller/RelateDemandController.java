package com.es.plailing.relatedemandnotification.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.relatedemandnotification.service.RelateDemandServiceImpl;

/**
 * 
    * @ClassName: DemandController
    * @Description: TODO(通过方法获取需求通知)
    * @author 梁芳芳
    * @date 2018年12月19日
    *
 */
@Controller
public class RelateDemandController {

	@Resource
	private RelateDemandServiceImpl relatedemandServiceImpl;
	
	/**
	 * 
	    * @Title: getDemand
	    * @Description: TODO(获取需求通知)
	    * @param @param request
	    * @param @param pageNum
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("/demandinform")
	public String getDemand(HttpServletRequest request,@RequestParam(value = "pageNum", required = true, defaultValue = "1") int pageNum) {
//		所有需求
		User user=(User) request.getServletContext().getAttribute("leftUser");
		List<Demand> listDemand=relatedemandServiceImpl.findDemand(user.getUserId());
		request.getServletContext().setAttribute("listDemand", listDemand);
		
		//分页
		Page<Demand> pageDemand=relatedemandServiceImpl.pageDemand(pageNum, 10, user.getUserId());
		request.getServletContext().setAttribute("pageDemand", pageDemand);
		return "demandnotification";
	}
}
