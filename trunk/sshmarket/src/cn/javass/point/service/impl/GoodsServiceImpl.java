package cn.javass.point.service.impl;

import java.util.List;

import cn.javass.commons.Constants;
import cn.javass.commons.pagination.Page;
import cn.javass.commons.pagination.PageUtil;
import cn.javass.commons.service.impl.BaseServiceImpl;
import cn.javass.point.dao.IGoodsDao;
import cn.javass.point.model.GoodsModel;
import cn.javass.point.service.IGoodsService;

public class GoodsServiceImpl extends BaseServiceImpl<GoodsModel, Integer>
		implements IGoodsService {

	IGoodsDao getGoodsDao() {
		return (IGoodsDao) super.getBaseDao();
	}

	@Override
	public Page<GoodsModel> listAllPublished(int pn) {
		int count = getGoodsDao().countAllPublished();
		List<GoodsModel> items = getGoodsDao().listAllPublished(pn);
		Page<GoodsModel> pageModel = PageUtil.getPage(count, pn, items, Constants.DEFAULT_PAGE_SIZE);
		return pageModel;
	}
}
