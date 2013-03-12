package cn.javass.point.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import cn.javass.commons.Constants;
import cn.javass.commons.pagination.Page;
import cn.javass.commons.pagination.PageUtil;
import cn.javass.commons.service.impl.BaseServiceImpl;
import cn.javass.point.dao.IGoodsCodeDao;
import cn.javass.point.exception.NotCodeException;
import cn.javass.point.model.GoodsCodeModel;
import cn.javass.point.model.GoodsModel;
import cn.javass.point.service.IGoodsCodeService;
import cn.javass.point.service.IGoodsService;

public class GoodsCodeServiceImpl extends
		BaseServiceImpl<GoodsCodeModel, Integer> implements IGoodsCodeService {

	private IGoodsService goodsService;

	/**
	 * 获得GoodsCodeDao
	 * 
	 * @return
	 */
	private IGoodsCodeDao getGoodsCodeDao() {
		return (IGoodsCodeDao) super.getBaseDao();
	}

	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@Override
	public Page<GoodsCodeModel> listAllByGoods(int pn, int goodsId) {

		Integer count = getGoodsCodeDao().countAllByGoods(goodsId);
		List<GoodsCodeModel> items = getGoodsCodeDao().listAllByGoods(pn,
				goodsId);
		return PageUtil.getPage(count, pn, items, Constants.DEFAULT_PAGE_SIZE);
	}

	@Override
	public void save(int goodsId, String[] codes) {
		// 获得商品
		GoodsModel goods = goodsService.get(goodsId);
		for (String code : codes) {
			if (StringUtils.hasText(code)) {
				GoodsCodeModel goodsCode = new GoodsCodeModel();
				goodsCode.setCode(code);
				goodsCode.setGoods(goods);
				save(goodsCode);
			}
		}
	}

	@Override
	public GoodsCodeModel buy(String username, int goodsId)
			throws NotCodeException {

		// 验证用户积分是否充足
		// 其他逻辑判断
		// 记录交易开始
		GoodsCodeModel goodsCode = getGoodsCodeDao()
				.getOneNotExchanged(goodsId);
		if (null == goodsCode) {
			// 记录交易失败
			throw new NotCodeException("交易未成功");
		}
		goodsCode.setExchanged(true);
		goodsCode.setExchangeTime(new Date());
		goodsCode.setUsername(username);
		return goodsCode;
	}

}
