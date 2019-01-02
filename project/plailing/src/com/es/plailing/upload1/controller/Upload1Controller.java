package com.es.plailing.upload1.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.es.plailing.comment.service.CommentService;
import com.es.plailing.comment.service.CommentServiceImpl;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.CourseType;
import com.es.plailing.entity.User;
import com.es.plailing.upload1.service.Upload1CourseService;
import com.es.plailing.upload1.service.Upload1CourseServiceImpl;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;


/**
 * 
    * @ClassName: Upload1Controller
    * @Description: TODO(上传课程目录及文件)
    * @author 辛佳锟
    * @date 2018年12月19日
    *
 */
@Controller
@RequestMapping("/upload1")
public class Upload1Controller {
	@Resource(name="uploadtype")
	private Upload1CourseService courseServiceImpl;
	@Resource
	private CommentService commentServiceImpl;
	@RequestMapping(value="/upload1",method=RequestMethod.POST)
	public String UploadCourse(		
			@RequestParam("catalog") String catalog,		
			@RequestParam("file") MultipartFile file,	
			@RequestParam("courseId") int courseId,
			HttpServletRequest request,
			Model model) {
		if(!file.isEmpty()&&StringUtils.isNotBlank(catalog)) {
			String path = "D:\\threeyear\\plailing\\WebContent\\videoes\\";
			System.out.println(path);
			String filename = StringUtils.substringBeforeLast(file.getOriginalFilename(),".");
			if(filename.length()>18) {
				filename = StringUtils.substringBeforeLast(file.getOriginalFilename(),".").substring(0, 18);
			}
			filename+=file.getOriginalFilename().substring(file.getOriginalFilename().length()-4, file.getOriginalFilename().length());
			File filepath = new File(path,filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
				}
			try {
				file.transferTo(new File(path + File.separator + filename));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			Course course=courseServiceImpl.GetCourse(courseId);
			courseServiceImpl.Save(course);
			CourseCatalog courseCatalog=new CourseCatalog();
			if(courseServiceImpl.findCatalog(catalog,courseId)==null) {
				courseCatalog.setCatalogName(catalog);
				courseCatalog.setCourse(course);
				courseServiceImpl.SaveCatalog(courseCatalog);
			}else {
				courseCatalog=courseServiceImpl.findCatalog(catalog,courseId);
			}
			CourseCatalog pCourseCatalog=new CourseCatalog();
			pCourseCatalog.setCatalogName(StringUtils.substringBeforeLast(filename,"."));
			pCourseCatalog.setCourseCatalog(courseCatalog);
			pCourseCatalog.setCourse(course);
			pCourseCatalog.setCourseFile("videoes\\"+filename);
			courseServiceImpl.SaveCatalog(pCourseCatalog);
				model.addAttribute("up", "1");
			}else { 
				
				model.addAttribute("up", "0");
			}

		System.out.println();
		return "upload3";

	}
	@RequestMapping("upload2")
	public String getUpload1jsp(@RequestParam("courseId") int courseId,HttpServletRequest request) {
		request.getServletContext().setAttribute("courseId", courseId);
		return "upload1";
	}
	@RequestMapping("upload3")
	public String getUpload2jsp(@RequestParam("courseId") int courseId,HttpServletRequest request) {
		request.getServletContext().setAttribute("courseId", courseId);
		return "upload2";
	}
}
