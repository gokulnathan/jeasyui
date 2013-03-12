package cn.javass.point.dao.hibernate;

import java.util.List;

import cn.javass.commons.Constants;
import cn.javass.commons.dao.hibernate.BaseHibernateDao;
import cn.javass.point.dao.IGoodsCodeDao;
import cn.javass.point.exception.NotCodeException;
import cn.javass.point.model.GoodsCodeModel;

public class GoodsCodeHibernateDao extends
		BaseHibernateDao<GoodsCodeModel, Integer> implements IGoodsCodeDao {

	// 根据某个商品ID，查询该商品的兑换码数量
	@Override
	public int countAllByGoods(int goodsId) {
		final String hql = super.getHQL_COUNT_ALL() + " where id = ? ";
		Number num = super.unique(hql, goodsId);
		return num.intValue();
	}

	// 根据某个商品ID，查询该商品的兑换码
	@Override
	public List<GoodsCodeModel> listAllByGoods(int pn, int goodsId) {

		final String sql = super.getHQL_LIST_ALL() + " where id = ?";

		return super.list(sql, pn, Constants.DEFAULT_PAGE_SIZE, goodsId);
	}

	// 获得一个商品没有没有被兑换的兑换码
	@Override
	public GoodsCodeModel getOneNotExchanged(final int goodsId)
			throws NotCodeException {
		final String sql = super.getHQL_LIST_ALL()
				+ " where goods.id = ? and exchanged=false";
		List<GoodsCodeModel> goodsCodeList = super.list(sql, goodsId);
		return goodsCodeList == null ? null : goodsCodeList.get(0);
	}

}
