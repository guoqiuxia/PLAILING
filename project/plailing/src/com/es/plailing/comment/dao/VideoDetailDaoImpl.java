package com.es.plailing.comment.dao;
import org.springframework.stereotype.Repository;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.util.BaseDao;
/**
 * 
    * @ClassName: VideoDetailDaoImpl
    * @Description: TODO(videodetail关于目录的查询)
    * @author 梁雅茹
    * @date 2018年12月18日
    *
 */
@Repository
public class VideoDetailDaoImpl extends BaseDao<CourseCatalog,Integer>{
	public CourseCatalog getSingleCourse(int catalogId) throws Exception{
		return this.get(catalogId);
	}
}
