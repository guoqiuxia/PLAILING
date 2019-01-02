package com.es.plailing.update.controller;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.es.plailing.entity.User;
import com.es.plailing.update.service.UpdateServiceImpl;

/*
 * 
    * @ClassName: UpdateController
    * @Description: TODO(update页面控制器，实现查询用户原有信息，以及更新信息)
    * @author 张思嘉
    * @date 2018年12月3日
    *
 */
@Controller
@RequestMapping("/user")
public class UpdateController {
	@Resource
	private UpdateServiceImpl updateServiceImpl;
	// 上传头像存储目录
	private static final String UPLOAD_DIRECTORY = "D:\\p\\plailing\\WebContent\\img\\userProfilePhoto";

	/**
	 * 
	 * @Title: findUserInfo @Description: TODO(查询用户原有信息，跳转到update) @param @param
	 *         request @param @return @param @throws Exception 参数 @return String
	 *         返回类型 @throws
	 */
	@RequestMapping(value = "/findInfo", method = RequestMethod.GET)
	public String findUserInfo(HttpServletRequest request) throws Exception {
		String userEmail = (String) request.getSession().getAttribute("email");
		User user = updateServiceImpl.findUserInfo(userEmail);
		request.getSession().setAttribute("userInfo", user);
		return "update";
	}

	/**
	 * 
	 * @Title: updateUserInfo @Description: TODO(更新用户信息，然后跳转) @param @param
	 *         request @param @return @param @throws Exception 参数 @return String
	 *         返回类型 @throws
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUserInfo(@RequestParam("up_file") MultipartFile image, HttpServletRequest request, Model model)
			throws Exception {
		String userEmail = (String) request.getSession().getAttribute("email");
		// 昵称
		String nickName = (String) request.getParameter("nickName");
		// 密码
		String confirm_password = (String) request.getParameter("confirm_password");
		// 性别
		String gender = (String) request.getParameter("gender");
		// 所在地 option中获取的是text文本
		String province = (String) request.getParameter("province_selected");
		String city = (String) request.getParameter("city_selected");
		// 生日
		String birthday = (String) request.getParameter("birthday");
		// 手机号
		String phone = (String) request.getParameter("phone");
		// 身份证号
		String identity = (String) request.getParameter("identityNumber");
		// 学校
		String school = (String) request.getParameter("school");
		// 专业
		String major = (String) request.getParameter("major");
		// Info
		String introduction = (String) request.getParameter("introduction");

		//头像文件名
		String image1 = image.getOriginalFilename();
		//依据有没有上传头像区分为两个update
		if(image1.equals("")) {//没有上传图片时，只更新其他信息
			updateServiceImpl.updateUserInfo1(userEmail, nickName, confirm_password, 
			gender, province, city, birthday, phone,
			identity, school, major, introduction);
		}else {//上传图片头进行重命名处理，每次上传会覆盖原有头像
			String imagePath = "img/userProfilePhoto/"+userEmail+image1.substring(image1.indexOf('.'));
			updateServiceImpl.updateUserInfo(userEmail, nickName, confirm_password, 
					imagePath,gender, province, city, birthday, phone,
					identity, school, major, introduction);
		}		
		// 将头像存入本地服务器路径，判断文件不为空，写入上传路径
		if (!image.isEmpty()) {
			// 上传文件路径
			String path = UPLOAD_DIRECTORY;// 本地绝对路径
			// 获取上传文件名
			String imagename = userEmail+image1.substring(image1.indexOf('.'));
			File imagepath = new File(path, imagename);
			// 判断路径是否存在
			if (!imagepath.getParentFile().exists()) {
				imagepath.getParentFile().mkdirs();
			}
			//存入本地
			try {
				image.transferTo(new File(path + File.separator + imagename));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int userId = updateServiceImpl.findUserInfo(userEmail).getUserId();

		return "redirect:../information?userId="+userId;
	}

	/**
	 * 
	 * @Title: checkNickName 
	 * @Description: TODO(ajax实现密码格式检查) 
	 * @param @param request 
	 * @param @param password 
	 * @param @return 参数 
	 * @return String 返回类型
	 *  @throws
	 */
	@RequestMapping("/checkPWD")
	@ResponseBody
	public String checkPWD(HttpServletRequest request, @RequestParam("password") String password) {
		String result = "no pass";
		String passwordFormat = "^[0-9a-zA-Z]\\w{5,17}$";
		Pattern pattern = Pattern.compile(passwordFormat);
		Matcher matcher = pattern.matcher(password);
		boolean b = matcher.matches();
		if (b) {
			result = "pass";
		}
		return result;
	}

	/**
	 * 
	    * @Title: checkPhone
	    * @Description: TODO(ajax实现电话格式检查)
	    * @param @param request
	    * @param @param phone
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("/checkPhone")
	@ResponseBody
	public String checkPhone(HttpServletRequest request, @RequestParam("phone") String phone) {
		String result = "no pass";
		String passwordFormat = "^[0-9]\\w{5,17}$";
		Pattern pattern = Pattern.compile(passwordFormat);
		Matcher matcher = pattern.matcher(phone);
		boolean b = matcher.matches();
		if (b) {
			result = "pass";
		}
		return result;
	}
	
	/**
	 * 
	    * @Title: checkID
	    * @Description: TODO(ajax实现身份证号格式检查)
	    * @param @param request
	    * @param @param identity
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("/checkID")
	@ResponseBody
	public String checkID(HttpServletRequest request, @RequestParam("identity") String identity) {
		String result = "no pass";
		String passwordFormat = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
		Pattern pattern = Pattern.compile(passwordFormat);
		Matcher matcher = pattern.matcher(identity);
		boolean b = matcher.matches();
		if (b) {
			result = "pass";
		}
		return result;
	}
}
