package cn.javass.point.web.admin.action;

import cn.javass.commons.web.action.BaseAction;
import cn.javass.point.model.GoodsModel;
import cn.javass.point.service.IGoodsCodeService;
import cn.javass.point.service.IGoodsService;

/**
 * 商品兑换码后台管理ACTION
 * 
 * @author AB029789
 * 
 */
public class GoodsCodeAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	// 依赖注入
	private IGoodsService goodsService;

	// 依赖注入
	private IGoodsCodeService goodsCodeService;

	// 驱动形式注入
	private int id = -1;

	// 驱动形式注入,商品ID
	private int goodsId = -1;

	// 驱动形式注入
	private String codes;

	// //驱动形式注入，商品兑换码
	private GoodsModel goodsCode;

	/**
	 * 展示商品兑换码
	 * 
	 * @return
	 */
	public String list() {
		// 设置商品
		getValueStack().set(MODEL, goodsService.get(goodsId));
		getValueStack().set(PAGE,
				goodsCodeService.listAllByGoods(getPn(), goodsId));
		return LIST;

	}

	// 新增页面
	public String doAdd() {

		getValueStack().set(MODEL, goodsService.get(goodsId));

		return ADD;

	}

	/**
	 * 保存兑换码
	 * 
	 * @return
	 */
	public String add() {
		String[] codes = splitCode();
		goodsCodeService.save(goodsId, codes);
		return REDIRECT;
	}

	/**
	 * 
	 * @return
	 */
	private String[] splitCode() {
		return codes == null ? new String[0] : codes.split("\r");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

	public GoodsModel getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(GoodsModel goodsCode) {
		this.goodsCode = goodsCode;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public void setGoodsCodeService(IGoodsCodeService goodsCodeService) {
		this.goodsCodeService = goodsCodeService;
	}

}
