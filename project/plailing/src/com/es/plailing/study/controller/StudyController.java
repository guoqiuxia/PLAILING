package com.es.plailing.study.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserBalance;
import com.es.plailing.entity.UserJoinCourse;
import com.es.plailing.study.service.StudyServiceImpl;

/*
 * 
    * @ClassName: StudyController
    * @Description: TODO(study鐣岄潰鐨勬帶鍒跺櫒锛屾帶鍒惰烦杞紝璋冪敤service绫诲疄鐜版煡璇㈠姞鍏ョ殑璇剧▼)
    * @author 寮犳�濆槈
    * @date 2018骞�12鏈�3鏃�
    *
 */
@Controller
@RequestMapping("/user")
public class StudyController {
	@Resource
	private StudyServiceImpl studyServiceImpl;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String findJoinCourse(HttpServletRequest request,
			@RequestParam(value = "studyPageNum", defaultValue = "1") int studyPageNum) throws Exception {
		
		// 鑾峰彇鐢ㄦ埛韬唤
		String userEmail = (String) request.getSession().getAttribute("email");
		
		// 鐢ㄦ埛鍏呭�兼秷璐硅褰�
		Page<UserJoinCourse> studyListPage = new Page<UserJoinCourse>();
		studyListPage = studyServiceImpl.joinCourseByPage(studyPageNum, 9, userEmail);


		request.getSession().setAttribute("studyListPage", studyListPage);
		return "study";
	}

}
