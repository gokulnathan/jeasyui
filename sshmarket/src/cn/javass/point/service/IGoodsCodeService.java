package cn.javass.point.service;

import cn.javass.commons.pagination.Page;
import cn.javass.commons.service.IBaseService;
import cn.javass.point.exception.NotCodeException;
import cn.javass.point.model.GoodsCodeModel;

public interface IGoodsCodeService extends IBaseService<GoodsCodeModel, Integer> {

	/**根据页码和商品ID查询所有商品兑换码分页对象**/
	public Page<GoodsCodeModel> listAllByGoods(int pn, int goodsId);
	
	/**新增指定商品的兑换码*/
	public void save(int goodsId, String[] codes);
	
	/**购买指定商品的兑换码**/
	GoodsCodeModel buy(String username, int goodsId) throws NotCodeException;
	
	
	
}
