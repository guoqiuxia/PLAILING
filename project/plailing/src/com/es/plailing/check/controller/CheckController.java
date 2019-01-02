package com.es.plailing.check.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.es.plailing.check.service.CheckServiceImpl;
import com.es.plailing.entity.CourseType;
import com.es.plailing.entity.Demand;
import com.es.plailing.entity.User;
import com.es.plailing.information.service.InformationServiceImpl;

@Controller
public class CheckController {
	@Resource
	private CheckServiceImpl checkServiceImpl;
	@Resource
	private InformationServiceImpl informationServiceImpl;

	@RequestMapping(value = "/findFirstType", method = RequestMethod.GET)
	public String FindCourseType(HttpServletRequest request) {
		List<CourseType> courseTypes = checkServiceImpl.courseTypeList();
		request.setAttribute("courseType", courseTypes);
		return "check";
	}

	@RequestMapping(value = "/findSecondType", method = RequestMethod.POST)
	public void SecondType(HttpServletResponse response, HttpServletRequest request) {
		Object[] objects = new Object[1];
		objects[0] = Integer.parseInt(request.getParameter("TypeId"));
		List<Object[]> courseTypes = checkServiceImpl.find(objects);

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(JSON.toJSONString(courseTypes));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value ="/userSubmit",method = RequestMethod.POST)
	@ResponseBody
	public String userSubmit(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "textarea1", required = true, defaultValue = "") String textarea1,
			@RequestParam(value = "name", required = true, defaultValue = "") String name,
			@RequestParam(value = "textarea", required = true, defaultValue = "") String textarea,
			@RequestParam(value = "secondType", required = true, defaultValue = "") int secondType,
			@RequestParam(value = "price", required = true, defaultValue = "-1") String price1,
			@RequestParam(value = "image", required = false) MultipartFile image,
			@RequestParam(value = "demandId", required = true, defaultValue = "0") int demandId,Model model) {
		int count=0;
		String result;
		response.setCharacterEncoding("UTF-8");
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		boolean b=pattern.matcher(price1).matches();
		if(b) {
			double price=Double.valueOf(price1);
			if (!file1.isEmpty() && !file2.isEmpty() && !textarea1.equals("") && !name.equals("")
					&& !textarea.equals("") && secondType!=0 && price>=0 && !image.isEmpty()) {
				String email = (String) request.getSession().getAttribute("email");
				User user = informationServiceImpl.getTheUserByEmail(email);
				
				String filename1 = StringUtils.substringBeforeLast(file1.getOriginalFilename(),".");
				String filename2 = StringUtils.substringBeforeLast(file2.getOriginalFilename(),".");
				String filename3 = StringUtils.substringBeforeLast(image.getOriginalFilename(),".");
				
				if(filename1.length()>18) {
					filename1 = StringUtils.substringBeforeLast(file1.getOriginalFilename(),".").substring(0, 18);
				}
				if(filename2.length()>18) {
					filename2 = StringUtils.substringBeforeLast(file2.getOriginalFilename(),".").substring(0, 18);
				}
				if(filename3.length()>18) {
					filename3 = StringUtils.substringBeforeLast(image.getOriginalFilename(),".").substring(0, 18);
				}
				filename1=filename1+count+file1.getOriginalFilename().substring(file1.getOriginalFilename().length()-4, file1.getOriginalFilename().length());
				count++;
				filename2=filename2+count+file2.getOriginalFilename().substring(file2.getOriginalFilename().length()-4, file2.getOriginalFilename().length());
				count++;
				filename3=filename3+count+image.getOriginalFilename().substring(image.getOriginalFilename().length()-4, image.getOriginalFilename().length());
				
				// 设置存储路径
				String imgpath = "D:\\p\\plailing\\WebContent\\img\\check\\";
				String vidopath = "D:\\p\\plailing\\WebContent\\videoes\\check\\";
				
				String fileTyle=filename2.substring(filename2.lastIndexOf("."),filename2.length());
				if(fileTyle.equals(".mp4") || fileTyle.equals(".flv")) {
					File imgfilepath = new File(imgpath,filename1);
					File vidofilepath = new File(vidopath,filename2);
					if (!vidofilepath.getParentFile().exists() || !imgfilepath.getParentFile().exists()) {
						vidofilepath.getParentFile().mkdirs();
						imgfilepath.getParentFile().mkdirs();
					}
					try {
						file1.transferTo(new File(imgpath + File.separator + filename1));
						file2.transferTo(new File(vidopath + File.separator + filename2));
						image.transferTo(new File(imgpath + File.separator + filename3));
						checkServiceImpl.insertAuditing(user, textarea1, "img/check/"+filename1,"videoes/check/"+filename2, null,0);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					
					// 创建路径
					File imgfilepath = new File(imgpath,filename1);
					
					// 判断路径是否存在，如果不存在就创建一个
					if (!imgfilepath.getParentFile().exists()) {
						imgfilepath.getParentFile().mkdirs();
					}
					
					// 将文件下载到本地
					try {
						file1.transferTo(new File(imgpath + File.separator + filename1));
						file2.transferTo(new File(imgpath + File.separator + filename2));
						image.transferTo(new File(imgpath + File.separator + filename3));
						checkServiceImpl.insertAuditing(user, textarea1, "img/check/"+filename1, null, "img/check/"+filename2, 0);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				CourseType courseType = checkServiceImpl.findTypeId(secondType);
				Demand demand = checkServiceImpl.findDemand(demandId);
				//将获取到的课程信息，插入到课程表中
				checkServiceImpl.insertCourse(name, "img/"+filename3, price, textarea, user, 0, courseType, 0, 0, demand);
				
				result="ok";
				return result;
				
			}
		}else {
			result="pricefail";
			return result;
		}

		return null;
	}

}
