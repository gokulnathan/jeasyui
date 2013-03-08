package cn.javass.commons.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<M extends Serializable, PK extends Serializable> {

	public void save(M mode);//保存模型对象
	
	public void saveOrUpdate(M model); //保存或更新模型对象 
	
	public void update(M model); //更新模型对象
	
	public void merge(M model); //合并模型对象到底层会话
	
	public void delete(PK id); //根据主键删除一个模型对象
	
	public M get(PK id); //根据主键获取模型对象
	
	public int countAll(); //统计模型对象对应的数据库表中的记录数
	
	public List<M> listAll(); //查询所有的模型对象 
	
	public List<M> listAll(int pn, int pageSize); //分页获取的模型对象
		
}
