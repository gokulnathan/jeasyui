package cn.javass.point.web.admin.action;

import cn.javass.commons.web.action.BaseAction;
import cn.javass.point.model.GoodsModel;
import cn.javass.point.service.IGoodsService;

/**
 * 商品管理
 * 
 * @author Jerry
 * 
 */
public class GoodsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 字段驱动数据填充,新增时生成新的对象，以便前端填充数据。
	private GoodsModel goods;

	private int id = -1;

	public GoodsModel getGoods() {
		return goods;
	}

	public void setGoods(GoodsModel goods) {
		this.goods = goods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/** 依赖注入 **/
	private IGoodsService goodsService;

	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * 列表，展示所有商品，包括未发布的商品
	 * 
	 * @return
	 */
	public String list() {

		getValueStack().set(PAGE, goodsService.listAll(getPn()));

		return LIST;
	}

	/**
	 * 到新增页面
	 * 
	 * @return
	 */
	public String doAdd() {
		goods = new GoodsModel();
		getValueStack().set(MODEL, goods);
		return ADD;
	}

	/**
	 * 保存新增的商品
	 * 
	 * @return
	 */
	public String add() {
		goodsService.save(goods);
		return REDIRECT;
	}

}
