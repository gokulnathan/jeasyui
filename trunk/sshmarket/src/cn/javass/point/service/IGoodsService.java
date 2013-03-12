package cn.javass.point.service;

import cn.javass.commons.pagination.Page;
import cn.javass.commons.service.IBaseService;
import cn.javass.point.model.GoodsModel;

public interface IGoodsService extends IBaseService<GoodsModel, Integer>{

	 /**根据页码查询所有已发布的商品的分页对象*/
	public Page<GoodsModel> listAllPublished(int pn);
	
}
