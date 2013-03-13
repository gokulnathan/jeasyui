package cn.javass.point.web.front.action;

import cn.javass.commons.web.action.BaseAction;
import cn.javass.point.exception.NotCodeException;
import cn.javass.point.model.GoodsCodeModel;
import cn.javass.point.service.IGoodsCodeService;
import cn.javass.point.service.IGoodsService;

/**
 * 前端商品ACTION
 * 
 * @author AB029789
 * 
 */
public class GoodsAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	public static final String BUYRESULT = "buyResult";

	// 依赖注入
	IGoodsService goodsService;

	// 依赖注入
	IGoodsCodeService goodsCodeService;

	// 字段驱动数据填充
	private int goodsId;

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * 展示所有发布的商品
	 * 
	 * @return
	 */
	public String list() {
		getValueStack().set(PAGE, goodsService.listAllPublished(getPn()));
		return LIST;
	}

	public String buy() {

		String username = "Jerry";

		GoodsCodeModel goodsCode = null;

		try {
			goodsCode = goodsCodeService.buy(username, goodsId);

		} catch (NotCodeException e) {

			this.addActionError("无足够的兑换码:" + e);

			return BUYRESULT;

		} catch (Exception e) {

			this.addActionError("未知错误:" + e);

			return BUYRESULT;

		}

		this.addActionMessage("购买成功，您的兑换码为：" + goodsCode.getCode());

		getValueStack().set(MODEL, goodsCode);

		return BUYRESULT;

	}

	public void setGoodsService(IGoodsService goodsService) {

		this.goodsService = goodsService;

	}

	public void setGoodsCodeService(IGoodsCodeService goodsCodeService) {

		this.goodsCodeService = goodsCodeService;

	}

}
