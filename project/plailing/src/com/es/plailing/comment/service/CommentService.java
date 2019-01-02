package com.es.plailing.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Comment;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
import com.es.plailing.util.BaseDao;
@Service
public interface CommentService {
	/**
	 * 
	    * @Title: Find
	    * @Description: TODO(根据课程目录id分页查询评论)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param catalogId
	    * @param @return    参数
	    * @return Page<Comment>    返回类型
	    * @throws
	 */
	public Page<Comment> Find(int pageNum, int pageSize, int catalogId);
	/**
	 * 
	    * @Title: Save
	    * @Description: TODO(数据库插入评论)
	    * @param @param entity    参数
	    * @return void    返回类型
	    * @throws
	 */
	public void Save(Comment entity);
	/**
	 * 
	    * @Title: Get
	    * @Description: TODO(根据评论id查找评论)
	    * @param @param id
	    * @param @return    参数
	    * @return Comment    返回类型
	    * @throws
	 */
	public Comment Get(Integer id);
	/**
	 * 
	    * @Title: FindSon
	    * @Description: TODO(根据父评论查找子评论)
	    * @param @param top
	    * @param @return    参数
	    * @return List<Comment>    返回类型
	    * @throws
	 */
	public List<Comment> FindSon(int top);
	/**
	 * 
	    * @Title: FindOne
	    * @Description: TODO(根据评论内容查找评论)
	    * @param @param text
	    * @param @return    参数
	    * @return Comment    返回类型
	    * @throws
	 */
	public Comment FindOne(String text);
	/**
	 * 
	    * @Title: FindUser
	    * @Description: TODO(根据用户email查找用户)
	    * @param @param email
	    * @param @return    参数
	    * @return User    返回类型
	    * @throws
	 */
	public User FindUser(String email);
	/**
	 * 
	    * @Title: getSingleCourse
	    * @Description: TODO(根据课程目录id查询课程)
	    * @param @param catalogId
	    * @param @return    参数
	    * @return CourseCatalog    返回类型
	    * @throws
	 */
	public CourseCatalog getSingleCourse(int catalogId);
	/**
	 * 
	    * @Title: getTeacher
	    * @Description: TODO(根据课程目录id查询上传用户)
	    * @param @param catalogId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return User    返回类型
	    * @throws
	 */
	public User getTeacher(int catalogId);
	/**
	 * 
	    * @Title: listCourseCatalog
	    * @Description: TODO(按照页数显示目录)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param courseId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<CourseCatalog>    返回类型
	    * @throws
	 */
	public List<CourseCatalog> listCourseCatalog(int pageNum,int pageSize,int courseId);
	/**
	 * 
	    * @Title: listComment
	    * @Description: TODO(按照页数查找评论)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param catalogId
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<Comment>    返回类型
	    * @throws
	 */
	public List<Comment> listComment(int pageNum,int pageSize,int catalogId);
	/**
	 * 
	    * @Title: listCourseCatalogByPid
	    * @Description: TODO(通过父目录找到子目录)
	    * @param @param pid
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<CourseCatalog>    返回类型
	    * @throws
	 */
	public List<CourseCatalog> listCourseCatalogByPid(int pid);
}
