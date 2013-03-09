package cn.javass.commons.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.javass.commons.Constants;
import cn.javass.commons.dao.IBaseDao;
import cn.javass.commons.pagination.Page;
import cn.javass.commons.pagination.PageUtil;
import cn.javass.commons.service.IBaseService;

public class BaseServiceImpl<M extends Serializable, PK extends Serializable>
		implements IBaseService<M, PK> {

	private IBaseDao<M, PK> baseDao;
	
	public IBaseDao<M, PK> getBaseDao() {
		return baseDao;
	}
	
	/**
	 * 注入baseDao
	 * @param baseDao
	 */
	public void setBaseDao(IBaseDao<M, PK> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public M save(M model) {
		
		this.getBaseDao().save(model);
		
		return model;
	}

	@Override
	public void saveOrUpdate(M model) {
		
		this.getBaseDao().saveOrUpdate(model);
		
	}

	@Override
	public void update(M model) {
		
		this.getBaseDao().update(model);
		
	}

	@Override
	public void merge(M model) {
		
		this.getBaseDao().merge(model);
		
	}

	@Override
	public void delete(PK id) {
		
		this.getBaseDao().delete(id);
		
	}

	@Override
	public M get(PK id) {
		
		return this.getBaseDao().get(id);
	}

	@Override
	public int countAll() {
		
		return this.getBaseDao().countAll();
	}

	@Override
	public List<M> listAll() {
		
		return this.getBaseDao().listAll();
	}

	@Override
	public Page<M> listAll(int pn) {
		
		return this.listAll(pn, Constants.DEFAULT_PAGE_SIZE);
	}

	@Override
	public Page<M> listAll(int pageNumber, int pageSize) {
		
		Integer count = countAll();
		
		List<M> items = getBaseDao().listAll(pageNumber, pageSize);
		
		return PageUtil.getPage(count, pageNumber, items, pageSize);
	}

}
