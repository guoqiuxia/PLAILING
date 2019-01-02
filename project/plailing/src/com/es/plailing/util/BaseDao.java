package com.es.plailing.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Page;

/**
 * @desc 用于Spring整合Hibernate之后，数据持久层代码的封装。提供了基本的数据增删改查，以及基于HQL的查询、分页查询，基于SQL的查询、分页查询等。
 *
 * @author wangwei
 * @param <T> 实体类
 * @param <PK> 实体类的OID，对应表的主键字段
 */
@Repository
public abstract class BaseDao<T,PK extends Serializable> {

	private Class<T> entityClass;

	@Resource
	protected SessionFactory sessionFactory;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseDao() {
		Class c = getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.entityClass = (Class<T>) p[0];
		}
	}

	// **************基本增删改查*********************

	public void save(T entity) throws Exception {
		this.sessionFactory.getCurrentSession().save(entity);
	}

	public void update(T entity) throws Exception {
		this.sessionFactory.getCurrentSession().update(entity);
	}

	public void delete(Object entity) throws Exception {
		this.sessionFactory.getCurrentSession().delete(entity);
	}

	public void delete(Serializable id) throws Exception {
		this.delete(this.sessionFactory.getCurrentSession().load(entityClass, id));
	}

	public T get(Serializable id) throws Exception {
		return (T) this.sessionFactory.getCurrentSession().get(entityClass, id);
	}

	public T load(Serializable id) throws Exception {
		return (T) this.sessionFactory.getCurrentSession().load(entityClass, id);
	}

	// **************HQL***************************

	/**
	 * @desc 根据hql语句，查询单个实体类的对象
	 * @param hql hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return 单个实体类的对象
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public T findOne(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return (T) query.uniqueResult();
	}

	/**
	 * @desc 查询全部数据
	 * @return 全部数据的List集合
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from " + entityClass.getSimpleName());
		return query.list();
	}

	/**
	 * 
	 * @desc 根据hql语句，按条件查询数据
	 * @param hql hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return 按条件查询出数据的List集合
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return query.list();
	}

	/**
	 * @desc 统计全部数据数量
	 * @return 全部数据的数量
	 * @throws Exception
	 */
	public Long findCount() throws Exception {
		Query query = this.sessionFactory.getCurrentSession()
				.createQuery("select count(" + entityClass.getSimpleName() + ") from " + entityClass.getSimpleName());
		return (Long) query.uniqueResult();
	}

	/**
	 * @desc 分页查询全部数据
	 * @param pageNum 页码
	 * @param pageSize 每页数据个数
	 * @return Page的对象
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Page<T> findPage(int pageNum, int pageSize) throws Exception {
		long total = this.findCount();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from " + entityClass.getSimpleName());
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<T> rows = query.list();
		return new Page<T>(pageNum, pageSize, (int) total, rows);
	}

	/**
	 * @desc 根据hql，按条件查询数据数量
	 * @param hql hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return 数据数量
	 * @throws Exception
	 */
	public Long findCount(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return (Long) query.uniqueResult();
	}

	/**
	 * @desc 按条件分页查询数据
	 * @param pageNum 页码
	 * @param pageSize 每页数据个数
	 * @param hql hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return 查询出的数据，List集合
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(int pageNum, int pageSize, String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @desc 分页查询
	 * @param pageNum 页码
	 * @param pageSize 每页数据个数
	 * @param hqlCount 用于统计数据个数的hql语句
	 * @param hqlList 用于查询数据的hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return Page对象
	 * @throws Exception
	 */
	public Page<T> findPage(int pageNum, int pageSize, String hqlCount, String hqlList, Object[] params)
			throws Exception {
		long total = findCount(hqlCount, params);
		List<T> rows = find(pageNum, pageSize, hqlList, params);
		return new Page<T>(pageNum, pageSize, (int) total, rows);
	}

	/**
	 * @desc 根据hql，按条件进行投影查询
	 * @param hql hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return List集合，集合中数据是对象数组
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findByProjection(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return query.list();
	}

	/**
	 * @desc 根据hql，按条件进行分页的投影查询
	 * @param pageNum 页码
	 * @param pageSize 每页数据个数
	 * @param hql hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return List集合，集合中数据是对象数组
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> findByProjection(int pageNum, int pageSize, String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @desc 根据hql，按条件进行分页的投影查询
	 * @param pageNum 页码
	 * @param pageSize 每页数据个数
	 * @param hqlCount 用于统计数量的hql语句
	 * @param hqlList 用于查询的hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return Page对象
	 * @throws Exception
	 */
	public Page<Object[]> findPageByProjection(int pageNum, int pageSize, String hqlCount, String hqlList,
			Object[] params) throws Exception {
		long total = findCount(hqlCount, params);
		List<Object[]> rows = findByProjection(pageNum, pageSize, hqlList, params);
		return new Page<Object[]>(pageNum, pageSize, (int) total, rows);
	}

	// **************SQL***************************
	/**
	 * @desc 通过原生SQL进行新增，修改，删除
	 * @param sql sql语句
	 * @param params sql语句中占位符对应的参数
	 * @return 执行sql语句所影响的行数
	 * @throws Exception
	 */
	public int excuteBySql(String sql, Object[] params) throws Exception {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return query.executeUpdate();
	}

	/**
	 * @desc 通过原生SQL进行查询，返回单个结果集，以Map<String, Object>形式存放
	 * @param sql sql语句
	 * @param params sql语句中占位符对应的参数
	 * @return 查询出的数据
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> findOneBySql(String sql, Object[] params) throws Exception {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return (Map<String, Object>) query.uniqueResult();
	}

	/**
	 * @desc 通过原生SQL进行查询，返回多个结果集，以List<Map<String, Object>>形式存放
	 * @param sql sql语句
	 * @param params sql语句中占位符对应的参数
	 * @return 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findBySql(String sql, Object[] params) throws Exception {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return query.list();
	}

	/**
	 * @desc 分页原生SQL进行统计数量
	 * @param sql sql语句
	 * @param params sql语句中占位符对应的参数
	 * @return 统计的数量
	 * @throws Exception
	 */
	public Long findCountBySql(String sql, Object[] params) throws Exception {
		SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return (Long) query.uniqueResult();
	}

	/**
	 * @desc 分页原生SQL进行查询
	 * @param sql sql语句
	 * @param params sql语句中占位符对应的参数
	 * @param pageNum 页码
	 * @param pageSize 每页数据个数
	 * @return 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findBySql(String sql, Object[] params, int pageNum, int pageSize)
			throws Exception {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @desc 分页原生SQL进行查询
	 * @param pageNum 页码
	 * @param pageSize 每页数据个数
	 * @param sqlCount 统计数据总数的sql语句
	 * @param sqlList 查询分页数据的sql语句
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Page<Map<String, Object>> findPageBySql(int pageNum, int pageSize, String sqlCount, String sqlList, Object[] params)
			throws Exception {
		long total = this.findCountBySql(sqlCount, params);
		List<Map<String, Object>> rows = this.findBySql(sqlList, params, pageNum, pageSize);
		return new Page<Map<String, Object>>(pageNum, pageSize, (int) total, rows);
	}

}
