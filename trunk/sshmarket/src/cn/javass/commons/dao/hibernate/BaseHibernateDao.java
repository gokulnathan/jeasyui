package cn.javass.commons.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.javass.commons.dao.IBaseDao;
import cn.javass.commons.pagination.PageUtil;

public abstract class BaseHibernateDao<M extends Serializable, PK extends Serializable>
		extends HibernateDaoSupport implements IBaseDao<M, PK> {

	private Class<M> entityClass;

	private String HQL_LIST_ALL;

	private String HQL_COUNT_ALL;

	/**
	 * 通过初始化方法在依赖注入完毕时生成HQL
	 */
	@SuppressWarnings("unchecked")
	public void init() {
		// 通过反射获取注解为M（模型对象）的类类型
		this.entityClass = (Class<M>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		// 得到模型对象的实体名
		String entityName = getSessionFactory().getClassMetadata(
				this.entityClass).getEntityName();
		
		//根据实体名生成HQL，这里指实际对象名，同时会根据配置映射到数据库名称
		this.HQL_LIST_ALL = " FROM " + entityName;
		
		this.HQL_COUNT_ALL = " SELECT COUNT(*) FROM " + entityName;
		
	}

	@Override
	public void save(M mode) {
		
		getHibernateTemplate().save(mode);
		
	}

	@Override
	public void saveOrUpdate(M model) {

		getHibernateTemplate().saveOrUpdate(model);
	}

	@Override
	public void update(M model) {

		this.getHibernateTemplate().update(model);
	}

	@Override
	public void merge(M model) {

		this.getHibernateTemplate().merge(model);
	}

	@Override
	public void delete(PK id) {

		this.getHibernateTemplate().delete(this.get(id));
	}

	@Override
	public M get(PK id) {

		return this.getHibernateTemplate().get(this.entityClass, id);
	}

	@Override
	public int countAll() {

		Number total = unique(getCouhtAllSql());
		return total.intValue();
	}

	/**
	 * 根据查询条件返回唯一记录
	 * @param couhtAllSql
	 * 查询语句
	 * @param <T> 
	 * 返回类型
	 * @return
	 */
	protected <T> T unique(final String hql, final Object...paramList) {
		return getHibernateTemplate().execute(new HibernateCallback<T>() {
			@SuppressWarnings("unchecked")
			@Override
			public T doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				
				if(paramList != null) {
					for (int i = 0; i < paramList.length; i++) {
						query.setParameter(i, paramList[i]);
					}
				}
				
				return (T) query.setMaxResults(1).uniqueResult();
			}});
	}

	/**
	 * 获得查询SQL 
	 * SELECT COUNT(*) FROM + entityName
	 * @return
	 */
	private String getCouhtAllSql() {
		return getHQL_COUNT_ALL();
	}

	/**
	 * 查询所有的记录
	 */
	@Override
	public List<M> listAll() {

		return list(getHQL_LIST_ALL());
	}

	public List<M> list(final String sql, final Object...paramList) {
		return list(sql, -1,-1,paramList);
	}

	@Override
	public List<M> listAll(int pn, int pageSize) {

		return list(getHQL_LIST_ALL(), pn, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	protected <T> List<T> list(final String sql, final int pn, final int pageSize, final Object...paramList) {
		
		
		return getHibernateTemplate().executeFind(new HibernateCallback<List<T>>() {

			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(sql);
				
				if(paramList != null) {
					for (int i = 0; i < paramList.length; i++) {
						query.setParameter(i, paramList[i]);//设置占位符参数
					}
				}
				
				//分页处理
				if(pn > -1 && pageSize > -1) {
					query.setMaxResults(pageSize);//设置每页获取的最大记录数。
					int start = PageUtil.getPageStart(pn, pageSize);//某页从哪一条开始
					if(start != 0) {
						query.setFirstResult(start);//设置记录开始的地方
					}
				}
				
				return query.list();
			}
			
		});
	}

	/**
	 * 只生成GET方法
	 * @return
	 */
	public String getHQL_LIST_ALL() {
		return this.HQL_LIST_ALL;
	}

	/**
	 * 只生成GET方法
	 * @return
	 */
	public String getHQL_COUNT_ALL() {
		return this.HQL_COUNT_ALL;
	}
	
	

}
