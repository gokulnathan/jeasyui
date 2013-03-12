package cn.javass.point.dao.hibernate;

import java.util.List;

import cn.javass.commons.Constants;
import cn.javass.commons.dao.hibernate.BaseHibernateDao;
import cn.javass.point.dao.IGoodsDao;
import cn.javass.point.model.GoodsModel;

public class GoodsHibernateDao extends BaseHibernateDao<GoodsModel, Integer> implements IGoodsDao {
	
	//覆盖父类方法，不进行物理删除
	@Override
	public void delete(Integer id) {
		GoodsModel goods = get(id);
		goods.setDeleted(true);
		update(goods);
	}
	
	//查询没有进行删除的数据
	@Override
	public String getHQL_COUNT_ALL() {
		return super.getHQL_COUNT_ALL() + " where delete = false";
	}
	
	//查询没有删除的数据
	public String getHQL_LIST_ALL() {
		return super.getHQL_LIST_ALL() +  " where delete = false";
	}
	
	

	@Override
	public List<GoodsModel> listAllPublished(int pn) {
		String sql = getHQL_LIST_ALL() + " and published = true";
		return super.list(sql, pn, Constants.DEFAULT_PAGE_SIZE);
	}

	@Override
	public int countAllPublished() {
		String sql = getHQL_COUNT_ALL() + " and published = true";
		Number num = super.unique(sql);
		return num.intValue();
	}

		

}
