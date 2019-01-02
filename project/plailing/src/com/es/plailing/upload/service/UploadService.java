package com.es.plailing.upload.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;

@Service
public interface UploadService {
	/**
	 * 
	    * @Title: listCourseByUserId
	    * @Description: TODO(通过userId查找他上传的课程有哪些)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Page<Course>    返回类型
	    * @throws
	 */
	public Page<Course> listCourseByUserId(int pageNum,int pageSize,int userId);
	/**
	 * 
	    * @Title: getUserIdByEmail
	    * @Description: TODO(通过email找到用户的id)
	    * @param @param email
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	public int getUserIdByEmail(String email);

}
