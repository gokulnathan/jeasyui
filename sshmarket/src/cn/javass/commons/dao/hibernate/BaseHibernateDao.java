package cn.javass.commons.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.javass.commons.dao.IBaseDao;

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

	}

	@Override
	public void merge(M model) {

	}

	@Override
	public void delete(PK id) {

	}

	@Override
	public M get(PK id) {

		return null;
	}

	@Override
	public int countAll() {

		return 0;
	}

	@Override
	public List<M> listAll() {

		return null;
	}

	@Override
	public List<M> listAll(int pn, int pageSize) {

		return null;
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
