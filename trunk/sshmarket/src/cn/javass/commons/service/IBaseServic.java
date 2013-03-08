package cn.javass.commons.service;

import java.io.Serializable;
import java.util.List;

import cn.javass.commons.pagination.Page;

/**
 * 通用业务逻辑层接口
 * @author Jerry
 *
 * @param <M>
 * @param <PK>
 */
public interface IBaseServic<M extends Serializable, PK extends Serializable> {

	public M save(M model);//保存模型对象
	
	public void saveOrUpdate(M model);//保存或更新模型对象
	
	public void update(M model);//更新模型对象
	
	public void merge(M model);//合并模型对象
	
	public void delete(PK id);//删除模型对象
	
	public M get(PK id);//获取模型对象
	
	public int countAll();//统计模型对象数
	
	public List<M> listAll();//获取所有的记录集
	
	public Page<M> listAll(int pn);//分页获取默认分页大小的模型对象,从某个页码开始
	
	public Page<M> listAll(int pageNumber, int pageSize);//分页获取所有模型对象,从某个页码开始，根据每页记录数。
	
	
}
