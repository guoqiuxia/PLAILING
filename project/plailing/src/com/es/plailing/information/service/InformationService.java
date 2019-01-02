package com.es.plailing.information.service;



import org.springframework.stereotype.Service;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
/**
 * 
    * @ClassName: InformationService
    * @Description: TODO(information页面service接口类)
    * @author 梁雅茹
    * @date 2018年12月8日
    *
 */
@Service
public interface InformationService{
	public User getTheUser(int userId);
	public User getTheUserByEmail(String email);
	public Page<Course> listPersonCourses(int pageNum, int pageSize,User user);
	public boolean checkFollow(User user1,User user2);
	public void addFollow(User user1,User user2);
	public void deleteFollow(User user1,User user2);
}
