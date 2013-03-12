package cn.javass.point.dao;

import java.util.List;

import cn.javass.commons.dao.IBaseDao;
import cn.javass.point.exception.NotCodeException;
import cn.javass.point.model.GoodsCodeModel;

/**
 * 商品模型对象Dao接口
 * @author Jerry
 *
 */
public interface IGoodsCodeDao extends IBaseDao<GoodsCodeModel, Integer> {

	/**
	 * 根据商品ID统计兑换的记录次数
	 * @param goodsId
	 * @return
	 */
	public int countAllByGoods(int goodsId);
	
	/**
	 * 根据商品ID查询兑换列表
	 * @param pn
	 * @param goodsId
	 * @return
	 */
	public List<GoodsCodeModel> listAllByGoods(int pn, int goodsId);
	
	public  GoodsCodeModel getOneNotExchanged(int goodsId) throws NotCodeException;
	
}
