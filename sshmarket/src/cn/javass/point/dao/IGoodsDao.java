package cn.javass.point.dao;

import java.util.List;

import cn.javass.commons.dao.IBaseDao;
import cn.javass.point.model.GoodsModel;

/**
 * 商品模型对象DAO
 * @author Jerry
 *
 */
public interface IGoodsDao extends IBaseDao<GoodsModel, Integer>{

	/**
	 * 查询所有已经发布的商品
	 * @param pn
	 * @return
	 */
	List<GoodsModel> listAllPublished(int pn);
	
	/**
	 * 统计所有已经发布的商品数量
	 * @return
	 */
	int countAllPublished();
}
